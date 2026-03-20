# Learning log

## Phase 1: Project Setup & Core Architecture

### What I Learned

### Project structure

- Android projects use `libs.versions.toml` as a centralised version registry (equivalent to a monorepo root `package.json`) and `build.gradle.kts` to actually declare dependencies with `implementation`, `ksp`, or `testImplementation`
- Multi-module Android projects are conceptually similar to monorepos — each module has its own `build.gradle.kts`, enforced boundaries, and team ownership. Even though this project is small, it could be built with multiple modules. However, this would over-complicate things when I am trying to learn
- AGP (Android Gradle Plugin) is what makes Gradle understand how to build Android apps — it handles compiling against the Android SDK, packaging APKs, and managing the manifest

### Architecture

- Clean architecture separates concerns into three layers: data (storage), domain (business logic), presentation (UI). Each layer has a single job and dependencies only flow inward
- The domain layer has zero Android dependencies — it's pure Kotlin and easily testable. If you could rewrite the app as a web app, the domain layer would stay the same
- Hexagonal architecture aka ports and adapters: domain defines interfaces (ports), data provides implementations (adapters). This is the D in SOLID — dependency inversion
- Repository pattern: acts as a librarian 🧑‍🏫 between domain and data. You go to the librarian and say "I want all the stations on the Central line." You don't care whether the librarian gets that from a filing cabinet, a computer system, or a book aka Room, a network API or anywhere else. You just get back the list. The librarian handles where to find it.
- Use cases represent single pieces of business logic. They keep ViewModels thin and make business rules testable in isolation. They aren't necessary but they are good practice

### MVI pattern

- Model View Intent enforces unidirectional data flow: Action → ViewModel → State → UI → Action
- `UiState` is a data class — the single source of truth for what a screen looks like
- `UiAction` is a sealed interface — all possible user interactions, exhaustively handled in a when block
- `UiSideEffect` is a sealed interface — one-time events like navigation, snackbars, or launching the camera that shouldn't live in state
- `BaseViewModel` provides the StateFlow + Channel infrastructure so every screen's ViewModel follows identical plumbing (see below for some more context on this)

### Kotlin concepts

- Sealed classes/interfaces: the compiler knows every possible subtype, making when expressions exhaustive. If you add a new action and forget to handle it, the build fails
- Companion objects: Kotlin's equivalent of static methods. `TubeSpotterDatabase.seedCallback()` is callable without a database instance existing yet
- `operator fun invoke()`: lets use cases be called like functions — toggleStation(station) instead of toggleStation.execute(station)
- Annotations: metadata that tells the compiler or a tool how to handle something. `@Entity` tells Room to create a table, `@HiltViewModel` tells Hilt to manage ViewModel creation, `@Query` tells Room what SQL to run
- `suspend` functions: coroutine-aware functions that can be paused and resumed without blocking the main thread

### Room

- Entities map to database tables. `@Entity` on a class = create a table with matching columns
- DAOs define query functions as interfaces — Room generates the implementation at compile time via KSP
- Cross-reference tables model many-to-many relationships (a station can be on multiple lines)
- Flow-returning queries are live queries — Room re-emits whenever the underlying table changes, so the UI updates automatically without refresh logic

### Hilt

- `@Inject` constructor tells Hilt how to construct a class — no module entry needed for simple cases
- `@Provides` is for when construction requires actual code (like `Room.databaseBuilder(...)`)
- `@Binds` is for telling Hilt which implementation to use for an interface — more efficient, generates less code
- `@Singleton` ensures only one instance is created for the app's lifetime

### Coroutines and Flow

- Coroutines are Kotlin's async/await — do work in the background without blocking the UI thread
- Flow is a stream of values over time — emit now, keep emitting when data changes. Built on top of coroutines
- `suspend` = one time async operation (writes). Flow = ongoing reactive stream (reads)
- `flatMapLatest` = reactive switch. When the selected line filter changes, cancel the previous station flow and start a new one. Prevents race conditions

### What I Struggled With

### Version compatibility

- AGP 9.x has a known unfixed bug where Hilt cannot find `BaseExtension` — had to downgrade to AGP 8.7.3
- KSP versions must align with Kotlin versions
- Gradle daemon caching caused persistent errors after version changes — fixed by clearing `~/.gradle/caches` and `~/.gradle/daemon`

### Concepts that I questioned

- The difference between `libs.versions.toml` (registry) and `build.gradle.kts` (actual dependencies) — you need both
- Repository as a pattern vs GitHub repository — completely unrelated uses of the same word
- Flow vs coroutines — not interchangeable, complementary. Coroutines provide async context, Flow provides the stream of values
- Why use cases exist when the ViewModel could just call the repository directly — they isolate business logic and keep ViewModels thin

### Comparisons to React Native

| Concept               | React Native                    | Android                |
|-----------------------|---------------------------------|------------------------|
| Version registry      | `package.json` / monorepo root  | `libs.versions.toml`   |
| Multi-module          | Monorepo packages               | Gradle modules         |
| Async operations      | `async/await`, Promises         | Coroutines, `suspend`  |
| Reactive data streams | WebSockets, RxJS Observables    | Flow                   |
| State management      | Redux, Zustand, Context         | MVI + StateFlow        |
| Sealed actions        | TypeScript discriminated unions | Sealed interfaces      |
| Static methods        | `static` keyword                | Companion objects      |
| One-time events       | Custom event emitters           | UiSideEffect + Channel |
| Build plugins         | Babel plugins, Metro config     | Gradle plugins         |

#### Key insight
Android's reactive query pattern (Room + Flow) solves the same problem WebSockets are sometimes used for in RN — keeping UI in sync with changing data — but it's built into the ecosystem rather than something you have to implement yourself.

#### Key insight
The heavy architectural separation in Android (domain/data/presentation) is partly a response to Android's lifecycle complexity. Not separating concerns caused very visible bugs, so the ecosystem learned to separate things out of necessity. RN's flexibility means you can get away with messier code for longer.

### BaseViewModel — is it an anti-pattern?

Philipp Lackner argues that BaseViewModel is an anti-pattern, particularly in larger apps:

Violates Single Responsibility Principle — a base class that grows over time ends up doing too many things
Inheritance creates indirect coupling — subclasses are tied to whatever the base class does, even if they don't need it
Vague naming leads to invisible behaviour — if a BaseViewModel gains a `trackEvent()` function, engineers may not realise it exists and reimplement it elsewhere
The larger the base class grows, the more workarounds become necessary

His recommended alternative is composition over inheritance — utility functions and extension functions instead of a shared base class. If you genuinely only need state and side effects, those could live in each ViewModel directly rather than being inherited.
Why we're using it anyway
TubeSpotter is a single-developer learning project with a fixed small number of screens — none of the failure modes Lackner describes (team coordination problems, growing base class, invisible shared behaviour) apply here. More importantly, the goal is to mirror patterns from a professional Android codebase. Understanding BaseViewModel deeply — including its tradeoffs — is more valuable than avoiding it. The risks are real at scale; the benefits are real at learning scale.

## Phase 2: Line Filtering & Progress Tracking

### What I Learned

### Reactive stream switching with `flatMapLatest`

- `flatMapLatest` is a Flow operator that cancels the previous downstream flow and switches to a new one whenever the upstream emits. In this phase, the upstream was `uiState` and the downstream was either `getAllStations()` or `getStationsByLine(lineId)` depending on the selected filter
- Without `flatMapLatest`, changing the filter would not switch the data source — the old flow would keep emitting stale data
- You can think of it like a TV remote switching channels: `flatMapLatest` changes what you're watching and stops receiving the old signal
- This is preferable to maintaining a separate `MutableStateFlow` for the filter because it keeps a single source of truth — the selected line is already in `UiState`, so we can react to that directly

### Room JOIN queries

- When you need a filtered list from a related table, a raw `@Query` with a SQL JOIN is simpler than Room's `@Relation`/`@Transaction` approach
- `@Relation` is designed for loading nested object graphs (e.g. a `Line` with its full list of `Station` objects). For a flat filtered list, a JOIN is more direct and easier to reason about
- The cross-reference table did its thing here — querying stations by line is a single JOIN rather than loading everything and filtering in memory

### Relational data modelling

- The Phase 1 seed data had duplicate station rows (e.g. Paddington appeared three times, once per line). This worked for displaying a list but broke correctness — a visited toggle on one Paddington would not affect the others
- The correct model is one row per real-world entity with a cross-reference table encoding the many-to-many relationship. This is standard relational database design, not Android-specific
- Database Inspector in Android Studio (emulator only) was used for diagnosing this — `GROUP BY name HAVING count > 1` immediately surfaced all 47 duplicates

### Material 3 components

- `FilterChip` has a `selected` state that drives its visual appearance — you pass the boolean, Material 3 handles the filled/outlined styling
- `LazyRow` is the horizontal equivalent of `LazyColumn` — same API, same `key` lambda for stable recomposition
- `LinearProgressIndicator` takes a `progress` lambda that returns a `Float` between 0 and 1. Using a lambda (rather than a plain Float) tells Compose to skip recomposition of the surrounding layout when only the progress value changes — a small but real performance optimisation
- TfL line colours are stored as hex strings in the database. Converting to Compose `Color` requires `android.graphics.Color.parseColor()` — this stays in the presentation layer, domain never knows colours as anything other than strings

### What I Struggled With

### Duplicate seed data

- The Phase 1 seed data assigned a new ID to every station-line occurrence rather than modelling the many-to-many relationship correctly. This wasn't visible until filtering revealed that "visited" state was per-occurrence rather than per-station
- Fixing it required auditing ~270 stations, deduplicating IDs, and rewriting the cross-ref list — a reminder that data modelling decisions made early are expensive to fix later
- Uninstalling the app from the emulator was the "migration strategy" since this is pre-production — in a shipped app this would require a Room migration with a version bump

### Comparisons to React Native

| Concept                    | React Native                        | Android                            |
|----------------------------|-------------------------------------|------------------------------------|
| Reactive stream switching  | `switchMap` in RxJS                 | `flatMapLatest` in Flow            |
| Horizontal scrollable list | `FlatList` with `horizontal` prop   | `LazyRow`                          |
| Filter/chip UI             | Third-party libraries or custom     | `FilterChip` built into Material 3 |
| Progress bar               | Third-party or custom               | `LinearProgressIndicator` built in |
| Many-to-many data          | Join table in SQL or nested objects | Room cross-reference entity        |

#### Key insight
Material 3's component library is significantly more complete than what ships with React Native out of the box. Components like `FilterChip` and `LinearProgressIndicator` are production-quality with built-in theming, accessibility, and animation — no third-party dependency needed.
