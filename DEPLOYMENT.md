# Deployment Guide

Complete guide for deploying the Octopus Apps Android application to users.

## Overview

This guide covers building, signing, and distributing the Octopus Apps application to end users.

## Prerequisites

Before deployment, ensure:
- [ ] App has been thoroughly tested on target devices
- [ ] Server infrastructure is ready (Budget and Health apps running)
- [ ] All documentation is up to date
- [ ] Version number is correct in `app/build.gradle`

## Building Release APK

### Step 1: Create Signing Key

You need a signing key to create a release build. Create one using `keytool`:

```bash
keytool -genkey -v -keystore octopus-apps-release.keystore \
  -alias octopus-apps -keyalg RSA -keysize 2048 -validity 10000
```

Answer the prompts:
- Enter keystore password (remember this!)
- Re-enter password
- Enter your name and organization details
- Enter key password (can be same as keystore password)

**Important**: Keep this keystore file secure! You'll need it for all future updates.

### Step 2: Configure Signing in Gradle

Option A: Using gradle.properties (Recommended for CI/CD)

Create/edit `gradle.properties` in project root:

```properties
RELEASE_STORE_FILE=../octopus-apps-release.keystore
RELEASE_STORE_PASSWORD=your_keystore_password
RELEASE_KEY_ALIAS=octopus-apps
RELEASE_KEY_PASSWORD=your_key_password
```

Then update `app/build.gradle`:

```gradle
android {
    signingConfigs {
        release {
            if (project.hasProperty('RELEASE_STORE_FILE')) {
                storeFile file(RELEASE_STORE_FILE)
                storePassword RELEASE_STORE_PASSWORD
                keyAlias RELEASE_KEY_ALIAS
                keyPassword RELEASE_KEY_PASSWORD
            }
        }
    }
    buildTypes {
        release {
            signingConfig signingConfigs.release
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}
```

Option B: Using Android Studio GUI

1. Build → Generate Signed Bundle / APK
2. Select APK → Next
3. Choose existing keystore or create new
4. Enter passwords
5. Select release build variant
6. Click Finish

### Step 3: Build Release APK

Using command line:

```bash
./gradlew assembleRelease
```

Using Android Studio:
- Build → Build Bundle(s) / APK(s) → Build APK(s)
- Or Build → Generate Signed Bundle / APK

Output location: `app/build/outputs/apk/release/app-release.apk`

### Step 4: Verify APK

Check the APK was signed correctly:

```bash
jarsigner -verify -verbose -certs app/build/outputs/apk/release/app-release.apk
```

Should see: "jar verified."

Get APK info:

```bash
aapt dump badging app/build/outputs/apk/release/app-release.apk
```

## Distribution Methods

### Method 1: Direct Distribution (Sideloading)

For internal/enterprise use or small user base:

1. **Copy APK to device**:
   - Via USB: Copy APK to device storage
   - Via cloud: Upload to Google Drive, Dropbox, etc.
   - Via email: Send as attachment

2. **Enable Unknown Sources**:
   - Settings → Security → Unknown Sources (Android 7 and below)
   - Settings → Apps → Special Access → Install Unknown Apps (Android 8+)

3. **Install**:
   - Open APK file on device
   - Follow installation prompts

### Method 2: Internal Distribution Server

Host the APK on your own server:

1. **Upload APK** to your server
2. **Create download page** (HTML):

```html
<!DOCTYPE html>
<html>
<head>
    <title>Octopus Apps Download</title>
</head>
<body>
    <h1>Octopus Apps for Android</h1>
    <p>Version 1.0.0</p>
    <a href="octopus-apps-v1.0.0.apk" download>
        Download APK (12 MB)
    </a>
    <h2>Installation Instructions</h2>
    <ol>
        <li>Download the APK file</li>
        <li>Enable "Unknown Sources" in Android settings</li>
        <li>Open the downloaded APK</li>
        <li>Follow installation prompts</li>
    </ol>
</body>
</html>
```

3. **Share link** with users

### Method 3: Google Play Store (Public Release)

For public distribution:

1. **Create Developer Account** ($25 one-time fee)
   - Go to https://play.google.com/console
   - Sign up and pay registration fee

2. **Prepare Store Listing**:
   - App screenshots (at least 2)
   - Feature graphic (1024x500)
   - App icon (512x512)
   - Short description (80 chars)
   - Full description (4000 chars)
   - Privacy policy URL
   - Content rating questionnaire

3. **Build App Bundle** (preferred over APK):
   ```bash
   ./gradlew bundleRelease
   ```
   Output: `app/build/outputs/bundle/release/app-release.aab`

4. **Upload to Play Console**:
   - Create new release
   - Upload AAB file
   - Complete store listing
   - Set pricing (free/paid)
   - Submit for review

5. **Wait for Approval** (usually 1-3 days)

### Method 4: Enterprise Distribution

For company internal use:

1. **Use MDM Solution** (Mobile Device Management):
   - Microsoft Intune
   - VMware Workspace ONE
   - MobileIron
   - Others

2. **Private Play Store**:
   - Google Play Console → Managed Play
   - Internal distribution to organization

## Post-Deployment

### User Setup Instructions

Provide users with:

1. **Installation guide** (see QUICKSTART.md)
2. **Server URL** they should configure
3. **Support contact** for issues
4. **Known issues** if any

Example user email:

```
Subject: Octopus Apps for Android - Now Available!

Hi Team,

The Octopus Apps Android application is now available for download.

Download Link: [Your link]
Version: 1.0.0

Setup Instructions:
1. Download and install the app
2. Open the app
3. Tap Settings (gear icon)
4. Enter Server URL: https://your-server.com
5. Budget Port: 3001
6. Health Port: 3002
7. Start using the apps!

Support: email@company.com

Best regards,
Your Team
```

### Monitoring

Track:
- [ ] Number of downloads
- [ ] User feedback
- [ ] Crash reports (if analytics enabled)
- [ ] Feature requests
- [ ] Bug reports

### Updates

When releasing updates:

1. **Update version in build.gradle**:
   ```gradle
   versionCode 2        // Increment by 1
   versionName "1.1.0"  // Semantic versioning
   ```

2. **Update CHANGELOG.md**

3. **Build and sign** with same keystore

4. **Test thoroughly**

5. **Distribute** using same method

6. **Notify users** of update

## Security Best Practices

### For Keystore
- ✅ Store keystore in secure location
- ✅ Backup keystore securely
- ✅ Never commit keystore to Git
- ✅ Use strong passwords
- ✅ Document keystore details securely

### For APK
- ✅ Sign all release builds
- ✅ Verify APK signatures
- ✅ Use HTTPS for downloads
- ✅ Provide SHA-256 checksums
- ✅ Scan APK with antivirus

### For Users
- ✅ Recommend HTTPS server URLs only
- ✅ Provide secure distribution channels
- ✅ Educate on APK source verification
- ✅ Keep app updated

## APK Signing Information

For verification, provide users with:

```bash
# Get APK signature
keytool -printcert -jarfile app-release.apk

# Get SHA-256 fingerprint
keytool -list -v -keystore octopus-apps-release.keystore
```

Publish SHA-256 fingerprint on trusted channel so users can verify.

## Versioning Strategy

Follow semantic versioning (MAJOR.MINOR.PATCH):

- **MAJOR**: Incompatible API changes (e.g., 2.0.0)
- **MINOR**: New features, backwards compatible (e.g., 1.1.0)
- **PATCH**: Bug fixes (e.g., 1.0.1)

Update both `versionCode` and `versionName`:
- `versionCode`: Integer, increments with every release
- `versionName`: User-visible version string

## Rollback Plan

If critical issues are found:

1. **Remove download links** immediately
2. **Notify users** via email/announcement
3. **Fix issues** in code
4. **Test thoroughly**
5. **Release patch** version
6. **Update distribution**

## Checklist Before Release

- [ ] All features working as expected
- [ ] No critical bugs
- [ ] Tested on multiple devices/Android versions
- [ ] Server URLs configured correctly
- [ ] Documentation up to date
- [ ] Screenshots taken
- [ ] Keystore created and backed up
- [ ] APK signed and verified
- [ ] Version numbers updated
- [ ] CHANGELOG updated
- [ ] Distribution method chosen
- [ ] User instructions prepared
- [ ] Support process established
- [ ] Legal/compliance requirements met

## Support After Deployment

Prepare to handle:
- Installation questions
- Configuration help
- Bug reports
- Feature requests
- Server connectivity issues

Recommended: Create FAQ document based on common questions.

## Legal Considerations

Ensure you have:
- [ ] Privacy policy (if collecting data)
- [ ] Terms of service
- [ ] License compliance (all dependencies)
- [ ] User consent for tracking (if applicable)
- [ ] Data protection compliance (GDPR, etc.)

## Tools and Resources

- **Android Studio**: https://developer.android.com/studio
- **Play Console**: https://play.google.com/console
- **APK Analyzer**: Build → Analyze APK (in Android Studio)
- **keytool**: Included with JDK
- **jarsigner**: Included with JDK

## Troubleshooting Deployment Issues

### "App not installed" error
- Verify APK is signed correctly
- Check device has sufficient storage
- Try uninstalling old version first

### Play Store rejection
- Review rejection reason carefully
- Check all policies: https://play.google.com/about/developer-content-policy/
- Fix issues and resubmit

### Signature verification failed
- Ensure using correct keystore
- Check passwords are correct
- Verify keystore not corrupted

---

**Note**: Keep this guide updated as your deployment process evolves.
