# inline-pixel

## Kotlin Inline Classes for Android Screen Dimension Units

I was messing around with the new Kotlin Inline Class feature and came up with this library.

This library provides type safety over screen units, such as pixels, while being just as performant as using Kotlin primitives by taking advantage of the new Kotlin Inline Classes. Available `ScreenDimensionUnits` interface implementations include:
* Pixels (PX)
* DependencyIndependentPixels (DIP/DP)
* ScaledPixels (SP)
* PointPixels (PT)

This provides type safety of knowing what you are working with (ex: `fun drawLine(start: Pixels, end: Pixels)`) while still maintaining performance (because Kotlin Inline Classes are compiled down to using the wrapped primitive internally).

## Building the library

[![](https://jitpack.io/v/chRyNaN/inline-pixel.svg)](https://jitpack.io/#chRyNaN/inline-pixel)

**Kotlin Common Inline Classes:**
```groovy
implementation 'com.github.chRyNaN.inline-pixel:common:VERSION'
```

**Common JVM:**
```groovy
implementation 'com.github.chRyNaN.inline-pixel:common-jvm:VERSION'
```

**Common JS:**
```groovy
implementation 'com.github.chRyNaN.inline-pixel:common-js:VERSION'
```

**Android Conversions and Utilities:**
```groovy
implementation 'com.github.chRyNaN.inline-pixel:android:VERSION'
```

## Using the library


Simply use the class that represents the value needed for type safety:

```kotlin
fun sum(px1: Pixels, px2: Pixels): Pixels = px1 + px2
```

Easily convert Kotlin `Numbers` to a `ScreenDimensionUnit`:

```kotlin
val scaledPixels = 25.asScaledPixels()
// Or
val otherScaledPixels = 100.asSp()
```

Instantiating an instance:

```kotlin
val dipValue = DependencyIndependentPixels(5) // Constructor takes an Int parameter
val otherDipValue = dependencyIndependentPixels(1f) // The Number parameter is converted to an Int and wrapped in the sealed class
val andAnotherDipValue = dip(10) // Convenience for shorthand use
val singleDipValue = dependencyIndependentPixel() // Singular (no "s" at the end)
val anotherSingleDipValue = dip() // Defaults to a value of 1
```

Use operator functions:

```kotlin
PointPixel(3) - PointPixel(1) // Equals PointPixel(2)
PointPixel(5) * PointPixel(5) // Equals PointPixel(25)
```

Comparisons:

```kotlin
if (pixel1 > pixel2) { ... }
```

Ranges:

```kotlin
for (p in pixel1 until pixel2) { ... }
```

On Android, it's easy to convert between the different `ScreenDimensionUnits` using a `Resources` object or just a `Context` object for convenience:

```kotlin
resources.convertPxToDip(pixels)
// Or
context.convertPxToDip(pixels)
```

Better conversions syntax within an implementation of the `ScreenDimensionUnitConverter`

```kotlin
class Presenter(private val context) : ScreenDimensionUnitConverter by ContextScreenDimensionUnitConverter(context){

    fun testConversions() {
        px(2).toDip()
        sp(5).toPt()
    }
}
```

Convenience properties and functions for Android Views:

```kotlin
fun onDraw(canvas: Canvas) {
    val diff: Pixels = heightPx - widthPx
    val paddingLeftDip = paddingLeftPx.toDip()
}
```
