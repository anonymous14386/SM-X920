# Quick Start Guide

Get started with Octopus Apps in minutes!

## For End Users

### Installation

1. **Download the APK** from the releases page or build it yourself
2. **Enable Unknown Sources** in your device settings (if not already enabled)
3. **Install the APK** by opening it on your device
4. **Open Octopus Apps** from your app drawer

### First-Time Setup

1. Tap the **Settings icon** (⚙️) in the top right
2. Configure your server:
   - **Server URL**: Enter your server address (e.g., `https://myserver.com`)
   - **Budget Port**: Enter the port for Budget app (default: 3001)
   - **Health Port**: Enter the port for Health app (default: 3002)
3. Tap the **back button** to return to the main screen
4. Tap either **Budget Tracker** or **Health Tracker** to start!

### Using the Apps

#### Opening an App
- Tap the **Budget Tracker** card to open your budget app
- Tap the **Health Tracker** card to open your health app

#### Within Each App
- **Pull down** to refresh the page
- **Tap the back button** to navigate back within the web app
- **Tap the home icon** to return to the main launcher
- **Tap the refresh icon** to reload the current page
- **Tap the settings icon** to modify server configuration

#### Troubleshooting
- If pages won't load, check your server URL in Settings
- If having login issues, try **Clear Cache** in Settings
- Ensure your device has internet connectivity
- Verify your server is running and accessible

## For Developers

### Clone and Build

```bash
# Clone the repository
git clone https://github.com/anonymous14386/SM-X920.git
cd SM-X920

# Open in Android Studio
# or build from command line:

# On Linux/macOS
./gradlew assembleDebug

# On Windows
gradlew.bat assembleDebug
```

### Install on Device

```bash
# Via Gradle
./gradlew installDebug

# Or manually
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Project Structure

```
SM-X920/
├── app/                    # Main application module
│   ├── src/main/
│   │   ├── java/          # Kotlin source files
│   │   ├── res/           # Resources (layouts, strings, etc.)
│   │   └── AndroidManifest.xml
│   └── build.gradle       # App-level build config
├── gradle/                # Gradle wrapper files
├── BUILD.md              # Detailed build instructions
├── README.md             # Project overview
└── build.gradle          # Project-level build config
```

### Key Files

- `MainActivity.kt` - Main launcher with cards
- `BaseWebViewActivity.kt` - Base class for WebView activities
- `BudgetActivity.kt` - Budget app WebView
- `HealthActivity.kt` - Health app WebView
- `SettingsActivity.kt` - Settings screen

### Making Changes

1. Modify the code
2. Test in Android Studio or emulator
3. Build: `./gradlew assembleDebug`
4. Install: `./gradlew installDebug`

See [CONTRIBUTING.md](CONTRIBUTING.md) for more details.

## Server Setup

Before using the app, ensure your server has:

1. **Octopus Budget** running (default port 3001)
   - GitHub: https://github.com/anonymous14386/octopus-budget
   
2. **Octopus Health** running (default port 3002)
   - GitHub: https://github.com/anonymous14386/octopus-health

### Docker Setup (Recommended)

```bash
# Clone and run Budget app
git clone https://github.com/anonymous14386/octopus-budget.git
cd octopus-budget
docker-compose up -d

# Clone and run Health app
git clone https://github.com/anonymous14386/octopus-health.git
cd octopus-health
docker-compose up -d
```

### Verify Server

```bash
# Check Budget app
curl http://your-server:3001

# Check Health app
curl http://your-server:3002
```

## Common Issues

### App won't build
- Ensure Android SDK is installed
- Check `ANDROID_HOME` environment variable
- Run: `./gradlew clean`

### Can't connect to server
- Verify server URL in Settings
- Check server is running: `curl http://your-server:3001`
- Ensure device has internet access
- Check firewall allows access to ports 3001 and 3002

### Login issues
- Clear cache in Settings
- Check server authentication is working
- Ensure cookies are enabled (they are by default)

### Build errors
- Update Android Studio to latest version
- Sync Gradle: File → Sync Project with Gradle Files
- Clean build: `./gradlew clean assembleDebug`

## Next Steps

- Read the full [README](README.md) for detailed information
- Check [BUILD.md](BUILD.md) for comprehensive build instructions
- Review [CONTRIBUTING.md](CONTRIBUTING.md) to contribute
- See [CHANGELOG.md](CHANGELOG.md) for version history

## Need Help?

- Open an issue on GitHub
- Check existing issues for solutions
- Review the documentation files

Happy tracking! 🎉
