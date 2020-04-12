package com.chrynan.pixel

/**
 * An interface that contains factor values used to convert between different supported [ScreenDimensionUnit]s.
 *
 * @author chRyNaN
 */
interface ConversionFactorProvider {

    companion object {

        /**
         * The amount of point pixels within an inch.
         *
         * @author chRyNaN
         */
        const val POINT_PIXELS_PER_INCH = 72f
    }

    /**
     * A factor value used to convert from [DensityIndependentPixels] to [Pixels]. If the [ScreenDimensionUnit.value]
     * proptery of a [DensityIndependentPixels] instance is multiplied by this factor, then it should equal the amount
     * of [Pixels].
     *
     * @author chRyNaN
     */
    val dipToPxFactor: Float

    /**
     * A factor value used to convert from [ScaledPixels] to [Pixels]. If the [ScreenDimensionUnit.value] property of a
     * [ScaledPixels] instance is multiplied by this factor, then it should equal the amount of [Pixels].
     *
     * @author chRyNaN
     */
    val spToPxFactor: Float

    /**
     * A factor value used to convert from [PointPixels] to [Pixels]. If the [ScreenDimensionUnit.value] property of a
     * [PointPixels] instance is multiplied by this factor, then it should equal the amount of [Pixels].
     *
     * @author chRyNaN
     */
    val ptToPxFactor: Float
}