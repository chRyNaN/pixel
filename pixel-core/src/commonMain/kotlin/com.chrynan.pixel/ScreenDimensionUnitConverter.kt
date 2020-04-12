package com.chrynan.pixel

/**
 * An interface responsible for converting between different supported [ScreenDimensionUnit]s. This interface provides
 * functions for converting between the different [ScreenDimensionUnit]s, such as the [toPx] function which converts
 * a [ScreenDimensionUnit] to [Pixels].
 *
 * @author chRyNaN
 */
interface ScreenDimensionUnitConverter {

    /**
     * Converts this [ScreenDimensionUnit] to [Pixels].
     *
     * @author chRyNaN
     */
    fun ScreenDimensionUnit.toPx(): Pixels

    /**
     * Converts this [ScreenDimensionUnit] to [DensityIndependentPixels].
     *
     * @author chRyNaN
     */
    fun ScreenDimensionUnit.toDip(): DensityIndependentPixels

    /**
     * Converts this [ScreenDimensionUnit] to [ScaledPixels].
     *
     * @author chRyNaN
     */
    fun ScreenDimensionUnit.toSp(): ScaledPixels

    /**
     * Converts this [ScreenDimensionUnit] to [PointPixels].
     *
     * @author chRyNaN
     */
    fun ScreenDimensionUnit.toPt(): PointPixels
}