@file:Suppress("unused")

package com.chrynan.inlinepixel

fun pointPixel() = PointPixels(1)

fun pointPixels(value: Number) = value.asPointPixels()

fun pt(value: Number = 1) = value.asPointPixels()

fun Number.asPointPixels() = PointPixels(this.toInt())

fun Number.asPt() = PointPixels(this.toInt())

operator fun PointPixels.plus(other: PointPixels) = PointPixels(value + other.value)

operator fun PointPixels.minus(other: PointPixels) = PointPixels(value - other.value)

operator fun PointPixels.times(other: PointPixels) = PointPixels(value * other.value)

operator fun PointPixels.div(other: PointPixels) = PointPixels(value / other.value)

operator fun PointPixels.rem(other: PointPixels) = PointPixels(value % other.value)

operator fun PointPixels.unaryPlus() = PointPixels(+value)

operator fun PointPixels.unaryMinus() = PointPixels(-value)

operator fun PointPixels.rangeTo(other: PointPixels) = PointPixelsRange(this, other)

infix fun PointPixels.until(to: PointPixels): PointPixelsRange {
    if (to.value <= Int.MIN_VALUE) return PointPixelsRange.EMPTY
    return this..(to - PointPixels(1))
}

infix fun PointPixels.untilIncluding(to: PointPixels): PointPixelsRange {
    if (to.value <= Int.MIN_VALUE) return PointPixelsRange.EMPTY
    return this..(to)
}

infix fun PointPixels.downTo(to: PointPixels) =
    PointPixelsRange(start = this, endInclusive = to, step = PointPixels(-1))

infix fun PointPixels.downToExcluding(to: PointPixels) =
    PointPixelsRange(start = this, endInclusive = to - PointPixels(1), step = PointPixels(-1))

infix fun PointPixelsRange.step(newStep: PointPixels) =
    PointPixelsRange(start = start, endInclusive = endInclusive, step = newStep)

data class PointPixelsRange(
    override val start: PointPixels,
    override val endInclusive: PointPixels,
    override val step: PointPixels = PointPixels(1)
) : ClosedRange<PointPixels>,
    Progression<PointPixels>,
    Iterable<PointPixels> {

    companion object {

        val EMPTY: PointPixelsRange = PointPixelsRange(PointPixels(1), PointPixels(0))
    }

    override val firstValue = start

    override val lastSteppedValue =
        PointPixels(getProgressionLastIntElement(start.value, endInclusive.value, step.value))

    override fun iterator() = PointPixelsProgressionIterator(first = start, last = endInclusive, step = step)
}

class PointPixelsProgressionIterator(first: PointPixels, last: PointPixels, private val step: PointPixels) :
    Iterator<PointPixels> {
    private val finalElement = last
    private var hasNext: Boolean = if (step.value > 0) first <= last else first >= last
    private var next = if (hasNext) first else finalElement

    override fun hasNext(): Boolean = hasNext

    override fun next(): PointPixels {
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