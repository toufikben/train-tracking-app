# Train Tracking App

A modern Android application for real-time train location tracking using Jetpack Compose, Google Maps, and Firebase.

## Features

✅ **Real-time Train Tracking** - Monitor train locations on Google Maps
✅ **GPS Location Services** - Get user's current location with proper permissions
✅ **Fixed Train Stations** - 5 predefined stations across the city
✅ **Add New Trains** - Users can add trains with live location coordinates
✅ **Train Status** - View train status (On Time, Delayed, Arrived)
✅ **Modern UI** - Built with Jetpack Compose
✅ **Offline Support** - Local SQLite database for offline access
✅ **MVVM Architecture** - Clean and scalable code structure
✅ **Hilt Dependency Injection** - Easy dependency management

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose (Material 3)
- **Architecture**: MVVM + Repository Pattern
- **Database**: Room (SQLite)
- **Networking**: Retrofit + OkHttp
- **Dependency Injection**: Hilt
- **Maps**: Google Maps Compose
- **Location**: Google Play Services (Fused Location Provider)
- **Authentication**: Firebase Auth (optional)
- **Real-time Database**: Firebase Realtime Database (optional)

## Project Structure

```
app/src/main/java/com/example/traintracking/
├── data/
│   ├── local/         # Room Database
│   ├── remote/        # Retrofit API
│   ├── model/         # Data models
│   ├── repository/    # Repository pattern
│   └── service/       # Location service
├── ui/
│   ├── screen/        # Composable screens
│   ├── viewmodel/     # ViewModels
│   └── theme/         # UI theme
├── di/                # Dependency Injection modules
├── navigation/        # Navigation graph
└── MainActivity.kt    # Entry point
```

## Setup Instructions

### 1. Prerequisites
- Android Studio Flamingo or later
- Android SDK 24+
- Google Play Services
- Internet connection for API calls

### 2. Clone Repository
```bash
git clone https://github.com/toufikben/train-tracking-app.git
cd train-tracking-app
```

### 3. Add Google Maps API Key
1. Go to [Google Cloud Console](https://console.cloud.google.com/)
2. Create a new project
3. Enable Maps SDK for Android
4. Create an API key
5. In `AndroidManifest.xml`, replace `YOUR_GOOGLE_MAPS_API_KEY` with your key

### 4. Configure Backend API (Optional)
- Update `BASE_URL` in `NetworkModule.kt`
- Implement backend endpoints as per `TrainApi` interface

### 5. Firebase Setup (Optional)
- Create Firebase project in [Firebase Console](https://console.firebase.google.com/)
- Download `google-services.json`
- Place it in `app/` directory
- Uncomment Firebase dependencies in `build.gradle.kts`

### 6. Build and Run
```bash
# Build
./gradlew build

# Run on emulator/device
./gradlew installDebug
```

## App Features in Detail

### Home Screen
- List of all trains with status
- Pull-to-refresh functionality
- FAB to add new trains
- Click train to view on map

### Add Train Screen
- Input train name and number
- Enter GPS coordinates
- Select from/to stations (from fixed list)
- Set train status
- Save train to local database

### Map Screen
- Real-time Google Map display
- Train marker (main subject)
- Station markers (5 fixed locations)
- User's current location marker
- Train information card at bottom

## Fixed Train Stations

1. **Central Station** - 48.8566°N, 2.3522°E
2. **West Terminal** - 48.8353°N, 2.2795°E
3. **North Junction** - 48.8724°N, 2.3486°E
4. **East Plaza** - 48.8529°N, 2.3957°E
5. **South Express** - 48.8387°N, 2.3391°E

## API Endpoints (When Backend is Ready)

```
GET    /api/trains              - Get all trains
GET    /api/trains/{id}         - Get train by ID
POST   /api/trains/{id}/location - Update train location
GET    /api/trains/{id}/location - Get train location
```

## Permissions Required

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

## Runtime Permissions
The app requests GPS location permissions at runtime (Android 6.0+).

## Future Enhancements

- 🔐 User authentication with Firebase Auth
- 📡 Real-time updates using Firebase Realtime Database
- 🔔 Push notifications for train delays
- 📊 Train history and statistics
- 🌙 Dark mode support
- 🌐 Multiple languages support
- 👥 Social features (share train info)
- 📱 Widget for quick access
- ⭐ Favorite trains list
- 🗺️ Custom map styles

## Database Schema

### Trains Table
```sql
CREATE TABLE trains (
    id TEXT PRIMARY KEY,
    name TEXT NOT NULL,
    number TEXT NOT NULL,
    latitude REAL NOT NULL,
    longitude REAL NOT NULL,
    station TEXT NOT NULL,
    destination TEXT NOT NULL,
    status TEXT NOT NULL,
    lastUpdated INTEGER NOT NULL
);
```

## Troubleshooting

### Google Maps not showing
- Verify API key is correct and enabled
- Check internet connection
- Ensure location permissions are granted

### Gradle build fails
- Clean: `./gradlew clean`
- Rebuild: `./gradlew build`
- Sync Gradle: In Android Studio: File > Sync Now

### Location permission denied
- Grant location permissions in app settings
- Use Android 6.0+ device/emulator for runtime permissions

## Contributing

Contributions are welcome! Please follow these steps:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see LICENSE file for details.

## Author

**Toufik Ben**
- GitHub: [@toufikben](https://github.com/toufikben)

## Support

For support, email support@traintracking.com or open an issue in the repository.

## Changelog

### Version 1.0.0 (Initial Release)
- Basic train tracking functionality
- Google Maps integration
- Real-time location tracking
- Train management (add/delete)
- Offline database support
