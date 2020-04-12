package com.chrynan.pixel

/**
 * Retrieves a [ScaledPixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.scaledPixels get() = ScaledPixels(this.toDouble())

/**
 * An alias property for [scaledPixels]. Retrieves a [ScaledPixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.sp get() = ScaledPixels(this.toDouble())

operator fun ScaledPixels.plus(other: ScaledPixels) = ScaledPixels(value + other.value)

operator fun ScaledPixels.minus(other: ScaledPixels) = ScaledPixels(value - other.value)

operator fun ScaledPixels.times(other: ScaledPixels) = ScaledPixels(value * other.value)

operator fun ScaledPixels.div(other: ScaledPixels) = ScaledPixels(value / other.value)

operator fun ScaledPixels.rem(other: ScaledPixels) = ScaledPixels(value % other.value)

operator fun ScaledPixels.unaryPlus() = ScaledPixels(+value)

operator fun ScaledPixels.unaryMinus() = ScaledPixels(-value)
