package com.chrynan.pixel

/**
 * A Kotlin object used for converting between different [ScreenDimensionUnit]s using the
 * [ScreenDimensionUnitConverter] property.
 *
 * @author chRyNaN
 */
object Pixel {

    /**
     * Sets the [ScreenDimensionUnitConverter] used to convert between different [ScreenDimensionUnit]s. This is used
     * in the [inPixels], [inPointPixels], [inScaledPixels], and [inDensityIndependentPixels] properties.
     *
     * @author chRyNaN
     */
    lateinit var converter: ScreenDimensionUnitConverter
}

/**
 * Retrieves a [Pixels] representation of this [ScreenDimensionUnit].
 *
 * @author chRyNaN
 */
val ScreenDimensionUnit.inPixels: Pixels
    get() = Pixel.converter.run {
        toPx()
    }

/**
 * An alias for [inPixels]. Retrieves a [Pixels] representation of this [ScreenDimensionUnit].
 *
 * @author chRyNaN
 */
val ScreenDimensionUnit.inPx get() = inPixels

/**
 * Retrieves a [DensityIndependentPixels] representation of this [ScreenDimensionUnit].
 *
 * @author chRyNaN
 */
val ScreenDimensionUnit.inDensityIndependentPixels: DensityIndependentPixels
    get() = Pixel.converter.run {
        toDip()
    }

/**
 * An alias for [inDensityIndependentPixels]. Retrieves a [DensityIndependentPixels] representation of this
 * [ScreenDimensionUnit].
 *
 * @author chRyNaN
 */
val ScreenDimensionUnit.inDp get() = inDensityIndependentPixels

/**
 * Retrieves a [ScaledPixels] representation of this [ScreenDimensionUnit].
 *
 * @author chRyNaN
 */
val ScreenDimensionUnit.inScaledPixels: ScaledPixels
    get() = Pixel.converter.run {
        toSp()
    }

/**
 * An alias for [inScaledPixels]. Retrieves a [ScaledPixels] representation of this [ScreenDimensionUnit].
 *
 * @author chRyNaN
 */
val ScreenDimensionUnit.inSp get() = inScaledPixels

/**
 * Retrieves a [PointPixels] representation of this [ScreenDimensionUnit].
 *
 * @author chRyNaN
 */
val ScreenDimensionUnit.inPointPixels: PointPixels
    get() = Pixel.converter.run {
        toPt()
    }

/**
 * An alias for [inPointPixels]. Retrieves a [PointPixels] representation of this [ScreenDimensionUnit].
 *
 * @author chRyNaN
 */
val ScreenDimensionUnit.inPt get() = inPointPixels