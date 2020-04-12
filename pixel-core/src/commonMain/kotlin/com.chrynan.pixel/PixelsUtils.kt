package com.chrynan.pixel

/**
 * Retrieves a [Pixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.pixels get() = Pixels(this.toDouble())

/**
 * An alias property for [pixels]. Retrieves a [Pixels] representation of this [Number] value.
 *
 * @author chRyNaN
 */
val Number.px get() = Pixels(this.toDouble())

operator fun Pixels.plus(other: Pixels) = Pixels(value + other.value)

operator fun Pixels.minus(other: Pixels) = Pixels(value - other.value)

operator fun Pixels.times(other: Pixels) = Pixels(value * other.value)

operator fun Pixels.div(other: Pixels) = Pixels(value / other.value)

operator fun Pixels.rem(other: Pixels) = Pixels(value % other.value)

operator fun Pixels.unaryPlus() = Pixels(+value)

operator fun Pixels.unaryMinus() = Pixels(-value)
