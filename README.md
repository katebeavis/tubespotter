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

| Phase | Feature | Status |
|-------|---------|--------|
| 1 | Station list with check-off (MVP) | ✅ Complete |
| 2 | Line filtering and progress tracking | ✅ Complete |
| 3 | Photo capture and storage | Planned |
| 4 | Station detail screen + Navigation 3 + bottom nav | Planned |
| 5 | Achievements system | Planned |
| 6 | Interactive tube map (stretch goal) | Planned |

## Phase logs

- [Phase 1](log.md) — Room, Hilt, MVI base, station list
