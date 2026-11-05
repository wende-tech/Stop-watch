---
name: Chronos Precision Studio
colors:
  surface: '#121416'
  surface-dim: '#121416'
  surface-bright: '#38393c'
  surface-container-lowest: '#0c0e10'
  surface-container-low: '#1a1c1e'
  surface-container: '#1e2022'
  surface-container-high: '#282a2c'
  surface-container-highest: '#333537'
  on-surface: '#e2e2e5'
  on-surface-variant: '#bac9cc'
  inverse-surface: '#e2e2e5'
  inverse-on-surface: '#2f3133'
  outline: '#849396'
  outline-variant: '#3b494c'
  surface-tint: '#00daf3'
  primary: '#c3f5ff'
  on-primary: '#00363d'
  primary-container: '#00e5ff'
  on-primary-container: '#00626e'
  inverse-primary: '#006875'
  secondary: '#ffb778'
  on-secondary: '#4c2700'
  secondary-container: '#fd9000'
  on-secondary-container: '#613400'
  tertiary: '#ffe7e5'
  on-tertiary: '#68000c'
  tertiary-container: '#ffc1bd'
  on-tertiary-container: '#b01522'
  error: '#ffb4ab'
  on-error: '#690005'
  error-container: '#93000a'
  on-error-container: '#ffdad6'
  primary-fixed: '#9cf0ff'
  primary-fixed-dim: '#00daf3'
  on-primary-fixed: '#001f24'
  on-primary-fixed-variant: '#004f58'
  secondary-fixed: '#ffdcc1'
  secondary-fixed-dim: '#ffb778'
  on-secondary-fixed: '#2e1500'
  on-secondary-fixed-variant: '#6c3a00'
  tertiary-fixed: '#ffdad7'
  tertiary-fixed-dim: '#ffb3ae'
  on-tertiary-fixed: '#410004'
  on-tertiary-fixed-variant: '#930015'
  background: '#121416'
  on-background: '#e2e2e5'
  surface-variant: '#333537'
typography:
  display-lg:
    fontFamily: JetBrains Mono
    fontSize: 5rem
    fontWeight: '700'
    lineHeight: 5rem
    letterSpacing: -0.04em
  display-lg-mobile:
    fontFamily: JetBrains Mono
    fontSize: 3.5rem
    fontWeight: '700'
    lineHeight: 3.75rem
    letterSpacing: -0.03em
  display-md:
    fontFamily: JetBrains Mono
    fontSize: 3rem
    fontWeight: '600'
    lineHeight: 3.25rem
    letterSpacing: -0.02em
  headline-lg:
    fontFamily: JetBrains Mono
    fontSize: 2rem
    fontWeight: '600'
    lineHeight: 2.5rem
    letterSpacing: -0.01em
  headline-md:
    fontFamily: JetBrains Mono
    fontSize: 1.5rem
    fontWeight: '500'
    lineHeight: 2rem
    letterSpacing: '0'
  title-lg:
    fontFamily: Roboto Flex
    fontSize: 1.375rem
    fontWeight: '600'
    lineHeight: 1.75rem
    letterSpacing: '0'
  title-md:
    fontFamily: Roboto Flex
    fontSize: 1.125rem
    fontWeight: '500'
    lineHeight: 1.5rem
    letterSpacing: 0.01em
  body-lg:
    fontFamily: Roboto Flex
    fontSize: 1rem
    fontWeight: '400'
    lineHeight: 1.5rem
    letterSpacing: 0.02em
  body-md:
    fontFamily: Roboto Flex
    fontSize: 0.875rem
    fontWeight: '400'
    lineHeight: 1.25rem
    letterSpacing: 0.02em
  label-lg:
    fontFamily: JetBrains Mono
    fontSize: 0.875rem
    fontWeight: '600'
    lineHeight: 1.25rem
    letterSpacing: 0.05em
  label-md:
    fontFamily: JetBrains Mono
    fontSize: 0.75rem
    fontWeight: '500'
    lineHeight: 1rem
    letterSpacing: 0.06em
  label-sm:
    fontFamily: JetBrains Mono
    fontSize: 0.6875rem
    fontWeight: '500'
    lineHeight: 0.875rem
    letterSpacing: 0.08em
rounded:
  sm: 0.5rem
  DEFAULT: 1rem
  md: 1.5rem
  lg: 2rem
  xl: 3rem
  full: 9999px
spacing:
  gutter: 1rem
  gutter-tablet: 1.5rem
  gutter-desktop: 2rem
  margin: 1rem
  margin-tablet: 2rem
  margin-desktop: 3rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 1rem
  space-lg: 1.5rem
  space-xl: 2rem
  space-2xl: 3rem
---

## Brand & Style
The design system establishes a focused, high-performance atmosphere suited for focused task execution, interval training, culinary tracking, and productivity sprints. It blends strict Material 3 tonal architectures with the engineered clarity of aerospace and developer instruments. 

The aesthetic is precision-driven dark minimalism anchored by intense luminous electric cyan. The emotional intent is poise, instant readability at a distance, and effortless tactile manipulation. High-contrast tabular numbers give data instant legibility, while smooth pill forms soften technical precision into an approachable modern utility.

## Colors
The palette leverages standard Material Design 3 dark mode color roles, driven by a vibrant `#00E5FF` electric cyan seed:

- **Primary (`#00E5FF`)**: Reserved for active time readouts, primary actions (Start/Resume), active track indicators, and active state highlights.
- **Secondary (`#FF9100`)**: Energetic amber applied to warning phases, preparation intervals, pending states, and secondary visual tags.
- **Tertiary (`#FF5252`)**: Punchy coral accent deployed for reset, stop, critical urgency thresholds (final 10 seconds), and overdue notifications.
- **Surface Architecture**:
  - `surface`: `#121416` (deep obsidian ground)
  - `surface-container-lowest`: `#0A0C0D`
  - `surface-container-low`: `#1A1D20`
  - `surface-container`: `#202428`
  - `surface-container-high`: `#2A2F35`
  - `surface-container-highest`: `#353B42`
- **Text & Content**:
  - `on-surface`: `#E6EDF2` (primary text and dynamic numerical digits)
  - `on-surface-variant`: `#9DA8B3` (labels, inactive units, muted auxiliary text)
  - `outline`: `#404850`
  - `outline-variant`: `#282E35`

## Typography
Typographic execution pairs the structural flexibility of `Roboto Flex` with the tabular precision of `JetBrains Mono`.

- **Numerical Display**: All timer readouts, countdown tickers, millisecond stamps, and lap records use `JetBrains Mono` with OpenType tabular figures (`font-variant-numeric: tabular-nums;`) enabled. This eliminates character jitter during real-time decrements.
- **Micro-Labels**: Small operational badges, keyboard input labels, and unit indicators (HR, MIN, SEC) utilize uppercase `JetBrains Mono` with loose tracking (`0.05em` to `0.08em`) to guarantee quick recognition.
- **Narrative Content**: Screen headers, preset descriptive metadata, dialog descriptions, and configuration options deploy `Roboto Flex` with normal geometric proportions for relaxed scanning.

## Layout & Spacing
The layout adheres strictly to an 8dp vertical baseline grid with a 4dp sub-grid for tight control positioning.

- **Mobile (<600dp)**: Single primary viewport column. Vertical stacking places the circular clock canvas in the upper 55% of the viewport, followed by a preset chips rail, terminating with large floating pill control buttons anchored above the Android system navigation bar. Margin is fixed at `1rem` (`16dp`).
- **Tablet (600dp–840dp)**: Centered container or dual-pane configuration where active timers occupy the left pane and stored interval presets/laps align on the right. Margin scales to `2rem` (`32dp`).
- **Desktop / Large Displays (>840dp)**: Contained max-width layout (1080dp maximum) centered on the canvas to maintain visual proximity between interactive triggers and the visual timer circle.

## Elevation & Depth
Elevation is delivered through M3 surface tonal illumination accompanied by subtle luminous glow rather than harsh drop shadows:

- **Level 0 (Base)**: `surface` (`#121416`) with 0 elevation.
- **Level 1 (Cards & Inactive Elements)**: `surface-container-low` (`#1A1D20`) with no shadow; distinct by 1px stroke using `outline-variant` (`#282E35`).
- **Level 2 (Active Sheets & Running Timer Cards)**: `surface-container` (`#202428`) with an ambient diffused contact shadow: `0 4px 16px rgba(0, 0, 0, 0.4)`.
- **Level 3 (Modals & Bottom Sheets)**: `surface-container-high` (`#2A2F35`) with `0 8px 24px rgba(0, 0, 0, 0.6)`.
- **Luminous Accent Elevation**: Active primary control buttons and high-intensity countdown thresholds feature a soft electric cyan ambient glow: `0 0 20px rgba(0, 229, 255, 0.25)`.

## Shapes
In alignment with roundedness value `3` (pill-shaped), the design system champions expressive, friendly radii across all touch targets:

- **Buttons & Chips**: Completely pill-shaped (`9999px` border radius).
- **Cards & Progress Surrounds**: Large rounded corners (`2rem` / `32dp`), creating soft, ergonomic framing for technical data.
- **Progress Track Elements**: Progress bars and circular indicators always terminate with rounded stroke ends (`stroke-linecap: round`), maintaining the pill motif throughout running animations.
- **Input Keypads**: Circular or pill-shaped buttons with tactile inward-radii states.

## Components

### Timer Dial & Circular Progress
- **Track**: Circular SVG with 8dp path width using `surface-container-highest` (`#353B42`).
- **Indicator**: Active stroke in `primary` (`#00E5FF`) with round end caps. On warning interval, smooth transition to `secondary` (`#FF9100`); in critical overtime/final warning, shift to `tertiary` (`#FF5252`).
- **Center Readout**: Prominent `display-lg` tabular readout with stacked micro `label-md` unit tags directly beneath.

### Tactile Control Buttons
- **Primary Play/Pause**: Pill-shaped container (`rounded-full`), height `64dp`, width `64dp` (or expanded to `140dp` width during multi-action layouts). Solid `#00E5FF` background with `#00363D` iconography, emitting a faint cyan bloom when actively running.
- **Secondary Actions (Reset, Lap, Add 30s)**: Tonal pill buttons using `surface-container-high` (`#2A2F35`) with `on-surface` (`#E6EDF2`) text and icons.
- **Destructive/Stop**: Bordered pill with `tertiary` outline and coral text/icon fill.

### Preset Chips
- **Container**: Compact pill container (`rounded-full`), height `36dp`, horizontal padding `16dp`.
- **Inactive**: Background `surface-container-low`, border `1px solid outline-variant`, text `on-surface-variant`.
- **Active / Selected**: Background `primary-container` (translucent cyan `#00E5FF1F`), border `1px solid #00E5FF`, text `#00E5FF`.

### Time Input Keypad & Fields
- **Digits Display**: Non-editable display field featuring segmented digit underlines using `outline` that brighten to `primary` when targeted.
- **Numpad Buttons**: Tactile circular cells (`72dp x 72dp`) set to `surface-container`, highlighting on touch with a rapid ripple effect to `surface-container-highest`.

### Cards & Preset Lists
- **Structure**: Encased in `surface-container-low` with `rounded-lg` (`2rem` / `32dp`) corners.
- **List Items**: Divided by `space-sm` gaps rather than divider rules to allow pill outlines and surfaces to govern distinct grouping.
- **Metadata**: Title in `title-md` (`Roboto Flex`), configured time in `JetBrains Mono` `body-md` in electric cyan tint.