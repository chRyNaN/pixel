package com.chrynan.pixel

/**
 * A [ScreenDimensionUnit] that represents pixels for a device's screen.
 *
 * Note that this could refer to physical pixels or "virtual" pixels, such as, Javascript's CSS Pixel, for a display.
 * This depends on what the target platform, OS, and device supports. This could also lead to the same [Number] value
 * in multiple different [ScreenDimensionUnit]s, such as [Pixels] and [DensityIndependentPixels], being the same.
 *
 * @see [ScreenDimensionUnit] for more information.
 *
 * @author chRyNaN
 */
inline class Pixels(override val value: Float) : ScreenDimensionUnit,
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