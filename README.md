# inline-pixel
Kotlin Inline Classes for Android Screen Dimension Units

I was messing around with the new Kotlin Inline Class feature and came up with this library.

This library provides type safety over screen units, such as pixels, while being just as performant as using Kotlin primitives by taking advantage of the new Kotlin Inline Classes. Available `ScreenDimensionUnits` interface implementations include:
* Pixels (PX)
* DependencyIndependentPixels (DIP/DP)
* ScaledPixels (SP)
* PointPixels (PT)

This provides type safety of knowing what you are working with (ex: `fun drawLine(start: Pixels, end: Pixels)`) while still maintaining performance (because Kotlin Inline Classes are compiled down to using the wrapped primitive internally).
