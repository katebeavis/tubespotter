# TubeSpotter — Claude Context

## What This Project Is

TubeSpotter is a personal Android app for tracking a London Underground roundel photo collection. It serves two purposes:

1. **A real app** I will actually use
2. **A structured Android learning project** — I am a Staff Engineer with a React Native background building native Android skills, targeting senior Android level by July 2026

See `PLAN.md` for the full phase breakdown, definitions of done, and file lists.

## How to Work With Me

- Explain **why** decisions are made, not just what to build
- Flag explicitly when a pattern mirrors professional Android practice
- Build phase by phase — do not skip ahead or add things not in the current phase (YAGNI)
- When I ask about a concept, assume I understand software engineering deeply but am new to Android specifically

## Architecture

All architectural decisions are deliberate and should be followed consistently:

- **UI:** Jetpack Compose + Material 3
- **Pattern:** MVI via BaseViewModel (UiState / UiAction / UiSideEffect)
- **Layers:** data / domain / presentation (clean architecture, single module)
- **DI:** Hilt
- **Persistence:** Room
- **Images:** Coil
- **Navigation:** Navigation 3 with `@Serializable` routes
- **Async:** Kotlin Coroutines + Flow, `collectAsStateWithLifecycle()`

## Key Patterns

These patterns are deliberately mirrored from a professional Android codebase and should appear consistently throughout:

| Pattern | Rule |
|---------|------|
| BaseViewModel | Every screen's ViewModel extends it |
| Screen/Content split | Every screen has a Screen composable (wired to VM) and a Content composable (pure function of state, previewable) |
| MVI contract | Every screen defines UiState, UiAction, UiSideEffect |
| Use case `invoke()` | All use cases use `operator fun invoke()` |
| Repository interfaces in domain | Domain defines the interface, data provides the implementation |
| `@Binds` for repositories | Never `@Provides` for repository bindings |
| UnconfinedTestDispatcher | All ViewModel tests use this pattern |

## Current Phase

**Phase 1** — Station list with check-off (MVP). See `PLAN.md` for details.

Update this when a phase is complete.

## Verification After Each Phase

1. `./gradlew test` — all tests pass
2. Run on emulator — feature works end to end
3. Kill and restart — data persists
4. `./gradlew lint` — no warnings
5. Self-review — does domain import anything from data? (It should not)