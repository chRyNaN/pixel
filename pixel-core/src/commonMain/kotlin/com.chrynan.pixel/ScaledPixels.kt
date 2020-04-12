package com.chrynan.pixel

/**
 * A [ScreenDimensionUnit] that represents a Scaled Pixel, similar to Android's Sp values.
 *
 * @see [ScreenDimensionUnit] for more information.
 * @see [Pixels] for more information.
 *
 * @author chRyNaN
 */
inline class ScaledPixels(override val value: Float) : ScreenDimensionUnit,
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