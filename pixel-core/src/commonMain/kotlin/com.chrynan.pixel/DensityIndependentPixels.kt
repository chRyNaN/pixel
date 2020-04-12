package com.chrynan.pixel

/**
 * Represents a Density Independent Pixel similar to Android's Dip/Dp values.
 */
inline class DensityIndependentPixels(override val value: Double) : ScreenDimensionUnit,
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