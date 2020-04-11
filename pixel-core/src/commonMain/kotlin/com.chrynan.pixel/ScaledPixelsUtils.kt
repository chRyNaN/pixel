@file:Suppress("unused")

package com.chrynan.pixel

fun scaledPixel() = ScaledPixels(1)

fun scaledPixels(value: Number) = value.asScaledPixels()

fun sp(value: Number = 1) = value.asScaledPixels()

fun Number.asScaledPixels() = ScaledPixels(this.toInt())

fun Number.asSp() = ScaledPixels(this.toInt())

operator fun ScaledPixels.plus(other: ScaledPixels) = ScaledPixels(value + other.value)

operator fun ScaledPixels.minus(other: ScaledPixels) = ScaledPixels(value - other.value)

operator fun ScaledPixels.times(other: ScaledPixels) = ScaledPixels(value * other.value)

operator fun ScaledPixels.div(other: ScaledPixels) = ScaledPixels(value / other.value)

operator fun ScaledPixels.rem(other: ScaledPixels) = ScaledPixels(value % other.value)

operator fun ScaledPixels.unaryPlus() = ScaledPixels(+value)

operator fun ScaledPixels.unaryMinus() = ScaledPixels(-value)

operator fun ScaledPixels.rangeTo(other: ScaledPixels) = ScaledPixelsRange(this, other)

infix fun ScaledPixels.until(to: ScaledPixels): ScaledPixelsRange {
    if (to.value <= Int.MIN_VALUE) return ScaledPixelsRange.EMPTY
    return this..(to - ScaledPixels(1))
}

infix fun ScaledPixels.untilIncluding(to: ScaledPixels): ScaledPixelsRange {
    if (to.value <= Int.MIN_VALUE) return ScaledPixelsRange.EMPTY
    return this..(to)
}

infix fun ScaledPixels.downTo(to: ScaledPixels) =
    ScaledPixelsRange(start = this, endInclusive = to, step = ScaledPixels(-1))

infix fun ScaledPixels.downToExcluding(to: ScaledPixels) =
    ScaledPixelsRange(start = this, endInclusive = to - ScaledPixels(1), step = ScaledPixels(-1))

infix fun ScaledPixelsRange.step(newStep: ScaledPixels) =
    ScaledPixelsRange(start = start, endInclusive = endInclusive, step = newStep)

data class ScaledPixelsRange(
    override val start: ScaledPixels,
    override val endInclusive: ScaledPixels,
    override val step: ScaledPixels = ScaledPixels(1)
) : ClosedRange<ScaledPixels>,
    Progression<ScaledPixels>,
    Iterable<ScaledPixels> {

    companion object {

        val EMPTY: ScaledPixelsRange = ScaledPixelsRange(ScaledPixels(1), ScaledPixels(0))
    }

    override val firstValue = start

    override val lastSteppedValue =
        ScaledPixels(getProgressionLastIntElement(start.value, endInclusive.value, step.value))

    override fun iterator() = ScaledPixelsProgressionIterator(first = start, last = endInclusive, step = step)
}

class ScaledPixelsProgressionIterator(first: ScaledPixels, last: ScaledPixels, private val step: ScaledPixels) :
    Iterator<ScaledPixels> {
    private val finalElement = last
    private var hasNext: Boolean = if (step.value > 0) first <= last else first >= last
    private var next = if (hasNext) first else finalElement

    override fun hasNext(): Boolean = hasNext

    override fun next(): ScaledPixels {
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