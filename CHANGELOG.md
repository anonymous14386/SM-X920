# Changelog

All notable changes to the Octopus Apps Android application will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.0] - 2026-01-18

### Added
- Initial release of Octopus Apps for Android
- Main launcher activity with card-based navigation
- Budget Tracker integration via WebView
- Health Tracker integration via WebView
- Settings activity for server configuration
- Configurable server URL and port settings
- WebView with JavaScript, cookies, and DOM storage support
- Pull-to-refresh functionality
- Swipe navigation (back button support in WebView)
- Material Design 3 UI components
- Tablet-optimized layouts for Samsung Galaxy Tab S10 Ultra
- Network connectivity requirements (Internet, WiFi state, network state)
- Clear cache functionality in settings
- Support for HTTP and HTTPS connections
- Adaptive app icons
- Navigation menus with refresh and home actions
- Build configuration for debug and release variants
- Comprehensive documentation (README, BUILD.md, CONTRIBUTING.md)
- MIT License

### Features
- **Dual App Integration**: Access both Budget and Health tracking apps from one launcher
- **Native Experience**: Material Design UI with native Android components
- **Offline Support**: WebView caching for faster subsequent loads
- **Session Persistence**: Cookie support maintains authentication state
- **Flexible Configuration**: Easy server URL and port configuration
- **Developer Friendly**: Well-documented codebase and build process

### Technical
- Minimum SDK: API 26 (Android 8.0 Oreo)
- Target SDK: API 34 (Android 14)
- Language: Kotlin
- Build System: Gradle 8.2
- Android Gradle Plugin: 8.2.0
- Dependencies:
  - AndroidX Core KTX 1.12.0
  - AndroidX AppCompat 1.6.1
  - Material Components 1.11.0
  - ConstraintLayout 2.1.4
  - Preference KTX 1.2.1
  - WebKit 1.9.0
  - SwipeRefreshLayout 1.1.0

## [Unreleased]

### Planned
- Dark mode support
- Offline mode indicator
- Custom URL scheme handling
- Biometric authentication
- App shortcuts for quick access
- Widget support
- Improved error handling and retry mechanisms
- Analytics integration (optional)
- In-app browser controls
- Bookmark/favorites functionality
