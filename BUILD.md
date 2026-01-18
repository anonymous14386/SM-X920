# Building the Octopus Apps Android Application

This guide provides detailed instructions for building the Android application.

## Prerequisites

### Required Software

1. **Android Studio** (Recommended)
   - Download from: https://developer.android.com/studio
   - Version: Arctic Fox (2020.3.1) or newer
   - Includes Android SDK and build tools

2. **Java Development Kit (JDK)**
   - JDK 8 or higher (JDK 11 or 17 recommended)
   - OpenJDK or Oracle JDK

3. **Android SDK**
   - Minimum API Level 26 (Android 8.0 Oreo)
   - Target API Level 34 (Android 14)
   - Build Tools 34.0.0 or higher

### Optional Software

- **Gradle** (Optional - Android Studio includes Gradle)
  - Version 8.2 or compatible with Android Gradle Plugin 8.2.0

## Building with Android Studio

This is the recommended method for building the app.

### Step 1: Open the Project

1. Launch Android Studio
2. Click **File → Open**
3. Navigate to the cloned repository directory
4. Select the root directory containing `build.gradle`
5. Click **OK**

### Step 2: Sync Gradle

1. Android Studio will automatically start syncing Gradle
2. If not, click **File → Sync Project with Gradle Files**
3. Wait for the sync to complete (may take a few minutes on first run)

### Step 3: Build the APK

#### Debug Build

1. Click **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. Or use the toolbar shortcut
3. APK location: `app/build/outputs/apk/debug/app-debug.apk`

#### Release Build

1. First, configure signing (see Signing Configuration section)
2. Click **Build → Build Bundle(s) / APK(s) → Build APK(s)**
3. Or **Build → Generate Signed Bundle / APK**
4. APK location: `app/build/outputs/apk/release/app-release.apk`

### Step 4: Install on Device

#### Via Android Studio

1. Connect your Android device via USB or use an emulator
2. Enable USB Debugging on your device
3. Click **Run → Run 'app'** (or press Shift+F10)
4. Select your device from the list
5. The app will be installed and launched automatically

#### Manual Installation

1. Enable "Install from Unknown Sources" on your device
2. Transfer the APK to your device
3. Open the APK file on your device
4. Follow the installation prompts

## Building from Command Line

### Prerequisites

- Ensure `ANDROID_HOME` environment variable is set
- Ensure Java is in your PATH

### Windows

```cmd
REM Navigate to project directory
cd path\to\SM-X920

REM Build debug APK
gradlew.bat assembleDebug

REM Build release APK (requires signing configuration)
gradlew.bat assembleRelease

REM Install debug APK on connected device
gradlew.bat installDebug

REM Run tests
gradlew.bat test

REM Clean build
gradlew.bat clean
```

### Linux/macOS

```bash
# Navigate to project directory
cd path/to/SM-X920

# Build debug APK
./gradlew assembleDebug

# Build release APK (requires signing configuration)
./gradlew assembleRelease

# Install debug APK on connected device
./gradlew installDebug

# Run tests
./gradlew test

# Clean build
./gradlew clean
```

## Gradle Wrapper Notes

This project includes Gradle wrapper scripts (`gradlew` and `gradlew.bat`) for cross-platform building.

**Note:** The `gradle-wrapper.jar` file is not included in the repository. On first use, Gradle will automatically download this file. If you have network restrictions:

1. Download `gradle-wrapper.jar` from a Gradle 8.2 distribution
2. Place it in: `gradle/wrapper/gradle-wrapper.jar`
3. Alternatively, use Android Studio which handles this automatically

## Signing Configuration

For release builds, you need to configure signing:

### Method 1: Using Android Studio

1. Click **Build → Generate Signed Bundle / APK**
2. Select **APK** and click **Next**
3. Create a new keystore or use an existing one
4. Fill in the keystore details
5. Click **Next** and then **Finish**

### Method 2: Using gradle.properties

Create or edit `gradle.properties` in the project root:

```properties
RELEASE_STORE_FILE=/path/to/your/keystore.jks
RELEASE_STORE_PASSWORD=your_store_password
RELEASE_KEY_ALIAS=your_key_alias
RELEASE_KEY_PASSWORD=your_key_password
```

Then update `app/build.gradle`:

```gradle
android {
    signingConfigs {
        release {
            storeFile file(RELEASE_STORE_FILE)
            storePassword RELEASE_STORE_PASSWORD
            keyAlias RELEASE_KEY_ALIAS
            keyPassword RELEASE_KEY_PASSWORD
        }
    }
    buildTypes {
        release {
            signingConfig signingConfigs.release
            // ...
        }
    }
}
```

## Build Variants

The app supports different build variants:

- **debug**: Development build with debugging enabled
- **release**: Production build, minified and optimized

## Troubleshooting

### Gradle Sync Failed

**Problem:** Gradle sync fails with dependency resolution errors

**Solutions:**
1. Check your internet connection
2. Try again - sometimes repositories are temporarily unavailable
3. In Android Studio: **File → Invalidate Caches / Restart**
4. Delete `.gradle` directory and sync again

### SDK Not Found

**Problem:** Android SDK location not found

**Solutions:**
1. Set `ANDROID_HOME` environment variable to your SDK location
2. Create `local.properties` file in project root:
   ```properties
   sdk.dir=/path/to/your/Android/Sdk
   ```

### Build Tools Version Error

**Problem:** Specified build tools version not installed

**Solutions:**
1. Open Android Studio SDK Manager
2. Install the required build tools version
3. Or update `compileSdk` in `app/build.gradle` to match your installed version

### Out of Memory

**Problem:** Gradle runs out of memory during build

**Solutions:**
1. Edit `gradle.properties`:
   ```properties
   org.gradle.jvmargs=-Xmx4096m -XX:MaxPermSize=512m
   ```
2. Close other applications to free up memory

### APK Not Installing

**Problem:** APK fails to install on device

**Solutions:**
1. Uninstall any previous version of the app
2. Enable "Install from Unknown Sources" in device settings
3. Check device has sufficient storage space
4. Verify device meets minimum SDK requirements (API 26+)

## Build Output

After a successful build, you'll find:

```
app/build/outputs/
├── apk/
│   ├── debug/
│   │   └── app-debug.apk
│   └── release/
│       └── app-release.apk (if configured)
├── logs/
│   └── manifest-merger-*.txt
└── mapping/
    └── release/
        └── mapping.txt (ProGuard mapping)
```

## CI/CD Integration

For automated builds, use these commands:

```bash
# Clean and build
./gradlew clean assembleDebug

# Run lint checks
./gradlew lint

# Run unit tests
./gradlew test

# Generate test coverage report
./gradlew jacocoTestReport
```

## Additional Resources

- [Android Developer Guide](https://developer.android.com/guide)
- [Gradle Build Tool](https://gradle.org/)
- [Android Gradle Plugin](https://developer.android.com/build)

## Support

If you encounter issues not covered here:

1. Check the [GitHub Issues](https://github.com/anonymous14386/SM-X920/issues)
2. Review Android Studio build output for specific error messages
3. Check Android SDK and build tools are properly installed
4. Ensure your development environment meets all prerequisites
