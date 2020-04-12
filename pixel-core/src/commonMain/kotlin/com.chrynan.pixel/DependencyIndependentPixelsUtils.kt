package com.chrynan.pixel

/**
 * Retrieves a [DensityIndependentPixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.densityIndependentPixels: DensityIndependentPixels get() = DensityIndependentPixels(this.toDouble())

/**
 * An alias property for [densityIndependentPixels]. Retrieves a [DensityIndependentPixels] representation of this
 * [Number] value.
 *
 * @author chRyNaN
 */
val Number.dp: DensityIndependentPixels get() = DensityIndependentPixels(this.toDouble())

operator fun DensityIndependentPixels.plus(other: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(value + other.value)

operator fun DensityIndependentPixels.minus(other: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(value - other.value)

operator fun DensityIndependentPixels.times(other: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(value * other.value)

operator fun DensityIndependentPixels.div(other: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(value / other.value)

operator fun DensityIndependentPixels.rem(other: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(value % other.value)

operator fun DensityIndependentPixels.unaryPlus(): DensityIndependentPixels = DensityIndependentPixels(+value)

operator fun DensityIndependentPixels.unaryMinus(): DensityIndependentPixels = DensityIndependentPixels(-value)

operator fun DensityIndependentPixels.plus(other: Number): DensityIndependentPixels =
    DensityIndependentPixels(value + other.toDouble())

operator fun DensityIndependentPixels.minus(other: Number): DensityIndependentPixels =
    DensityIndependentPixels(value - other.toDouble())

operator fun DensityIndependentPixels.times(other: Number): DensityIndependentPixels =
    DensityIndependentPixels(value * other.toDouble())

operator fun DensityIndependentPixels.div(other: Number): DensityIndependentPixels =
    DensityIndependentPixels(value / other.toDouble())

operator fun DensityIndependentPixels.rem(other: Number): DensityIndependentPixels =
    DensityIndependentPixels(value % other.toDouble())

operator fun Number.plus(other: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(toDouble() + other.value)

operator fun Number.minus(other: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(toDouble() - other.value)

operator fun Number.times(other: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(toDouble() * other.value)

operator fun Number.div(other: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(toDouble() / other.value)

operator fun Number.rem(other: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(toDouble() % other.value)

fun min(a: DensityIndependentPixels, b: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(kotlin.math.min(a.value, b.value))

fun max(a: DensityIndependentPixels, b: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(kotlin.math.max(a.value, b.value))

fun DensityIndependentPixels.coerceIn(
    min: DensityIndependentPixels,
    max: DensityIndependentPixels
): DensityIndependentPixels = DensityIndependentPixels(value.coerceIn(min.value, max.value))

fun DensityIndependentPixels.coerceAtLeast(min: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(value.coerceAtLeast(min.value))

fun DensityIndependentPixels.coerceAtMost(max: DensityIndependentPixels): DensityIndependentPixels =
    DensityIndependentPixels(value.coerceAtMost(max.value))

fun DensityIndependentPixels.isFinite(): Boolean = value != Double.POSITIVE_INFINITY

fun DensityIndependentPixels.isInfinite(): Boolean = value == Double.POSITIVE_INFINITY
