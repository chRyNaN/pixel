package com.chrynan.pixel

/**
 * Retrieves a [PointPixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.pointPixels get() = PointPixels(this.toDouble())

/**
 * An alias property for [pointPixels]. Retrieves a [PointPixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.pt get() = PointPixels(this.toDouble())

operator fun PointPixels.plus(other: PointPixels) = PointPixels(value + other.value)

operator fun PointPixels.minus(other: PointPixels) = PointPixels(value - other.value)

operator fun PointPixels.times(other: PointPixels) = PointPixels(value * other.value)

operator fun PointPixels.div(other: PointPixels) = PointPixels(value / other.value)

operator fun PointPixels.rem(other: PointPixels) = PointPixels(value % other.value)

operator fun PointPixels.unaryPlus() = PointPixels(+value)

operator fun PointPixels.unaryMinus() = PointPixels(-value)
