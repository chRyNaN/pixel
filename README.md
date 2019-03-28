# pixel

## Kotlin Classes for Screen Dimension Units

This Kotlin Multi-platform library provides type safety over screen units, such as pixels. Available `ScreenDimensionUnits` interface implementations include:
* Pixels (PX)
* DependencyIndependentPixels (DIP/DP)
* ScaledPixels (SP)
* PointPixels (PT)

This provides type safety of knowing what you are working with (ex: `fun drawLine(start: Pixels, end: Pixels)`).

**Note:** This library used to use Kotlin's Inline Class Experimental feature. This allowed it to maintain performance. However, due to issues with the new Kotlin Multi-platform Structure, the inline classes were dropped. This support may come back in a future release if the issues are solved.

## Building the library

[![](https://jitpack.io/v/chRyNaN/inline-pixel.svg)](https://jitpack.io/#chRyNaN/pixel)

This project is provided by [JitPack](https://jitpack.io/#chRyNaN/pixel). **Note:** that there are some issues with Kotlin Multi-platform dependencies and JitPack, so the dependencies may not resolve correctly.

```groovy
implementation 'com.github.chRyNaN.pixel:VERSION'
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

// Note: currently a ScreenDimensionUnit is represented by an Int value
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

Even better conversions anywhere within the app when the `Pixel` object is initialized correctly

```kotlin
class MyApplication : Application() {

    fun onCreate() {
        super.onCreate()
        
        Pixel.converter = ContextScreenDimensionUnitConverter(this)
    }
}

class MyPresenter {

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
