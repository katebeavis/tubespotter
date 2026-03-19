# Phase One Log

## Built:
- Room database with 3 tables, pre-seeded with 272 stations across 11 lines
- Clean architecture with data → domain → presentation separation
- Hilt dependency injection wired through the full stack
- MVI pattern via BaseViewModel with StateFlow + Channel
- Screen/Content composable split
- Unit tests for use cases and ViewModel

## Android concepts this phase covered:
- Gradle version catalogs and dependency management
- KSP vs KAPT and why ecosystem compatibility matters
- Room: entities, DAOs, database class, seed callbacks
- Hilt: component scopes, @Provides vs @Binds, @HiltViewModel
- Flow as a live query mechanism
- collectAsStateWithLifecycle() and why it's preferred over collectAsState()
- LazyColumn with stable keys
- UnconfinedTestDispatcher for ViewModel tests

## Verification checklist
- `./gradlew test` - passing
- Run on emulator - working
- Kill and restart - data persists
- `./gradlew lint` - passing

![phase-one.png](phase-one.png)