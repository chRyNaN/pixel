package com.chrynan.pixel

/**
 * A default Javascript implementation of the [ConversionFactorProvider] interface.
 *
 * Note that in Javascript, a pixel (CSS pixel), is similar to Android's density independent pixel values. Because of
 * this, the [Pixels], [DensityIndependentPixels], and [ScaledPixels] are equivalent.
 *
 * Note that in Javascript, there is no access (to my knowledge) of the physical display size. There is only access to
 * the amount of CSS Pixels in a display. Since [PointPixels] are based off the physical display size, and there is no
 * way to acquire the display size needed for conversion, [Pixels] and [PointPixels] are equivalent.
 *
 * @author chRyNaN
 */
class JsConversionFactorProvider : ConversionFactorProvider {

    override val dipToPxFactor: Float = 1f

    override val spToPxFactor: Float = 1f

    override val ptToPxFactor: Float = 1f
}