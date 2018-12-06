@file:Suppress("unused")

package com.chrynan.inlinepixel

import android.app.Activity
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

var View.paddingLeftPx
    get() = Pixels(paddingLeft)
    set(px) = setPadding(px.value, paddingTop, paddingRight, paddingBottom)

var View.paddingRightPx
    get() = Pixels(paddingRight)
    set(px) = setPadding(paddingLeft, paddingTop, px.value, paddingBottom)

var View.paddingTopPx
    get() = Pixels(paddingTop)
    set(px) = setPadding(paddingLeft, px.value, paddingRight, paddingBottom)

var View.paddingBottomPx
    get() = Pixels(paddingBottom)
    set(px) = setPadding(paddingLeft, paddingTop, paddingRight, px.value)

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

fun View.verticalPadding(px: Pixels) {
    paddingTopPx = px
    paddingBottomPx = px
}

fun View.horizontalPadding(px: Pixels) {
    paddingLeftPx = px
    paddingRightPx = px
}

fun View.padding(px: Pixels) {
    setPadding(px.value, px.value, px.value, px.value)
}

fun View.padding(left: Pixels, top: Pixels, right: Pixels, bottom: Pixels) {
    setPadding(left.value, top.value, right.value, bottom.value)
}

fun Activity.pixelExtra(key: String, defaultValue: Pixels) =
    lazy { Pixels(intent?.getIntExtra(key, defaultValue.value) ?: defaultValue.value) }

fun Activity.pixelExtraOrNull(key: String): Lazy<Pixels?> = lazy {
    intent?.let {
        if (it.hasExtra(key)) Pixels(it.getIntExtra(key, -1)) else null
    }
}