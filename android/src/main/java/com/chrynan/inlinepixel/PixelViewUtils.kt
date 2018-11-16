@file:Suppress("unused")

package com.chrynan.inlinepixel

import android.content.res.TypedArray
import android.view.View


fun TypedArray.getDimensionPixelOffset(index: Int, defaultValue: Pixels) =
    Pixels(getDimensionPixelOffset(index, defaultValue.value))

fun TypedArray.getDimensionPixelSize(index: Int, defaultValue: Pixels) =
    Pixels(getDimensionPixelSize(index, defaultValue.value))

val View.heightPx
    get() = Pixels(height)

val View.widthPx
    get() = Pixels(width)

val View.measuredHeightPx
    get() = Pixels(measuredHeight)

val View.measuredWidthPx
    get() = Pixels(measuredWidth)

val View.leftPx
    get() = Pixels(left)

val View.rightPx
    get() = Pixels(right)

val View.topPx
    get() = Pixels(top)

val View.bottomPx
    get() = Pixels(bottom)

val View.minimumWidthPx
    get() = Pixels(minimumWidth)

val View.minimumHeightPx
    get() = Pixels(minimumHeight)

val View.paddingLeftPx
    get() = Pixels(paddingLeft)

val View.paddingRightPx
    get() = Pixels(paddingRight)

val View.paddingTopPx
    get() = Pixels(paddingTop)

val View.paddingBottomPx
    get() = Pixels(paddingBottom)

val View.scrollBarSizePx
    get() = Pixels(scrollBarSize)

val View.scrollXPx
    get() = Pixels(scrollX)

val View.scrollYPx
    get() = Pixels(scrollY)

val View.verticalFadingEdgeLengthPx
    get() = Pixels(verticalFadingEdgeLength)

val View.verticalScrollbarPositionPx
    get() = Pixels(verticalScrollbarPosition)

val View.verticalScrollbarWidthPx
    get() = Pixels(verticalScrollbarWidth)