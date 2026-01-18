# Octopus Apps - Android Application

Android application for Samsung Galaxy Tab S10 Ultra (SM-X920) that integrates [Octopus Budget](https://github.com/anonymous14386/octopus-budget) and [Octopus Health](https://github.com/anonymous14386/octopus-health) web applications.

## Features

- **Budget Tracker Integration**: Access your budget tracking app with subscription, account, income, and debt management
- **Health Tracker Integration**: Monitor weight, exercise, food intake, and fitness goals
- **Native Android Experience**: WebView-based app with native Android UI components
- **Configurable Server**: Easy settings to point to your server hosting the web applications
- **Offline Cache**: Cached data for faster loading
- **Pull-to-Refresh**: Easy content refresh with swipe gesture
- **Cookie Support**: Maintains authentication and session state
- **Tablet Optimized**: Designed for Samsung Galaxy Tab S10 Ultra

## Screenshots

The app provides a clean, Material Design interface with:
- Main launcher screen with cards for Budget and Health apps
- Full-screen WebView for each application
- Settings screen for server configuration
- Native Android navigation and menus

## Prerequisites

Before building and running the app, ensure you have:

1. **Server Setup**: The two web applications must be running on an accessible server:
   - [Octopus Budget](https://github.com/anonymous14386/octopus-budget) (default port: 3001)
   - [Octopus Health](https://github.com/anonymous14386/octopus-health) (default port: 3002)

2. **Development Environment**:
   - Android Studio (latest version recommended)
   - Android SDK 26+ (Android 8.0 Oreo or higher)
   - JDK 8 or higher
   - Gradle 8.2.0 or higher

## Building the App

### Using Android Studio

1. Clone this repository:
   ```bash
   git clone https://github.com/anonymous14386/SM-X920.git
   cd SM-X920
   ```

2. Open the project in Android Studio:
   - File → Open → Select the SM-X920 directory

3. Wait for Gradle sync to complete

4. Build the project:
   - Build → Make Project (or press Ctrl+F9 / Cmd+F9)

5. Run on device or emulator:
   - Run → Run 'app' (or press Shift+F10)

### Using Command Line

1. Clone and navigate to the project:
   ```bash
   git clone https://github.com/anonymous14386/SM-X920.git
   cd SM-X920
   ```

2. Build the debug APK:
   ```bash
   ./gradlew assembleDebug
   ```
   
   The APK will be generated at: `app/build/outputs/apk/debug/app-debug.apk`

3. Build the release APK (requires signing configuration):
   ```bash
   ./gradlew assembleRelease
   ```

4. Install on connected device:
   ```bash
   ./gradlew installDebug
   ```

## Configuration

After installing the app:

1. Open the app
2. Tap the Settings icon (⚙️) in the toolbar
3. Configure the following:
   - **Server URL**: Your server's base URL (e.g., `https://your-server.com`)
   - **Budget Port**: Port for Budget app (default: 3001)
   - **Health Port**: Port for Health app (default: 3002)
4. Save and return to the main screen
5. Tap on Budget Tracker or Health Tracker to launch the apps

## App Structure

```
app/
├── src/main/
│   ├── java/com/octopus/apps/
│   │   ├── MainActivity.kt              # Main launcher activity
│   │   ├── BaseWebViewActivity.kt       # Base class for WebView activities
│   │   ├── BudgetActivity.kt            # Budget tracker WebView
│   │   ├── HealthActivity.kt            # Health tracker WebView
│   │   └── SettingsActivity.kt          # Settings screen
│   ├── res/
│   │   ├── layout/                      # UI layouts
│   │   ├── values/                      # Strings, colors, themes
│   │   ├── drawable/                    # Icons and graphics
│   │   ├── menu/                        # Menu definitions
│   │   └── xml/                         # Preferences and config
│   └── AndroidManifest.xml              # App manifest
├── build.gradle                         # Module-level build config
└── proguard-rules.pro                   # ProGuard rules
```

## Key Features Explained

### WebView Configuration

The app uses a sophisticated WebView setup with:
- JavaScript enabled for full web app functionality
- DOM storage and database support for offline data
- Cookie support for authentication
- Mixed content mode for HTTP/HTTPS compatibility
- Zoom controls for better tablet experience

### Network Requirements

The app requires internet connectivity to access the web applications. Ensure:
- Your device has network access
- The server URL is correct and accessible
- Firewall rules allow access to the configured ports
- SSL/TLS certificates are valid (if using HTTPS)

### Data Persistence

- App settings are stored in SharedPreferences
- WebView cache is maintained for faster loading
- Cookies are preserved for authentication state
- Clear cache option available in Settings

## Troubleshooting

### App won't load web pages
- Check server URL in Settings
- Verify server is running and accessible
- Check network connectivity
- Try clearing cache in Settings

### Authentication issues
- Clear cache and cookies in Settings
- Re-login in the web interface
- Check if server session is still valid

### Build errors
- Ensure Android SDK is properly installed
- Run `./gradlew clean` and rebuild
- Check that minSdk is 26 or higher
- Verify all dependencies are downloaded

## Development Notes

### Testing
- Test on actual Samsung Galaxy Tab S10 Ultra for best experience
- Emulator can be used for development
- Test with both HTTP and HTTPS server configurations

### Customization
- Modify `colors.xml` to change app theme
- Update `strings.xml` for text changes
- Adjust WebView settings in `BaseWebViewActivity.kt`

## Security Considerations

- The app uses `usesCleartextTraffic="true"` to support HTTP servers
- For production, use HTTPS to encrypt communications
- Server should implement proper authentication
- Consider adding certificate pinning for enhanced security

## License

MIT License - See LICENSE file for details

## Related Projects

- [Octopus Budget](https://github.com/anonymous14386/octopus-budget) - Budget tracking web application
- [Octopus Health](https://github.com/anonymous14386/octopus-health) - Health tracking web application

## Support

For issues related to:
- Android app: Open an issue in this repository
- Budget functionality: See [octopus-budget](https://github.com/anonymous14386/octopus-budget)
- Health functionality: See [octopus-health](https://github.com/anonymous14386/octopus-health)
