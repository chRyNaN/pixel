package com.chrynan.pixel

/**
 * Represents a Scaled Pixel, similar to Android's Sp values.
 */
inline class ScaledPixels(override val value: Double) : ScreenDimensionUnit,
    Comparable<ScaledPixels> {

    override val type: ScreenDimensionType
        get() = ScreenDimensionType.SCALED_PIXEL

    override val isConstantPhysicalSize
        get() = false

    override val isDensityIndependent
        get() = true

    override fun compareTo(other: ScaledPixels): Int = value.compareTo(other.value)

    override fun toString() = "{ScaledPixels: $value}"
}