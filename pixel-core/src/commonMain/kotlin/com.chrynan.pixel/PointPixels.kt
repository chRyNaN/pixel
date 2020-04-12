package com.chrynan.pixel

/**
 * A [ScreenDimensionUnit] that represents a point pixel for a device's screen. A point pixel is a pixel value that is
 * dependent on the device's physical size. A single [PointPixels] is 1/72 of a physical inch.
 *
 * Note that some target platforms, operating systems, and devices may not provide access to the physical size of a
 * device, or a density value to obtain the physical size of a device. In such cases, this value may either be in
 * reference to [Pixels] or equivalent to [Pixels].
 *
 * @see [ScreenDimensionUnit] for more information.
 * @see [Pixels] for more information.
 *
 * @author chRyNaN
 */
inline class PointPixels(override val value: Float) : ScreenDimensionUnit,
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