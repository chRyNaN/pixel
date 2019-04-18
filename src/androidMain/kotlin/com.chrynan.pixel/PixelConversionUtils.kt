@file:Suppress("unused")

package com.chrynan.pixel

import android.content.Context
import android.content.res.Resources

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

fun Context.convertPxToPt(px: Pixels) = resources.convertPxToPt(px)

fun Resources.convertPxToPt(px: Pixels) = PointPixels((px.value / (displayMetrics.densityDpi / 72f)).toInt())

fun Context.convertPtToPx(pt: PointPixels) = resources.convertPtToPx(pt)

fun Resources.convertPtToPx(pt: PointPixels) = Pixels((pt.value * (displayMetrics.densityDpi / 72f)).toInt())

fun Context.convertDipToPt(dip: DependencyIndependentPixels) = resources.convertDipToPt(dip)

fun Resources.convertDipToPt(dip: DependencyIndependentPixels) = convertPxToPt(convertDipToPx(dip))

fun Context.convertPtToDip(pt: PointPixels) = resources.convertPtToDip(pt)

fun Resources.convertPtToDip(pt: PointPixels) = convertPxToDip(convertPtToPx(pt))

fun Context.convertSpToPt(sp: ScaledPixels) = resources.convertSpToPt(sp)

fun Resources.convertSpToPt(sp: ScaledPixels) = convertPxToPt(convertSpToPx(sp))

fun Context.convertPtToSp(pt: PointPixels) = resources.convertPtToSp(pt)

fun Resources.convertPtToSp(pt: PointPixels) = convertPxToSp(convertPtToPx(pt))

fun Context.convertToPx(unit: ScreenDimensionUnit) = resources.convertToPx(unit)

fun Resources.convertToPx(unit: ScreenDimensionUnit) =
    when (unit) {
        is Pixels -> unit
        is DependencyIndependentPixels -> convertDipToPx(unit)
        is ScaledPixels -> convertSpToPx(unit)
        is PointPixels -> convertPtToPx(unit)
    }

fun Context.convertToDip(unit: ScreenDimensionUnit) = resources.convertToDip(unit)

fun Resources.convertToDip(unit: ScreenDimensionUnit) =
    when (unit) {
        is DependencyIndependentPixels -> unit
        is Pixels -> convertPxToDip(unit)
        is ScaledPixels -> convertSpToDip(unit)
        is PointPixels -> convertPtToDip(unit)
    }

fun Context.convertToSp(unit: ScreenDimensionUnit) = resources.convertToSp(unit)

fun Resources.convertToSp(unit: ScreenDimensionUnit) =
    when (unit) {
        is ScaledPixels -> unit
        is DependencyIndependentPixels -> convertDipToSp(unit)
        is Pixels -> convertPxToSp(unit)
        is PointPixels -> convertPtToSp(unit)
    }

fun Context.convertToPt(unit: ScreenDimensionUnit) = resources.convertToPt(unit)

fun Resources.convertToPt(unit: ScreenDimensionUnit) =
    when (unit) {
        is PointPixels -> unit
        is DependencyIndependentPixels -> convertDipToPt(unit)
        is ScaledPixels -> convertSpToPt(unit)
        is Pixels -> convertPxToPt(unit)
    }