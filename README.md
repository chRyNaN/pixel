# pixel

## Kotlin Classes for Screen Dimension Units

This Kotlin Multi-platform library provides type safety over screen units, such as pixels. Available `ScreenDimensionUnits` interface implementations include:
* Pixels (PX)
* DependencyIndependentPixels (DIP/DP)
* ScaledPixels (SP)
* PointPixels (PT)

This provides type safety of knowing what you are working with (ex: `fun drawLine(start: Pixels, end: Pixels)`).

## Building the library

[![](https://jitpack.io/v/chRyNaN/inline-pixel.svg)](https://jitpack.io/#chRyNaN/pixel)

The library is provided through [Bintray](https://bintray.com/). Refer to the [releases](https://github.com/chRyNaN/pixel/releases) for the latest version.

### Repository

```groovy
repositories {
    maven {
        url = uri("https://dl.bintray.com/chrynan/chrynan")
    }
}
```

### Dependencies

**Base Kotlin Common Library:**
```groovy
implementation 'com.chrynan.pixel:pixel-core:VERSION'
```

**Android Library:**
```groovy
implementation 'com.chrynan.pixel:pixel-android:VERSION'
```

## Using the library

* Setup the `ScreenDimensionUnitConverter` on the `Pixel` object.

**Android:**
```kotlin
class MyApplication : Application {

    override fun onCreate() {
        super.onCreate()

        Pixel.converter = AndroidScreenDimensionUnitConverter(context = this)
    }   
}
```

**Kotlin JS:**
```kotlin
Pixel.converter = JsScreenDimensionUnitConverter()
```

* Convert any Kotlin `Number` to a particular `ScreenDimensionUnit`:
```kotlin
val pixels = 100.0.px
val scaledPixels = 25.sp
val densityIndependentPixels = 12f.dp
val pointPixels = 5L.pt

val pixelSum = 10.px + 20.px

if (pixels > 150.px) { }
```

