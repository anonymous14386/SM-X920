# Project Structure

Complete file structure of the Octopus Apps Android application.

```
SM-X920/
├── Documentation
│   ├── README.md              # Project overview and features
│   ├── BUILD.md               # Detailed build instructions
│   ├── QUICKSTART.md          # Quick start guide for users and developers
│   ├── CONTRIBUTING.md        # Contribution guidelines
│   ├── CHANGELOG.md           # Version history and changes
│   └── LICENSE                # MIT License
│
├── Gradle Configuration
│   ├── build.gradle           # Root project build configuration
│   ├── settings.gradle        # Project settings and module includes
│   ├── gradle.properties      # Gradle properties and configuration
│   ├── gradlew                # Gradle wrapper script (Unix/Linux/macOS)
│   ├── gradlew.bat            # Gradle wrapper script (Windows)
│   └── gradle/
│       └── wrapper/
│           └── gradle-wrapper.properties  # Gradle wrapper configuration
│
├── app/
│   ├── build.gradle           # App module build configuration
│   ├── proguard-rules.pro     # ProGuard rules for code obfuscation
│   │
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml  # App manifest with permissions and activities
│       │   │
│       │   ├── java/com/octopus/apps/
│       │   │   ├── MainActivity.kt             # Main launcher with app cards
│       │   │   ├── BaseWebViewActivity.kt      # Base WebView implementation
│       │   │   ├── BudgetActivity.kt           # Budget tracker WebView
│       │   │   ├── HealthActivity.kt           # Health tracker WebView
│       │   │   └── SettingsActivity.kt         # Settings screen
│       │   │
│       │   └── res/
│       │       ├── drawable/
│       │       │   ├── ic_budget.xml           # Budget app icon
│       │       │   ├── ic_health.xml           # Health app icon
│       │       │   ├── ic_home.xml             # Home icon
│       │       │   ├── ic_refresh.xml          # Refresh icon
│       │       │   ├── ic_settings.xml         # Settings icon
│       │       │   └── ic_launcher_foreground.xml  # App launcher icon foreground
│       │       │
│       │       ├── layout/
│       │       │   ├── activity_main.xml       # Main launcher layout
│       │       │   ├── activity_settings.xml   # Settings layout
│       │       │   └── activity_webview.xml    # WebView layout
│       │       │
│       │       ├── menu/
│       │       │   ├── menu_main.xml           # Main activity menu
│       │       │   └── menu_webview.xml        # WebView activity menu
│       │       │
│       │       ├── mipmap-anydpi-v26/
│       │       │   ├── ic_launcher.xml         # Adaptive launcher icon
│       │       │   └── ic_launcher_round.xml   # Round launcher icon
│       │       │
│       │       ├── values/
│       │       │   ├── colors.xml              # Color definitions
│       │       │   ├── strings.xml             # String resources
│       │       │   ├── themes.xml              # App themes
│       │       │   └── ic_launcher_background.xml  # Launcher icon background
│       │       │
│       │       └── xml/
│       │           ├── backup_rules.xml        # Backup configuration
│       │           ├── data_extraction_rules.xml  # Data extraction rules
│       │           └── preferences.xml         # Settings preferences
│       │
│       ├── androidTest/        # Instrumentation tests (placeholder)
│       │   └── java/
│       │
│       └── test/               # Unit tests (placeholder)
│           └── java/
│
└── .gitignore                  # Git ignore rules

```

## Key Components

### Activities (5 total)

1. **MainActivity** - Main launcher with cards for Budget and Health apps
2. **BaseWebViewActivity** - Abstract base class for WebView activities
3. **BudgetActivity** - Displays Budget tracker web app
4. **HealthActivity** - Displays Health tracker web app
5. **SettingsActivity** - Configuration screen for server settings

### Layouts (3 total)

1. **activity_main.xml** - Card-based launcher UI
2. **activity_webview.xml** - WebView with pull-to-refresh
3. **activity_settings.xml** - Settings screen container

### Resources

- **Drawables**: 6 vector icons
- **Menus**: 2 menu definitions
- **Mipmaps**: 2 adaptive icons
- **Values**: 4 resource files (colors, strings, themes, launcher background)
- **XML**: 3 configuration files (backup, data extraction, preferences)

## File Statistics

- Total Kotlin files: 5
- Total XML files: 23
- Total Gradle files: 2 (app + root)
- Total documentation files: 6
- Lines of code (approx): 800+ (Kotlin + XML)

## Build Artifacts (Generated, not in repo)

```
app/build/
├── generated/              # Generated source files
├── intermediates/          # Build intermediates
├── outputs/
│   ├── apk/
│   │   ├── debug/
│   │   │   └── app-debug.apk
│   │   └── release/
│   │       └── app-release.apk
│   └── logs/
└── tmp/
```

## Technology Stack

### Android
- **Min SDK**: 26 (Android 8.0 Oreo)
- **Target SDK**: 34 (Android 14)
- **Language**: Kotlin
- **UI Framework**: Material Design 3
- **Architecture**: Activity-based with WebView

### Dependencies
- AndroidX Core KTX 1.12.0
- AndroidX AppCompat 1.6.1
- Material Components 1.11.0
- ConstraintLayout 2.1.4
- Preference KTX 1.2.1
- WebKit 1.9.0
- SwipeRefreshLayout 1.1.0

### Build Tools
- Gradle 8.2
- Android Gradle Plugin 8.2.0
- Kotlin Plugin 1.9.20

## Features Implemented

✅ Material Design 3 UI
✅ WebView with JavaScript support
✅ Cookie and session management
✅ Pull-to-refresh
✅ Navigation controls
✅ Settings persistence
✅ Cache management
✅ HTTP/HTTPS support
✅ Error handling
✅ Back navigation in WebView
✅ Tablet optimization

## Development Status

**Version**: 1.0.0
**Status**: Complete and ready for use
**Last Updated**: 2026-01-18

## Quick File Reference

| Component | File Location |
|-----------|--------------|
| Main launcher | `app/src/main/java/com/octopus/apps/MainActivity.kt` |
| WebView base | `app/src/main/java/com/octopus/apps/BaseWebViewActivity.kt` |
| Settings | `app/src/main/java/com/octopus/apps/SettingsActivity.kt` |
| App manifest | `app/src/main/AndroidManifest.xml` |
| Main layout | `app/src/main/res/layout/activity_main.xml` |
| Strings | `app/src/main/res/values/strings.xml` |
| Colors | `app/src/main/res/values/colors.xml` |
| Themes | `app/src/main/res/values/themes.xml` |
| Settings prefs | `app/src/main/res/xml/preferences.xml` |
| App build config | `app/build.gradle` |
| Root build config | `build.gradle` |

## Documentation Index

1. **README.md** - Start here for project overview
2. **QUICKSTART.md** - Fast setup for users and developers
3. **BUILD.md** - Comprehensive build instructions
4. **CONTRIBUTING.md** - Guidelines for contributors
5. **CHANGELOG.md** - Version history
6. **PROJECT_STRUCTURE.md** - This file

## Next Steps

- Build the app: `./gradlew assembleDebug`
- Install: `./gradlew installDebug`
- Read QUICKSTART.md for usage instructions
- Configure your server URLs in Settings
- Start tracking!
