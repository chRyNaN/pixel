@file:Suppress("unused")

package com.chrynan.inlinepixel

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import android.view.WindowManager

fun Context.convertDipToPx(dip: DependencyIndependentPixels) = resources.convertDipToPx(dip)

fun Resources.convertDipToPx(dip: DependencyIndependentPixels) = Pixels((dip.value * displayMetrics.density).toInt())

fun Context.convertPxToDip(px: Pixels) = resources.convertPxToDip(px)

fun Resources.convertPxToDip(px: Pixels) = DependencyIndependentPixels((px.value / displayMetrics.density).toInt())

fun Context.convertSpToPx(sp: ScaledPixels) = resources.convertSpToPx(sp)

fun Resources.convertSpToPx(sp: ScaledPixels) = Pixels((sp.value * displayMetrics.scaledDensity).toInt())

fun Context.convertPxToSp(px: Pixels) = resources.convertPxToSp(px)

fun Resources.convertPxToSp(px: Pixels) = ScaledPixels((px.value / displayMetrics.scaledDensity).toInt())

fun Context.convertDipToSp(dip: DependencyIndependentPixels) = resources.convertDipToSp(dip)

fun Resources.convertDipToSp(dip: DependencyIndependentPixels) = convertPxToSp(convertDipToPx(dip))

fun Context.convertSpToDip(sp: ScaledPixels) = resources.convertSpToDip(sp)

fun Resources.convertSpToDip(sp: ScaledPixels) = convertPxToDip(convertSpToPx(sp))

fun Context.convertPxToPt(px: Pixels) {
    //val screenSize = getScreenWindowSize()
    //val isPortraitOrientation = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    //val displayMetrics = screenWindowDisplayMetrics()

    // TODO figure out the point pixel conversions
    // 1 / 72

    TODO("PointPixels Conversions Are Not Implemented Yet.")
}

internal fun Context.screenWindowManager() =
    applicationContext.getSystemService(WindowManager::class.java) as WindowManager

internal fun Context.screenWindowDisplayMetrics(): DisplayMetrics {
    val displayMetrics = DisplayMetrics()
    screenWindowManager().defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics
}

internal fun Context.getScreenWindowSize(): ScreenSize {
    val displayMetrics = screenWindowDisplayMetrics()

    val widthPixels = displayMetrics.widthPixels
    val heightPixels = displayMetrics.heightPixels

    val densityDpi = displayMetrics.densityDpi

    val wi = widthPixels / densityDpi
    val hi = heightPixels / densityDpi

    val widthInches = Math.pow(wi.toDouble(), 2.0)
    val heightInches = Math.pow(hi.toDouble(), 2.0)

    return ScreenSize(widthInches = widthInches.toInt(), heightInches = heightInches.toInt())
}

internal data class ScreenSize(
    val widthInches: Int,
    val heightInches: Int
)

interface ScreenDimensionUnitConverter {

    fun Pixels.toDip(): DependencyIndependentPixels

    fun Pixels.toSp(): ScaledPixels

    fun Pixels.toPt(): PointPixels

    fun DependencyIndependentPixels.toPx(): Pixels

    fun DependencyIndependentPixels.toSp(): ScaledPixels

    fun DependencyIndependentPixels.toPt(): PointPixels

    fun ScaledPixels.toPx(): Pixels

    fun ScaledPixels.toDip(): DependencyIndependentPixels

    fun ScaledPixels.toPt(): PointPixels

    fun PointPixels.toPx(): Pixels

    fun PointPixels.toDip(): DependencyIndependentPixels

    fun PointPixels.toSp(): ScaledPixels
}

class ContextScreenDimensionUnitConverter(private val context: Context) : ScreenDimensionUnitConverter {

    override fun Pixels.toDip() = context.convertPxToDip(this)

    override fun Pixels.toSp() = context.convertPxToSp(this)

    override fun Pixels.toPt(): PointPixels {
        TODO("PointPixels Conversions Are Not Implemented Yet.")
    }

    override fun DependencyIndependentPixels.toPx() = context.convertDipToPx(this)

    override fun DependencyIndependentPixels.toSp() = context.convertDipToSp(this)

    override fun DependencyIndependentPixels.toPt(): PointPixels {
        TODO("PointPixels Conversions Are Not Implemented Yet.")
    }

    override fun ScaledPixels.toPx() = context.convertSpToPx(this)

    override fun ScaledPixels.toDip() = context.convertSpToDip(this)

    override fun ScaledPixels.toPt(): PointPixels {
        TODO("PointPixels Conversions Are Not Implemented Yet.")
    }

    override fun PointPixels.toPx(): Pixels {
        TODO("PointPixels Conversions Are Not Implemented Yet.")
    }

    override fun PointPixels.toDip(): DependencyIndependentPixels {
        TODO("PointPixels Conversions Are Not Implemented Yet.")
    }

    override fun PointPixels.toSp(): ScaledPixels {
        TODO("PointPixels Conversions Are Not Implemented Yet.")
    }
}