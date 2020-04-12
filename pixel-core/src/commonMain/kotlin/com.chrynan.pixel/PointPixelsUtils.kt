package com.chrynan.pixel

/**
 * Retrieves a [PointPixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.pointPixels: PointPixels get() = PointPixels(this.toDouble())

/**
 * An alias property for [pointPixels]. Retrieves a [PointPixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.pt: PointPixels get() = PointPixels(this.toDouble())

operator fun PointPixels.plus(other: PointPixels): PointPixels = PointPixels(value + other.value)

operator fun PointPixels.minus(other: PointPixels): PointPixels = PointPixels(value - other.value)

operator fun PointPixels.times(other: PointPixels): PointPixels = PointPixels(value * other.value)

operator fun PointPixels.div(other: PointPixels): PointPixels = PointPixels(value / other.value)

operator fun PointPixels.rem(other: PointPixels): PointPixels = PointPixels(value % other.value)

operator fun PointPixels.unaryPlus(): PointPixels = PointPixels(+value)

operator fun PointPixels.unaryMinus(): PointPixels = PointPixels(-value)

operator fun PointPixels.plus(other: Number): PointPixels = PointPixels(value + other.toDouble())

operator fun PointPixels.minus(other: Number): PointPixels = PointPixels(value - other.toDouble())

operator fun PointPixels.times(other: Number): PointPixels = PointPixels(value * other.toDouble())

operator fun PointPixels.div(other: Number): PointPixels = PointPixels(value / other.toDouble())

operator fun PointPixels.rem(other: Number): PointPixels = PointPixels(value % other.toDouble())

operator fun Number.plus(other: PointPixels): PointPixels = PointPixels(toDouble() + other.value)

operator fun Number.minus(other: PointPixels): PointPixels = PointPixels(toDouble() - other.value)

operator fun Number.times(other: PointPixels): PointPixels = PointPixels(toDouble() * other.value)

operator fun Number.div(other: PointPixels): PointPixels = PointPixels(toDouble() / other.value)

operator fun Number.rem(other: PointPixels): PointPixels = PointPixels(toDouble() % other.value)

fun min(a: PointPixels, b: PointPixels): PointPixels = PointPixels(kotlin.math.min(a.value, b.value))

fun max(a: PointPixels, b: PointPixels): PointPixels = PointPixels(kotlin.math.max(a.value, b.value))

fun PointPixels.coerceIn(min: PointPixels, max: PointPixels): PointPixels =
    PointPixels(value.coerceIn(min.value, max.value))

fun PointPixels.coerceAtLeast(min: PointPixels): PointPixels = PointPixels(value.coerceAtLeast(min.value))

fun PointPixels.coerceAtMost(max: PointPixels): PointPixels = PointPixels(value.coerceAtMost(max.value))

fun PointPixels.isFinite(): Boolean = value != Double.POSITIVE_INFINITY

fun PointPixels.isInfinite(): Boolean = value == Double.POSITIVE_INFINITY

