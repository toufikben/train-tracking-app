# Train Tracking App - Architecture Documentation

## Overview
A modern Android application for real-time train location tracking using Jetpack Compose and Google Maps.

## Architecture

### MVVM + Repository Pattern
- **View Layer**: Jetpack Compose screens
- **ViewModel Layer**: TrainViewModel, LocationViewModel
- **Repository Layer**: TrainRepository for data abstraction
- **Data Layer**: Local (Room) and Remote (Retrofit) data sources

### Dependency Injection
Uses Hilt for:
- NetworkModule: Retrofit + OkHttp configuration
- DatabaseModule: Room database setup
- Automatic ViewModel injection

## Key Technologies

### Jetpack Compose
- Material 3 design system
- Navigation Compose for screen navigation
- State management with StateFlow and collectAsState

### Data Persistence
- Room Database with SQLite
- Train entity with CRUD operations
- TrainDao for database access

### Networking
- Retrofit for REST API calls
- OkHttp with logging interceptor
- Gson for JSON serialization

### Location Services
- Google Play Services for GPS
- Fused Location Provider for efficient location tracking

### Maps
- Google Maps Compose for interactive map display
- Custom markers for trains, stations, and user location
- Camera positioning for map centering

## File Structure

```
app/src/main/
├── java/com/example/traintracking/
│   ├── MainActivity.kt
│   ├── TrainTrackingApp.kt
│   ├── data/
│   │   ├── local/
│   │   │   ├── TrainDatabase.kt
│   │   │   └── TrainDao.kt
│   │   ├── remote/
│   │   │   └── TrainApi.kt
│   │   ├── model/
│   │   │   ├── Train.kt
│   │   │   └── Station.kt
│   │   ├── repository/
│   │   │   └── TrainRepository.kt
│   │   └── service/
│   │       └── LocationService.kt
│   ├── ui/
│   │   ├── screen/
│   │   │   ├── HomeScreen.kt
│   │   │   ├── MapScreen.kt
│   │   │   └── AddTrainScreen.kt
│   │   ├── viewmodel/
│   │   │   ├── TrainViewModel.kt
│   │   │   └── LocationViewModel.kt
│   │   └── theme/
│   │       ├── Theme.kt
│   │       └── Type.kt
│   ├── di/
│   │   ├── NetworkModule.kt
│   │   └── DatabaseModule.kt
│   └── navigation/
│       └── NavGraph.kt
```

## Dependencies Overview

- Kotlin 1.9.0
- Jetpack Compose 1.6.0
- Material 3
- Room Database
- Retrofit 2.9.0
- Hilt 2.48
- Google Play Services