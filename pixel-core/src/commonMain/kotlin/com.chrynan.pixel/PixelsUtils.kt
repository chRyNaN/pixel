package com.chrynan.pixel

import kotlin.math.max
import kotlin.math.min

/**
 * Retrieves a [Pixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.pixels: Pixels get() = Pixels(this.toFloat())

/**
 * An alias property for [pixels]. Retrieves a [Pixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.px: Pixels get() = Pixels(this.toFloat())

operator fun Pixels.plus(other: Pixels): Pixels = Pixels(value + other.value)

operator fun Pixels.minus(other: Pixels): Pixels = Pixels(value - other.value)

operator fun Pixels.times(other: Pixels): Pixels = Pixels(value * other.value)

operator fun Pixels.div(other: Pixels): Pixels = Pixels(value / other.value)

operator fun Pixels.rem(other: Pixels): Pixels = Pixels(value % other.value)

operator fun Pixels.unaryPlus(): Pixels = Pixels(+value)

operator fun Pixels.unaryMinus(): Pixels = Pixels(-value)

operator fun Pixels.plus(other: Number): Pixels = Pixels(value + other.toFloat())

operator fun Pixels.minus(other: Number): Pixels = Pixels(value - other.toFloat())

operator fun Pixels.times(other: Number): Pixels = Pixels(value * other.toFloat())

operator fun Pixels.div(other: Number): Pixels = Pixels(value / other.toFloat())

operator fun Pixels.rem(other: Number): Pixels = Pixels(value % other.toFloat())

operator fun Number.plus(other: Pixels): Pixels = Pixels(toFloat() + other.value)

operator fun Number.minus(other: Pixels): Pixels = Pixels(toFloat() - other.value)

operator fun Number.times(other: Pixels): Pixels = Pixels(toFloat() * other.value)

operator fun Number.div(other: Pixels): Pixels = Pixels(toFloat() / other.value)

operator fun Number.rem(other: Pixels): Pixels = Pixels(toFloat() % other.value)

fun min(a: Pixels, b: Pixels): Pixels = Pixels(min(a.value, b.value))

fun max(a: Pixels, b: Pixels): Pixels = Pixels(max(a.value, b.value))

fun Pixels.coerceIn(min: Pixels, max: Pixels): Pixels = Pixels(value.coerceIn(min.value, max.value))

fun Pixels.coerceAtLeast(min: Pixels): Pixels = Pixels(value.coerceAtLeast(min.value))

fun Pixels.coerceAtMost(max: Pixels): Pixels = Pixels(value.coerceAtMost(max.value))

fun Pixels.isFinite(): Boolean = value != Float.POSITIVE_INFINITY

fun Pixels.isInfinite(): Boolean = value == Float.POSITIVE_INFINITY
