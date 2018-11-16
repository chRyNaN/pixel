@file:Suppress("unused")

package com.chrynan.inlinepixel

/**
 * Represents a Device Independent Pixel similar to Android's Dip/Dp values.
 */
inline class DependencyIndependentPixels(val value: Int) : ScreenDimensionUnit,
    Comparable<DependencyIndependentPixels> {

    override fun compareTo(other: DependencyIndependentPixels): Int = value.compareTo(other.value)

    override fun toString() = "{DependencyIndependentPixels: $value}"
}

fun dependencyIndependentPixel() = DependencyIndependentPixels(1)

fun dependencyIndependentPixels(value: Number) = value.asDependencyIndependentPixels()

fun dip(value: Number = 1) = value.asDependencyIndependentPixels()

fun Number.asDependencyIndependentPixels() = DependencyIndependentPixels(this.toInt())

fun Number.asDip() = DependencyIndependentPixels(this.toInt())

operator fun DependencyIndependentPixels.plus(other: DependencyIndependentPixels) =
    DependencyIndependentPixels(value + other.value)

operator fun DependencyIndependentPixels.minus(other: DependencyIndependentPixels) =
    DependencyIndependentPixels(value - other.value)

operator fun DependencyIndependentPixels.times(other: DependencyIndependentPixels) =
    DependencyIndependentPixels(value * other.value)

operator fun DependencyIndependentPixels.div(other: DependencyIndependentPixels) =
    DependencyIndependentPixels(value / other.value)

operator fun DependencyIndependentPixels.rem(other: DependencyIndependentPixels) =
    DependencyIndependentPixels(value % other.value)

operator fun DependencyIndependentPixels.unaryPlus() = DependencyIndependentPixels(+value)

operator fun DependencyIndependentPixels.unaryMinus() = DependencyIndependentPixels(-value)

operator fun DependencyIndependentPixels.rangeTo(other: DependencyIndependentPixels) =
    DependencyIndependentPixelsRange(this, other)

infix fun DependencyIndependentPixels.until(to: DependencyIndependentPixels): DependencyIndependentPixelsRange {
    if (to.value <= Int.MIN_VALUE) return DependencyIndependentPixelsRange.EMPTY
    return this..(to - DependencyIndependentPixels(1))
}

infix fun DependencyIndependentPixels.untilIncluding(to: DependencyIndependentPixels): DependencyIndependentPixelsRange {
    if (to.value <= Int.MIN_VALUE) return DependencyIndependentPixelsRange.EMPTY
    return this..(to)
}

infix fun DependencyIndependentPixels.downTo(to: DependencyIndependentPixels) =
    DependencyIndependentPixelsRange(start = this, endInclusive = to, step = DependencyIndependentPixels(-1))

infix fun DependencyIndependentPixels.downToExcluding(to: DependencyIndependentPixels) =
    DependencyIndependentPixelsRange(
        start = this,
        endInclusive = to - DependencyIndependentPixels(1),
        step = DependencyIndependentPixels(-1)
    )

infix fun DependencyIndependentPixelsRange.step(newStep: DependencyIndependentPixels) =
    DependencyIndependentPixelsRange(start = start, endInclusive = endInclusive, step = newStep)

data class DependencyIndependentPixelsRange(
    override val start: DependencyIndependentPixels,
    override val endInclusive: DependencyIndependentPixels,
    override val step: DependencyIndependentPixels = DependencyIndependentPixels(1)
) : ClosedRange<DependencyIndependentPixels>,
    Progression<DependencyIndependentPixels>,
    Iterable<DependencyIndependentPixels> {

    companion object {

        val EMPTY = DependencyIndependentPixelsRange(DependencyIndependentPixels(1), DependencyIndependentPixels(0))
    }

    override val firstValue = start

    override val lastSteppedValue =
        DependencyIndependentPixels(getProgressionLastIntElement(start.value, endInclusive.value, step.value))

    override fun iterator() =
        DependencyIndependentPixelsProgressionIterator(first = start, last = endInclusive, step = step)
}

class DependencyIndependentPixelsProgressionIterator(
    first: DependencyIndependentPixels,
    last: DependencyIndependentPixels,
    private val step: DependencyIndependentPixels
) : Iterator<DependencyIndependentPixels> {
    private val finalElement = last
    private var hasNext: Boolean = if (step.value > 0) first <= last else first >= last
    private var next = if (hasNext) first else finalElement

    override fun hasNext(): Boolean = hasNext

    override fun next(): DependencyIndependentPixels {
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