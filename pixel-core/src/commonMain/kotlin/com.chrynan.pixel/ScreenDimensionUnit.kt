package com.chrynan.pixel

/**
 * An interface representing a unit of measure for a Device's screen space, or dimensions. An example of a
 * [ScreenDimensionUnit] is [Pixels] which represents an amount of pixels on the Device's screen.
 *
 * Note that it is possible that multiple [ScreenDimensionUnit]s equal the same value. This could be due to multiple
 * reasons including what the particular Device and it's platform and operating system support. For instance, for
 * Javascript in the browser, there may be no notion of density available, so perhaps the same [Number] value in
 * [Pixels] and [DensityIndependentPixels] is equivalent.
 *
 * Note that this interface represents a dimension unit for a device's screen, such as pixels, for a provided amount
 * represented by the [value] property. This interface (and implementations of it) don't specify exactly how the
 * dimension unit is represented by the system, other than an abstract notion (pixels). As stated above, this is due to
 * different platforms handling the values differently (such as physical pixels vs virtual pixels). So a
 * [ScreenDimensionUnit] on one system (device, OS, platform, etc) might be represented differently than the same
 * [ScreenDimensionUnit] value on another system.
 *
 * @author chRyNaN
 */
interface ScreenDimensionUnit {

    /**
     * The underlying [Float] representing this [ScreenDimensionUnit].
     *
     * @author chRyNaN
     */
    val value: Float

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
