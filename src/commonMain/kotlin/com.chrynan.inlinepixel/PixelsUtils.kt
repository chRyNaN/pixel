@file:Suppress("unused")

package com.chrynan.inlinepixel

fun pixel() = Pixels(1)

fun pixels(value: Number) = value.asPixels()

fun px(value: Number = 1) = value.asPixels()

fun Number.asPixels() = Pixels(this.toInt())

fun Number.asPx() = Pixels(this.toInt())

operator fun Pixels.plus(other: Pixels) = Pixels(value + other.value)

operator fun Pixels.minus(other: Pixels) = Pixels(value - other.value)

operator fun Pixels.times(other: Pixels) = Pixels(value * other.value)

operator fun Pixels.div(other: Pixels) = Pixels(value / other.value)

operator fun Pixels.rem(other: Pixels) = Pixels(value % other.value)

operator fun Pixels.unaryPlus() = Pixels(+value)

operator fun Pixels.unaryMinus() = Pixels(-value)

operator fun Pixels.rangeTo(other: Pixels) = PixelsRange(this, other)

infix fun Pixels.until(to: Pixels): PixelsRange {
    if (to.value <= Int.MIN_VALUE) return PixelsRange.EMPTY
    return this..(to - Pixels(1))
}

infix fun Pixels.untilIncluding(to: Pixels): PixelsRange {
    if (to.value <= Int.MIN_VALUE) return PixelsRange.EMPTY
    return this..(to)
}

infix fun Pixels.downTo(to: Pixels) = PixelsRange(start = this, endInclusive = to, step = Pixels(-1))

infix fun Pixels.downToExcluding(to: Pixels) =
    PixelsRange(start = this, endInclusive = to - Pixels(1), step = Pixels(-1))

infix fun PixelsRange.step(newStep: Pixels) = PixelsRange(start = start, endInclusive = endInclusive, step = newStep)

data class PixelsRange(
    override val start: Pixels,
    override val endInclusive: Pixels,
    override val step: Pixels = Pixels(1)
) : ClosedRange<Pixels>,
    Progression<Pixels>,
    Iterable<Pixels> {

    companion object {

        val EMPTY: PixelsRange = PixelsRange(Pixels(1), Pixels(0))
    }

    override val firstValue = start

    override val lastSteppedValue = Pixels(getProgressionLastIntElement(start.value, endInclusive.value, step.value))

    override fun iterator() = PixelsProgressionIterator(first = start, last = endInclusive, step = step)
}

class PixelsProgressionIterator(first: Pixels, last: Pixels, private val step: Pixels) : Iterator<Pixels> {
    private val finalElement = last
    private var hasNext: Boolean = if (step.value > 0) first <= last else first >= last
    private var next = if (hasNext) first else finalElement

    override fun hasNext(): Boolean = hasNext

    override fun next(): Pixels {
        val value = next
        if (value == finalElement) {
            if (!hasNext) throw kotlin.NoSuchElementException()
            hasNext = false
        } else {
            next += step
        }
        return value
    }
}