package com.chrynan.pixel

/**
 * A [ScreenDimensionUnit] that represents a density independent pixel similar to Android's Dip/Dp values.
 *
 * @see [ScreenDimensionUnit] for more information.
 * @see [Pixels] for more information.
 *
 * @author chRyNaN
 */
inline class DensityIndependentPixels(override val value: Float) : ScreenDimensionUnit,
    Comparable<DensityIndependentPixels> {

    override val type: ScreenDimensionType
        get() = ScreenDimensionType.DENSITY_INDEPENDENT_PIXELS

    override val isConstantPhysicalSize
        get() = false

    override val isDensityIndependent
        get() = true

    override fun compareTo(other: DensityIndependentPixels): Int = value.compareTo(other.value)

    override fun toString() = "{DensityIndependentPixels: $value}"
}