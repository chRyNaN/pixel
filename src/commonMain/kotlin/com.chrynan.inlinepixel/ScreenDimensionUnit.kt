package com.chrynan.inlinepixel

sealed class ScreenDimensionUnit(val value: Int) {

    abstract val isConstantPhysicalSize: Boolean

    abstract val isDensityIndependent: Boolean
}

/**
 * Represents Physical Pixels for a device's screen.
 */
class Pixels(value: Int) : ScreenDimensionUnit(value),
    Comparable<Pixels> {

    override val isConstantPhysicalSize
        get() = false

    override val isDensityIndependent
        get() = false

    override fun compareTo(other: Pixels): Int = value.compareTo(other.value)

    override fun toString() = "{Pixels: $value}"
}

/**
 * A single [PointPixels] is 1/72 of a physical inch.
 */
class PointPixels(value: Int) : ScreenDimensionUnit(value),
    Comparable<PointPixels> {

    override val isConstantPhysicalSize
        get() = true

    override val isDensityIndependent
        get() = true

    val pointPixelsPerInch
        get() = ConversionFactorProvider.POINT_PIXELS_PER_INCH

    override fun compareTo(other: PointPixels): Int = value.compareTo(other.value)

    override fun toString() = "{PointPixels: $value}"
}

/**
 * Represents a Scaled Pixel, similar to Android's Sp values.
 */
class ScaledPixels(value: Int) : ScreenDimensionUnit(value),
    Comparable<ScaledPixels> {

    override val isConstantPhysicalSize
        get() = false

    override val isDensityIndependent
        get() = true

    override fun compareTo(other: ScaledPixels): Int = value.compareTo(other.value)

    override fun toString() = "{ScaledPixels: $value}"
}

/**
 * Represents a Device Independent Pixel similar to Android's Dip/Dp values.
 */
class DependencyIndependentPixels(value: Int) : ScreenDimensionUnit(value),
    Comparable<DependencyIndependentPixels> {

    override val isConstantPhysicalSize
        get() = false

    override val isDensityIndependent
        get() = true

    override fun compareTo(other: DependencyIndependentPixels): Int = value.compareTo(other.value)

    override fun toString() = "{DependencyIndependentPixels: $value}"
}