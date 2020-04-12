package com.chrynan.pixel

/**
 * An interface representing a unit of measure for a Device's screen space, or dimensions.
 *
 * @author chRyNaN
 */
interface ScreenDimensionUnit {

    /**
     * The underlying [Double] representing this [ScreenDimensionUnit].
     *
     * @author chRyNaN
     */
    val value: Double

    /**
     * The [ScreenDimensionType] of this [ScreenDimensionUnit].
     *
     * @author chRyNaN
     */
    val type: ScreenDimensionType

    /**
     * A [Boolean] value indicating whether this [ScreenDimensionUnit] is a constant physical size, meaning that it
     * represents a static physical size that does not change depending on the pixel density of a Device's screen.
     *
     * @author chRyNaN
     */
    val isConstantPhysicalSize: Boolean

    /**
     * A [Boolean] value indicating whether this [ScreenDimensionUnit] is a density independent size, meaning that the
     * Device's pixel density doesn't directly change it's size. Note that this does not mean that it is a constant
     * physical size indicated by the [isConstantPhysicalSize] property.
     *
     * @author chRyNaN
     */
    val isDensityIndependent: Boolean
}
