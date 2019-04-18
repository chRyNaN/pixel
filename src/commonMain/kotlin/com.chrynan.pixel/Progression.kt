package com.chrynan.pixel

interface Progression<T> {

    val firstValue: T

    val lastSteppedValue: T

    val step: T
}

fun getProgressionLastIntElement(start: Int, end: Int, step: Int): Int = when {
    step > 0 -> if (start >= end) end else end - differenceModulo(end, start, step)
    step < 0 -> if (start <= end) end else end + differenceModulo(start, end, -step)
    else -> throw kotlin.IllegalArgumentException("Step is zero.")
}

private fun differenceModulo(a: Int, b: Int, c: Int): Int {
    return mod(mod(a, c) - mod(b, c), c)
}

private fun mod(a: Int, b: Int): Int {
    val mod = a % b
    return if (mod >= 0) mod else mod + b
}