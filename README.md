# TubeSpotter

A personal Android app for tracking a London Underground roundel photo collection. Track which of the 272 tube stations you've photographed, see progress by line, and earn achievements for completing lines.

TubeSpotter is also a structured Android learning project — built phase by phase to reach senior Android level, with each phase teaching specific concepts using patterns mirrored from a professional production codebase.

## Stack

- **UI:** Jetpack Compose + Material 3
- **Architecture:** MVI via `BaseViewModel` (UiState / UiAction / UiSideEffect)
- **Layers:** Clean architecture — data / domain / presentation (single module)
- **DI:** Hilt
- **Persistence:** Room
- **Images:** Coil (Phase 3+)
- **Navigation:** Navigation 3 (Phase 4+)
- **Async:** Kotlin Coroutines + Flow

## Phases

| Phase | Feature                                           | Status     |
|-------|---------------------------------------------------|------------|
| 1     | Station list with check-off (MVP)                 | ✅ Complete |
| 2     | Line filtering and progress tracking              | ✅ Complete |
| 3     | Photo capture and storage                         | ✅ Complete |
| 4     | Station detail screen + Navigation 3 + bottom nav | ✅ Complete |
| 5     | Achievements system                               | Planned    |
| 6     | Interactive tube map (stretch goal)               | Planned    |

## Logs

### Build log
- [Phase 1](build-log.md#phase-one) — Room, Hilt, MVI base, station list
- [Phase 2](build-log.md#phase-two) — Line filtering, progress tracking, data deduplication
- [Phase 3](build-log.md#phase-three) — Adding photo capture and storage per station using the camera, FileProvider, and Coil.
- [Phase 4](build-log.md#phase-four) — Station detail screen, Navigation 3 with type-safe routes, bottom nav shell, assisted injection

### Learning log
- [Phase 1](learning-log.md#phase-1-project-setup--core-architecture)
- [Phase 2](learning-log.md#phase-2-line-filtering--progress-tracking)
- [Phase 3](learning-log.md#phase-3-photo-capture--storage)
- [Phase 4](learning-log.md#phase-4-station-detail-screen--navigation)
