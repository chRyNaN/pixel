package com.chrynan.pixel

/**
 * A single [PointPixels] is 1/72 of a physical inch.
 */
inline class PointPixels(override val value: Double) : ScreenDimensionUnit,
    Comparable<PointPixels> {

    override val type: ScreenDimensionType
        get() = ScreenDimensionType.POINT_PIXEL

    override val isConstantPhysicalSize
        get() = true

    override val isDensityIndependent
        get() = true

    val pointPixelsPerInch
        get() = ConversionFactorProvider.POINT_PIXELS_PER_INCH

    override fun compareTo(other: PointPixels): Int = value.compareTo(other.value)

    override fun toString() = "{PointPixels: $value}"
}