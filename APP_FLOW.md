# App Flow and UI Structure

Visual guide to the Octopus Apps user interface and navigation flow.

## App Navigation Flow

```
┌─────────────────────────────────────────────────┐
│  Octopus Apps Launcher                    ⚙️    │  ← MainActivity
│  (Device Home Screen)                           │
└─────────────────────────────────────────────────┘
                       │
                       ▼
┌─────────────────────────────────────────────────┐
│  ╔═════════════════════════════════════════╗    │
│  ║  Welcome to Octopus Apps           ⚙️  ║    │  ← Main Activity
│  ║  Select an app to open                 ║    │     (Launch Screen)
│  ╚═════════════════════════════════════════╝    │
│                                                  │
│  ┌─────────────────────────────────────────┐    │
│  │         💰 Budget Tracker               │    │
│  │  Track subscriptions, accounts,         │    │
│  │  income, and debts                      │    │
│  └─────────────────────────────────────────┘    │
│                                                  │
│  ┌─────────────────────────────────────────┐    │
│  │         🏥 Health Tracker               │    │
│  │  Monitor weight, exercise, food         │    │
│  │  intake, and fitness goals              │    │
│  └─────────────────────────────────────────┘    │
└─────────────────────────────────────────────────┘
         │                      │
         │                      │
         ▼                      ▼
┌──────────────────┐   ┌──────────────────┐
│ Budget App       │   │ Health App       │
│ (BudgetActivity) │   │ (HealthActivity) │
└──────────────────┘   └──────────────────┘
         │                      │
         └──────────┬───────────┘
                    │
                    ▼
┌─────────────────────────────────────────────────┐
│  ◀ Budget/Health Tracker              🔄  🏠  ⚙️│  ← WebView Activity
│  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  │     (Budget or Health)
│                                                  │
│  ┌────────────────────────────────────────────┐ │
│  │                                            │ │
│  │         [Web App Content]                  │ │
│  │                                            │ │
│  │  • Login                                   │ │
│  │  • Dashboard                               │ │
│  │  • Data entry                              │ │
│  │  • Reports                                 │ │
│  │  • Settings                                │ │
│  │                                            │ │
│  │     (Loaded from your server)              │ │
│  │                                            │ │
│  └────────────────────────────────────────────┘ │
│                                                  │
│  [Pull down to refresh]                         │
└─────────────────────────────────────────────────┘
                    │
                    │ (Tap ⚙️)
                    ▼
┌─────────────────────────────────────────────────┐
│  ◀ Settings                                     │  ← Settings Activity
│  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━  │
│                                                  │
│  Server Configuration                           │
│  ┌─────────────────────────────────────────┐   │
│  │ Server URL                              │   │
│  │ https://your-server.com              ▶  │   │
│  └─────────────────────────────────────────┘   │
│                                                  │
│  ┌─────────────────────────────────────────┐   │
│  │ Budget App Port                         │   │
│  │ 3001                                  ▶  │   │
│  └─────────────────────────────────────────┘   │
│                                                  │
│  ┌─────────────────────────────────────────┐   │
│  │ Health App Port                         │   │
│  │ 3002                                  ▶  │   │
│  └─────────────────────────────────────────┘   │
│                                                  │
│  Data                                            │
│  ┌─────────────────────────────────────────┐   │
│  │ Clear Cache                             │   │
│  │ Clear all cached data and cookies       │   │
│  └─────────────────────────────────────────┘   │
└─────────────────────────────────────────────────┘
```

## UI Components

### MainActivity (Launcher)
```
╔══════════════════════════════════════════╗
║  Octopus Apps                       ⚙️  ║  ← Toolbar
╚══════════════════════════════════════════╝

   Welcome to Octopus Apps
   Select an app to open

┌────────────────────────────────────────┐
│              💰                        │
│                                        │  ← Card: Budget
│        Budget Tracker                  │
│                                        │
│  Track subscriptions, accounts,        │
│  income, and debts                     │
└────────────────────────────────────────┘

┌────────────────────────────────────────┐
│              🏥                        │
│                                        │  ← Card: Health
│        Health Tracker                  │
│                                        │
│  Monitor weight, exercise, food        │
│  intake, and fitness goals             │
└────────────────────────────────────────┘
```

### WebView Activity (Budget/Health)
```
╔══════════════════════════════════════════╗
║ ◀ Budget Tracker          🔄  🏠  ⚙️   ║  ← Toolbar with navigation
╚══════════════════════════════════════════╝

┌──────────────────────────────────────────┐
│                                          │
│                                          │
│     [Full Web Application Content]       │
│                                          │  ← WebView
│    • Runs your server's web app         │
│    • Full JavaScript support             │
│    • Maintains cookies/sessions          │
│    • Pull-to-refresh enabled             │
│                                          │
│                                          │
└──────────────────────────────────────────┘
```

### Settings Screen
```
╔══════════════════════════════════════════╗
║ ◀ Settings                              ║  ← Toolbar
╚══════════════════════════════════════════╝

 Server Configuration

 Server URL                              ▶
 https://your-server.com

 Budget App Port                         ▶
 3001

 Health App Port                         ▶
 3002

 ─────────────────────────────────────────

 Data

 Clear Cache
 Clear all cached data and cookies
```

## Interaction Patterns

### Navigation
- **Main Screen → App**: Tap card to open Budget or Health
- **App → Back**: Back button navigates within web app, then returns to main
- **Any Screen → Settings**: Tap ⚙️ icon
- **WebView → Home**: Tap 🏠 icon to return to main launcher
- **WebView → Refresh**: Tap 🔄 icon or pull down to refresh

### Gestures
- **Pull Down**: Refresh current page (WebView only)
- **Back Button**: Navigate back in web history or return to previous screen
- **Tap Card**: Open corresponding app
- **Swipe**: Navigate within WebView if supported by web app

## Screen Transitions

```
Main Screen
    ↓ [Tap Budget Card]
Budget WebView
    ↓ [Tap Settings]
Settings
    ↓ [Back Button]
Budget WebView
    ↓ [Tap Home]
Main Screen
    ↓ [Tap Health Card]
Health WebView
    ↓ [Back Button]
Main Screen
```

## Key Features Visualized

### Material Design Elements
- Elevated cards with shadows
- Toolbar with Material Design 3 styling
- Icons from Material Design icon set
- Color scheme: Purple primary, teal accent
- Smooth transitions and animations

### WebView Features
- Full-screen web content
- JavaScript execution enabled
- Cookie persistence
- Local storage support
- Mixed content allowed (HTTP/HTTPS)
- Zoom controls available
- Progress indicators during load

### Settings Management
- SharedPreferences for persistence
- EditTextPreference for URL/port input
- Simple preference click for cache clear
- Instant setting application

## Color Scheme

```
Primary:       #6200EE (Purple)
Primary Dark:  #3700B3 (Dark Purple)
Accent:        #03DAC5 (Teal)
Budget Color:  #4CAF50 (Green)
Health Color:  #2196F3 (Blue)
```

## Icon Set

- 💰 Budget: Dollar sign icon
- 🏥 Health: Shield with medical cross
- ⚙️ Settings: Gear icon
- 🔄 Refresh: Circular arrow
- 🏠 Home: House icon
- ◀ Back: Left arrow

## User Journey Example

1. **Launch**: User opens app from device home screen
2. **Choose**: User sees two cards and taps "Budget Tracker"
3. **Load**: Budget web app loads from server (https://server.com:3001)
4. **Use**: User interacts with budget app (add expenses, view reports)
5. **Navigate**: User taps back, returns to main launcher
6. **Switch**: User taps "Health Tracker" card
7. **Use**: Health app loads, user logs weight and exercise
8. **Configure**: User taps settings to update server URL
9. **Continue**: User returns to using apps with new configuration

## Technical UI Details

- **Layout System**: ConstraintLayout, CoordinatorLayout, LinearLayout
- **Components**: MaterialToolbar, MaterialCardView, WebView, SwipeRefreshLayout
- **Theme**: Theme.Material3.DayNight.NoActionBar
- **Min Height**: Adapts to content
- **Tablet Support**: Optimized for large screens
- **Orientation**: Portrait and landscape supported
- **Status Bar**: Colored to match theme

## Accessibility

- All interactive elements have content descriptions
- Touch targets meet minimum size requirements
- Text is readable at default system sizes
- Color contrast meets WCAG guidelines
- Keyboard navigation supported in WebView

---

This UI structure provides a clean, modern interface that makes it easy to access
both web applications while maintaining a native Android feel.
