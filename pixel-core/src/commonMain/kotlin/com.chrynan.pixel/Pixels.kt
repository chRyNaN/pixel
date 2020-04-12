package com.chrynan.pixel

/**
 * Represents Physical Pixels for a device's screen.
 */
inline class Pixels(override val value: Double) : ScreenDimensionUnit,
    Comparable<Pixels> {

    override val type: ScreenDimensionType
        get() = ScreenDimensionType.PIXEL

    override val isConstantPhysicalSize
        get() = false

    override val isDensityIndependent
        get() = false

    override fun compareTo(other: Pixels): Int = value.compareTo(other.value)

    override fun toString() = "{Pixels: $value}"
}