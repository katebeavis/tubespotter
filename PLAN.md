# TubeSpotter - Project Plan

## Context

TubeSpotter is a personal Android app for tracking a London Underground roundel photo collection. It is also a structured learning project: each phase teaches specific Android concepts while following professional patterns (MVI, clean architecture, Hilt DI) studied from a production codebase.

The app tracks which of the ~272 tube stations the user has photographed, shows progress by line and across the network, and awards achievements for completing lines.

---

## Architecture Overview

### Stack
- **UI:** Jetpack Compose + Material 3
- **Pattern:** MVI (UiState / UiAction / UiSideEffect) via BaseViewModel
- **Layers:** data / domain / presentation (clean architecture, single module)
- **DI:** Hilt
- **Persistence:** Room
- **Images:** Coil
- **Navigation:** Navigation 3 (androidx.navigation3) with @Serializable routes
- **Async:** Kotlin Coroutines + Flow, collectAsStateWithLifecycle()

### Package Structure
```
com.katebeavis.tubespotter/
  data/
    local/
      db/TubeSpotterDatabase.kt
      dao/StationDao.kt, LineDao.kt, AchievementDao.kt
      entity/StationEntity.kt, LineEntity.kt, StationLineCrossRef.kt, AchievementEntity.kt
      seed/StationSeedData.kt
    repository/StationRepositoryImpl.kt, AchievementRepositoryImpl.kt
  di/DatabaseModule.kt, RepositoryModule.kt
  domain/
    model/Station.kt, Line.kt, Achievement.kt
    repository/StationRepository.kt, AchievementRepository.kt
    usecase/...
  presentation/
    common/
      mvi/BaseViewModel.kt, UiState.kt, UiAction.kt, UiSideEffect.kt
      theme/Theme.kt, Color.kt, Type.kt
    stationlist/...
    stationdetail/...
    achievements/...
    navigation/Routes.kt, TubeSpotterNavGraph.kt
  MainActivity.kt
  TubeSpotterApp.kt (Hilt Application class)
```

### Why Clean Architecture?

Each layer has a clear job: **data** handles Room/storage, **domain** holds business logic and repository interfaces, **presentation** manages UI and state. This means the domain layer has zero Android dependencies and is trivially testable. The presentation layer depends on domain (never on data directly). This mirrors hexagonal architecture principles.

### The BaseViewModel Pattern

Every screen's ViewModel extends BaseViewModel which provides:
- `_uiState: MutableStateFlow<S>` exposed as `uiState: StateFlow<S>` -- single source of truth for screen state
- `_sideEffect: Channel<E>` exposed as `sideEffect: Flow<E>` -- one-time events (navigation, toasts, camera launch)
- `postAction(action: A)` -- entry point for all user interactions
- `abstract fun handleAction(action: A)` -- sealed when dispatch in each ViewModel

**Why MVI?** Unidirectional data flow makes state predictable. Every state change comes from an action, every UI rendering comes from a single state object. This eliminates a class of bugs where UI is out of sync with data.

### Screen + Content Composable Pattern

Every screen has two composables:
- **Screen** composable: Wired to ViewModel, collects state with `collectAsStateWithLifecycle()`, handles side effects, calls Content
- **Content** composable: Pure function of state, no ViewModel reference, fully previewable

**Why?** Content is trivially previewable and testable. Screen handles the "plumbing". This is the same pattern used in the Zopa codebase (ADR-004).

### Room Database Schema

```
stations: id (PK), name, zone, isVisited, visitedAt, photoUri
lines: id (PK), name, colour, displayOrder
station_line_cross_ref: stationId (FK), lineId (FK) -- many-to-many
achievements: id (PK), lineId (FK), unlockedAt (nullable)
```

**Why a cross-ref table?** Stations can be on multiple lines (e.g. Baker Street is on 5 lines). A many-to-many relationship with a cross-reference table is the correct relational model.

### Seed Data Approach

Station and line data is static (it changes rarely). Pre-populate the Room database using `RoomDatabase.Callback` with `onCreate`. Define all station/line data in `StationSeedData.kt` as Kotlin lists. This runs once on first install.

All 11 lines: Bakerloo, Central, Circle, District, Hammersmith & City, Jubilee, Metropolitan, Northern, Piccadilly, Victoria, Waterloo & City. ~272 stations total.

---

## Phase 1: Station List with Check-Off

**Goal:** A scrollable list of all tube stations that can be toggled as visited/unvisited. This is the MVP.

**Status: Not Started**

### What You Will Learn
- Project setup with Gradle version catalogs
- Room database: entities, DAOs, database class, pre-population
- Hilt dependency injection: modules, @HiltViewModel, @AndroidEntryPoint
- Jetpack Compose: LazyColumn, Material 3 components
- MVI pattern: BaseViewModel, UiState, UiAction, UiSideEffect
- StateFlow collection with collectAsStateWithLifecycle()
- Clean architecture layer separation
- Unit testing with MockK, Truth, and UnconfinedTestDispatcher

### Files to Create

```
Project setup:
  build.gradle.kts (project + app)
  gradle/libs.versions.toml
  settings.gradle.kts

Core infrastructure:
  TubeSpotterApp.kt                                    -- @HiltAndroidApp Application class
  MainActivity.kt                                      -- @AndroidEntryPoint, setContent

MVI base (presentation/common/mvi/):
  UiState.kt                                           -- Marker interface
  UiAction.kt                                          -- Marker interface
  UiSideEffect.kt                                      -- Marker interface
  BaseViewModel.kt                                     -- StateFlow + Channel + handleAction

Theme (presentation/common/theme/):
  Color.kt                                             -- TfL line colours + app colours
  Type.kt                                              -- Typography
  Theme.kt                                             -- TubeSpotterTheme composable

Data layer:
  data/local/entity/StationEntity.kt                   -- @Entity: id, name, zone, isVisited, visitedAt, photoUri
  data/local/entity/LineEntity.kt                      -- @Entity: id, name, colour, displayOrder
  data/local/entity/StationLineCrossRef.kt             -- @Entity: stationId, lineId
  data/local/dao/StationDao.kt                         -- getAllStations, toggleVisited, getStationsByLine
  data/local/dao/LineDao.kt                            -- getAllLines
  data/local/db/TubeSpotterDatabase.kt                 -- @Database with entities and seed callback
  data/local/seed/StationSeedData.kt                   -- All 272 stations, 11 lines, cross-refs
  data/repository/StationRepositoryImpl.kt             -- Implements domain interface

DI:
  di/DatabaseModule.kt                                 -- @Provides database, DAOs
  di/RepositoryModule.kt                               -- @Binds repository interface to impl

Domain layer:
  domain/model/Station.kt                              -- Data class: id, name, zone, isVisited, visitedAt
  domain/repository/StationRepository.kt               -- Interface
  domain/usecase/GetAllStationsUseCase.kt              -- Returns Flow<List<Station>>
  domain/usecase/ToggleStationVisitedUseCase.kt        -- Toggles and persists

Presentation:
  presentation/stationlist/viewmodel/StationListUiState.kt
  presentation/stationlist/viewmodel/StationListUiAction.kt     -- ToggleStation(id)
  presentation/stationlist/viewmodel/StationListUiSideEffect.kt -- Empty for now
  presentation/stationlist/viewmodel/StationListViewModel.kt
  presentation/stationlist/StationListScreen.kt                 -- Screen + Content
  presentation/stationlist/components/StationItem.kt            -- Row composable

Tests:
  domain/usecase/GetAllStationsUseCaseTest.kt
  domain/usecase/ToggleStationVisitedUseCaseTest.kt
  presentation/stationlist/viewmodel/StationListViewModelTest.kt
```

### Key Design Decisions

**UiState structure** -- Use a data class (not sealed interface) since the list always has data (pre-seeded):
```kotlin
data class StationListUiState(
    val stations: List<StationItem> = emptyList(),
    val visitedCount: Int = 0,
    val totalCount: Int = 0,
) : UiState
```

**Why `invoke()` operator on use cases?** Following the professional pattern, use cases have a single public `operator fun invoke()` method. This allows calling them like functions: `getAllStations()` instead of `getAllStations.execute()`. Clean and conventional.

**Why repository interfaces in domain?** The domain layer defines what it needs (interface), the data layer provides it (implementation). Domain never depends on Room, Android, or any framework. This is dependency inversion -- the D in SOLID.

### Testing Strategy
- **Use case tests:** Mock repository, verify correct data transformation
- **ViewModel tests:** Mock use cases, verify state transitions for each action
- **Pattern:** UnconfinedTestDispatcher, Dispatchers.setMain/resetMain, MockK for mocks, Truth for assertions

### Definition of Done
- [ ] Project compiles and runs on emulator
- [ ] Room database created with seed data for all 272 stations
- [ ] BaseViewModel established and working
- [ ] Station list displays all stations in a LazyColumn
- [ ] Tapping a station toggles visited state (checkbox or icon change)
- [ ] Visited count shown (e.g. "12 / 272 stations visited")
- [ ] State persists across app restarts
- [ ] Screen/Content split pattern implemented
- [ ] Unit tests for use cases and ViewModel
- [ ] All tests passing

---

## Phase 2: Line Filtering and Progress Tracking

**Goal:** Filter the station list by tube line. Show progress bars per line. Add a summary header.

**Status: Not Started**

### What You Will Learn
- Room relations and multi-table queries (@Transaction, @Relation)
- Compose state management with derived/computed state
- Material 3 components: FilterChip, LinearProgressIndicator, TopAppBar
- Flow operators: combine, map
- Expanding the MVI pattern with more actions

### Files to Create / Modify

```
New:
  domain/model/Line.kt                                  -- id, name, colour, stationCount, visitedCount
  domain/usecase/GetAllLinesUseCase.kt                   -- Lines with progress stats
  domain/usecase/GetStationsByLineUseCase.kt             -- Filtered station list
  presentation/stationlist/components/LineFilterChips.kt -- Horizontal scrolling chips
  presentation/stationlist/components/ProgressHeader.kt  -- Overall + per-line progress

Modify:
  StationDao.kt                                          -- Add getStationsByLineId query
  StationListUiState.kt                                  -- Add lines list, selectedLineId, progress
  StationListUiAction.kt                                 -- Add SelectLine(lineId), ClearFilter
  StationListViewModel.kt                                -- Handle new actions, combine flows

Tests:
  domain/usecase/GetAllLinesUseCaseTest.kt
  domain/usecase/GetStationsByLineUseCaseTest.kt
  StationListViewModelTest.kt                            -- Extend with filter tests
```

### Key Design Decisions

**Line colours** -- Each tube line has an official TfL colour. Store as hex string in LineEntity, convert to Compose Color in presentation layer. Never let domain know about Compose Color.

**Filter state in UiState** -- The selected line filter is UI state, not persisted. If the user leaves and comes back, showing all stations is fine.

### Definition of Done
- [ ] Line filter chips displayed horizontally above station list
- [ ] Tapping a chip filters to that line's stations
- [ ] Progress header shows "X / Y visited" with progress bar
- [ ] Per-line progress visible (when filter selected, or in a summary view)
- [ ] Clearing filter shows all stations
- [ ] Unit tests for new use cases and ViewModel actions
- [ ] All tests passing

---

## Phase 3: Photo Capture and Storage

**Goal:** Add camera/gallery photo capture per station. Display photo thumbnails in the list.

**Status: Not Started**

### What You Will Learn
- ActivityResult API (TakePicture, PickVisualMedia contracts)
- FileProvider configuration for camera intents
- MVI side effects for platform actions (camera is a platform concern, not ViewModel)
- Coil for image loading (AsyncImage composable)
- File storage in app-internal directory
- CoroutineExceptionHandler via launchSafely extension

### Files to Create / Modify

```
New:
  data/local/photo/PhotoStorage.kt                       -- Save/delete photos to internal storage
  domain/usecase/SaveStationPhotoUseCase.kt
  domain/usecase/DeleteStationPhotoUseCase.kt
  presentation/common/mvi/Extensions.kt                  -- launchSafely extension
  app/src/main/res/xml/file_paths.xml                    -- FileProvider paths config

Modify:
  StationListUiSideEffect.kt                             -- Add LaunchCamera, LaunchGallery
  StationListUiAction.kt                                 -- Add PhotoCaptured, PickPhoto
  StationListScreen.kt                                   -- Camera launcher, photo thumbnails
  StationItem.kt                                         -- Show thumbnail via Coil AsyncImage
  AndroidManifest.xml                                    -- FileProvider declaration

Tests:
  domain/usecase/SaveStationPhotoUseCaseTest.kt
  presentation/stationlist/viewmodel/StationListViewModelTest.kt  -- Photo action tests
```

### Key Design Decisions

**Side effects for camera launch:** The camera intent is a platform concern. The ViewModel says "launch camera" (side effect), the Screen composable does it, and reports back with an action (PhotoCaptured). This keeps the ViewModel testable and free of Android framework code. This mirrors how the Zopa codebase handles navigation and external intent side effects.

**launchSafely extension:** Wraps viewModelScope.launch with a CoroutineExceptionHandler. Photo operations can fail (disk full, permission denied) and this prevents unhandled crashes.

### Definition of Done
- [ ] Camera icon per station in list
- [ ] Tapping launches camera; photo saved and displayed as thumbnail
- [ ] Gallery pick as alternative
- [ ] Photo persists across app restarts
- [ ] Delete photo option
- [ ] FileProvider configured
- [ ] Coil AsyncImage for thumbnails
- [ ] Side effect pattern demonstrated
- [ ] Unit tests passing

---

## Phase 4: Station Detail Screen with Navigation

**Goal:** A dedicated detail screen per station. Implement Navigation 3 with type-safe routes. Introduce a bottom navigation bar as the app's top-level navigation shell.

**Status: Not Started**

### What You Will Learn
- Navigation 3: @Serializable route objects, NavController, NavHost
- Scaffold with bottom navigation: NavigationBar + NavigationBarItem (Material 3)
- Multi-screen MVI architecture
- SavedStateHandle for navigation arguments in ViewModels
- Back stack management (top-level tabs vs nested detail navigation)
- Building a second ViewModel (reinforcing patterns)

### Files to Create / Modify

```
New:
  presentation/navigation/Routes.kt                     -- @Serializable route classes (top-level + nested)
  presentation/navigation/TubeSpotterNavGraph.kt         -- NavHost with route mappings
  presentation/navigation/TubeSpotterScaffold.kt         -- Scaffold with NavigationBar (bottom nav shell)
  presentation/navigation/TopLevelDestination.kt         -- Enum of bottom nav tabs (Stations, Achievements)
  presentation/stationdetail/viewmodel/StationDetailUiState.kt
  presentation/stationdetail/viewmodel/StationDetailUiAction.kt
  presentation/stationdetail/viewmodel/StationDetailUiSideEffect.kt
  presentation/stationdetail/viewmodel/StationDetailViewModel.kt
  presentation/stationdetail/StationDetailScreen.kt
  domain/usecase/GetStationDetailUseCase.kt

Modify:
  MainActivity.kt                                        -- Replace direct screen with Scaffold + NavHost
  StationListUiSideEffect.kt                             -- Add NavigateToDetail
  StationDao.kt                                          -- Add getStationById query

Tests:
  domain/usecase/GetStationDetailUseCaseTest.kt
  presentation/stationdetail/viewmodel/StationDetailViewModelTest.kt
```

### Key Design Decisions

**Sealed interface UiState for detail:** Unlike the list (which always has data), the detail screen has loading/error states since it loads a single station:
```kotlin
sealed interface StationDetailUiState : UiState {
    data object Loading : StationDetailUiState
    data class Content(...) : StationDetailUiState
}
```

**Navigation argument via SavedStateHandle:** The stationId is passed as a route argument and extracted in the ViewModel via Hilt's SavedStateHandle injection. Standard pattern.

**Bottom navigation shell:** Introduce a `TubeSpotterScaffold` composable that wraps the NavHost in a Material 3 `Scaffold` with a `NavigationBar`. Initially two tabs: **Stations** (the list) and **Achievements** (placeholder until Phase 5 implements it). The bottom bar should hide on detail screens (only show on top-level destinations). A `TopLevelDestination` enum defines the tabs, their icons, and their root routes. This is the standard pattern for multi-screen Android apps -- the Scaffold owns the bottom bar, each tab has its own back stack within the NavHost.

**Why now?** Adding the shell at the same time as the NavHost avoids retrofitting navigation later. Phase 5 simply wires the Achievements screen into the already-existing tab.

### Definition of Done
- [ ] Navigation 3 NavHost with type-safe routes
- [ ] Bottom navigation bar with Stations and Achievements tabs
- [ ] Bottom bar hidden on detail screens, visible on top-level destinations
- [ ] Tapping station navigates to detail screen
- [ ] Detail shows name, zone, lines, visited status, photo
- [ ] Toggle visited and photo actions work on detail screen
- [ ] Back navigation returns to list with updated state
- [ ] Screen/Content split on detail screen
- [ ] Unit tests passing

---

## Phase 5: Achievements System

**Goal:** Award achievements when a full tube line is completed. Dedicated achievements screen.

**Status: Not Started**

### What You Will Learn
- Room database migrations (adding a table to existing DB)
- Business logic in the domain layer (completion checking)
- Compose animations for celebration effects
- Snackbar/dialog via MVI side effects
- A third screen reinforcing all patterns

### Files to Create

```
New:
  data/local/entity/AchievementEntity.kt
  data/local/dao/AchievementDao.kt
  data/repository/AchievementRepositoryImpl.kt
  domain/model/Achievement.kt
  domain/repository/AchievementRepository.kt
  domain/usecase/GetAchievementsUseCase.kt
  domain/usecase/CheckLineCompletionUseCase.kt
  presentation/achievements/viewmodel/AchievementsUiState.kt
  presentation/achievements/viewmodel/AchievementsUiAction.kt
  presentation/achievements/viewmodel/AchievementsUiSideEffect.kt
  presentation/achievements/viewmodel/AchievementsViewModel.kt
  presentation/achievements/AchievementsScreen.kt
  presentation/navigation/Routes.kt                      -- Add Achievements route

Modify:
  StationListViewModel.kt                                -- Trigger completion check after toggle
  TubeSpotterDatabase.kt                                 -- Migration, add achievement entity

Tests:
  domain/usecase/CheckLineCompletionUseCaseTest.kt
  domain/usecase/GetAchievementsUseCaseTest.kt
  presentation/achievements/viewmodel/AchievementsViewModelTest.kt
```

### Key Design Decisions

**Achievements are permanent:** Un-visiting a station does NOT revoke an achievement. Once earned, it stays. This is a deliberate product decision -- achievements should feel rewarding, not fragile.

**12 achievements total:** One per line (11) + "All Stations Complete" bonus.

### Definition of Done
- [ ] Achievement table with Room migration
- [ ] Line completion detection on station toggle
- [ ] Achievement notification via side effect (Snackbar)
- [ ] Achievements screen showing locked/unlocked state
- [ ] Unit tests for completion logic
- [ ] All tests passing

---

## Phase 6: Interactive Tube Map (Stretch Goal)

**Goal:** A zoomable, pannable tube map where stations can be tapped to toggle or view detail.

**Status: Not Started**

### What You Will Learn
- Custom Compose drawing: Canvas, DrawScope, Path
- Gesture handling: detectTapGestures, transformable (zoom/pan)
- Performance optimisation for rendering ~272 elements
- Coordinate systems and hit testing

### Approach
Build a programmatic map using Compose Canvas. Define station coordinates manually as (x, y) pairs matching the iconic Harry Beck diagram style. Draw lines as coloured paths, stations as circles (filled = visited, hollow = not visited). This teaches the most Android Canvas skills.

### Files to Create
```
  data/local/seed/StationCoordinates.kt
  presentation/map/viewmodel/TubeMapUiState.kt
  presentation/map/viewmodel/TubeMapUiAction.kt
  presentation/map/viewmodel/TubeMapUiSideEffect.kt
  presentation/map/viewmodel/TubeMapViewModel.kt
  presentation/map/TubeMapScreen.kt
  presentation/map/components/TubeMapCanvas.kt
  domain/model/StationCoordinate.kt
  domain/usecase/GetMapDataUseCase.kt
```

### Definition of Done
- [ ] Map displays all 11 lines with correct TfL colours
- [ ] Stations as circles (filled/hollow based on visited)
- [ ] Pinch to zoom, drag to pan
- [ ] Tap station to toggle or navigate to detail
- [ ] Smooth performance (no frame drops)

---

## Dependencies by Phase

| Phase | New Dependencies |
|-------|-----------------|
| 1 | Room, Hilt, Compose BOM, Material 3, Lifecycle, MockK, Truth, Coroutines Test |
| 2 | (none) |
| 3 | Coil |
| 4 | Navigation 3, Kotlin Serialization |
| 5 | (none) |
| 6 | (none) |

---

## Verification Strategy

After each phase:
1. **Run all unit tests:** `./gradlew test`
2. **Run the app on emulator:** Verify the new feature works end-to-end
3. **Check persistence:** Kill and restart the app, verify data survived
4. **Lint check:** `./gradlew lint` for any warnings
5. **Self-review:** Does every file follow the layer it belongs to? Does domain import data? (It shouldn't.)

---

## Professional Pattern Reference

These patterns from the Zopa codebase analysis should be applied throughout:

| Pattern | Where It Appears | TubeSpotter Usage |
|---------|-------------------|-------------------|
| BaseViewModel with StateFlow + Channel | Every feature ViewModel | Every screen's ViewModel |
| Screen/Content composable split | Every feature screen | Every screen composable |
| UiState/UiAction/UiSideEffect sealed types | Every feature's MVI contract | Every screen's MVI contract |
| `collectAsStateWithLifecycle()` | Every Screen composable | Every Screen composable |
| `@Binds` module for repository DI | Every data module | RepositoryModule.kt |
| Use case with `operator fun invoke()` | Every domain use case | Every use case |
| UnconfinedTestDispatcher ViewModel tests | Every ViewModel test | Every ViewModel test |