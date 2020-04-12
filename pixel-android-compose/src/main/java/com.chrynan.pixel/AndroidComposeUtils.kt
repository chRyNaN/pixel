package com.chrynan.pixel

import androidx.ui.core.*
import androidx.ui.core.dp
import androidx.ui.core.px

/**
 * Converts this [ScreenDimensionUnit] into an Android Jetpack Compose [Px] value.
 *
 * @author chRyNaN
 */
val ScreenDimensionUnit.inComposePx: Px
    get() = inPx.value.px

/**
 * Converts this [ScreenDimensionUnit] into an Android Jetpack Compose [Dp] value.
 *
 * @author chRyNaN
 */
val ScreenDimensionUnit.inComposeDp: Dp
    get() = inDp.value.dp

/**
 * Converts this [Px] into a [Pixels] value.
 *
 * @author chRyNaN
 */
val Px.inPx: Pixels
    get() = value.pixels

/**
 * Converts this [Dp] into a [DensityIndependentPixels] value.
 *
 * @author chRyNaN
 */
val Dp.inDp: DensityIndependentPixels
    get() = value.densityIndependentPixels