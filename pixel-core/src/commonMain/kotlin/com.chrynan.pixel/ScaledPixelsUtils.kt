package com.chrynan.pixel

/**
 * Retrieves a [ScaledPixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.scaledPixels: ScaledPixels get() = ScaledPixels(this.toDouble())

/**
 * An alias property for [scaledPixels]. Retrieves a [ScaledPixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.sp: ScaledPixels get() = ScaledPixels(this.toDouble())

operator fun ScaledPixels.plus(other: ScaledPixels): ScaledPixels = ScaledPixels(value + other.value)

operator fun ScaledPixels.minus(other: ScaledPixels): ScaledPixels = ScaledPixels(value - other.value)

operator fun ScaledPixels.times(other: ScaledPixels): ScaledPixels = ScaledPixels(value * other.value)

operator fun ScaledPixels.div(other: ScaledPixels): ScaledPixels = ScaledPixels(value / other.value)

operator fun ScaledPixels.rem(other: ScaledPixels): ScaledPixels = ScaledPixels(value % other.value)

operator fun ScaledPixels.unaryPlus(): ScaledPixels = ScaledPixels(+value)

operator fun ScaledPixels.unaryMinus(): ScaledPixels = ScaledPixels(-value)

operator fun ScaledPixels.plus(other: Number): ScaledPixels = ScaledPixels(value + other.toDouble())

operator fun ScaledPixels.minus(other: Number): ScaledPixels = ScaledPixels(value - other.toDouble())

operator fun ScaledPixels.times(other: Number): ScaledPixels = ScaledPixels(value * other.toDouble())

operator fun ScaledPixels.div(other: Number): ScaledPixels = ScaledPixels(value / other.toDouble())

operator fun ScaledPixels.rem(other: Number): ScaledPixels = ScaledPixels(value % other.toDouble())

operator fun Number.plus(other: ScaledPixels): ScaledPixels = ScaledPixels(toDouble() + other.value)

operator fun Number.minus(other: ScaledPixels): ScaledPixels = ScaledPixels(toDouble() - other.value)

operator fun Number.times(other: ScaledPixels): ScaledPixels = ScaledPixels(toDouble() * other.value)

operator fun Number.div(other: ScaledPixels): ScaledPixels = ScaledPixels(toDouble() / other.value)

operator fun Number.rem(other: ScaledPixels): ScaledPixels = ScaledPixels(toDouble() % other.value)

fun min(a: ScaledPixels, b: ScaledPixels): ScaledPixels = ScaledPixels(kotlin.math.min(a.value, b.value))

fun max(a: ScaledPixels, b: ScaledPixels): ScaledPixels = ScaledPixels(kotlin.math.max(a.value, b.value))

fun ScaledPixels.coerceIn(min: ScaledPixels, max: ScaledPixels): ScaledPixels =
    ScaledPixels(value.coerceIn(min.value, max.value))

fun ScaledPixels.coerceAtLeast(min: ScaledPixels): ScaledPixels = ScaledPixels(value.coerceAtLeast(min.value))

fun ScaledPixels.coerceAtMost(max: ScaledPixels): ScaledPixels = ScaledPixels(value.coerceAtMost(max.value))

fun ScaledPixels.isFinite(): Boolean = value != Double.POSITIVE_INFINITY

fun ScaledPixels.isInfinite(): Boolean = value == Double.POSITIVE_INFINITY