package com.chrynan.pixel

/**
 * Retrieves a [DensityIndependentPixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.densityIndependentPixels get() = DensityIndependentPixels(this.toDouble())

/**
 * An alias property for [densityIndependentPixels]. Retrieves a [DensityIndependentPixels] representation of this
 * [Number] value.
 *
 * @author chRyNaN
 */
val Number.dp get() = DensityIndependentPixels(this.toDouble())

operator fun DensityIndependentPixels.plus(other: DensityIndependentPixels) =
    DensityIndependentPixels(value + other.value)

operator fun DensityIndependentPixels.minus(other: DensityIndependentPixels) =
    DensityIndependentPixels(value - other.value)

operator fun DensityIndependentPixels.times(other: DensityIndependentPixels) =
    DensityIndependentPixels(value * other.value)

operator fun DensityIndependentPixels.div(other: DensityIndependentPixels) =
    DensityIndependentPixels(value / other.value)

operator fun DensityIndependentPixels.rem(other: DensityIndependentPixels) =
    DensityIndependentPixels(value % other.value)

operator fun DensityIndependentPixels.unaryPlus() = DensityIndependentPixels(+value)

operator fun DensityIndependentPixels.unaryMinus() = DensityIndependentPixels(-value)
