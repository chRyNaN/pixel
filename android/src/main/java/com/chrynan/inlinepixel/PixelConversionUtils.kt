@file:Suppress("unused")

package com.chrynan.inlinepixel

import android.content.Context
import android.content.res.Resources
import android.view.View

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

    fun ScreenDimensionUnit.toPx(): Pixels

    fun ScreenDimensionUnit.toDip(): DependencyIndependentPixels

    fun ScreenDimensionUnit.toSp(): ScaledPixels

    fun ScreenDimensionUnit.toPt(): PointPixels
}

class ContextScreenDimensionUnitConverter(private val context: Context) : ScreenDimensionUnitConverter {

    override fun Pixels.toDip() = context.convertPxToDip(this)

    override fun Pixels.toSp() = context.convertPxToSp(this)

    override fun Pixels.toPt() = context.convertPxToPt(this)

    override fun DependencyIndependentPixels.toPx() = context.convertDipToPx(this)

    override fun DependencyIndependentPixels.toSp() = context.convertDipToSp(this)

    override fun DependencyIndependentPixels.toPt() = context.convertDipToPt(this)

    override fun ScaledPixels.toPx() = context.convertSpToPx(this)

    override fun ScaledPixels.toDip() = context.convertSpToDip(this)

    override fun ScaledPixels.toPt() = context.convertSpToPt(this)

    override fun PointPixels.toPx() = context.convertPtToPx(this)

    override fun PointPixels.toDip() = context.convertPtToDip(this)

    override fun PointPixels.toSp() = context.convertPtToSp(this)

    override fun ScreenDimensionUnit.toPx() =
        when (this) {
            is Pixels -> this
            is DependencyIndependentPixels -> context.convertDipToPx(this)
            is ScaledPixels -> context.convertSpToPx(this)
            is PointPixels -> context.convertPtToPx(this)
            else -> throw UnsupportedConversionException(
                classToConvert = this::class,
                conversionType = Pixels::class,
                message = "Cannot convert unknown type to ${Pixels::class}."
            )
        }

    override fun ScreenDimensionUnit.toDip() =
        when (this) {
            is DependencyIndependentPixels -> this
            is Pixels -> context.convertPxToDip(this)
            is ScaledPixels -> context.convertSpToDip(this)
            is PointPixels -> context.convertPtToDip(this)
            else -> throw UnsupportedConversionException(
                classToConvert = this::class,
                conversionType = DependencyIndependentPixels::class,
                message = "Cannot convert unknown type to ${DependencyIndependentPixels::class}."
            )
        }

    override fun ScreenDimensionUnit.toSp() =
        when (this) {
            is ScaledPixels -> this
            is DependencyIndependentPixels -> context.convertDipToSp(this)
            is Pixels -> context.convertPxToSp(this)
            is PointPixels -> context.convertPtToSp(this)
            else -> throw UnsupportedConversionException(
                classToConvert = this::class,
                conversionType = ScaledPixels::class,
                message = "Cannot convert unknown type to ${ScaledPixels::class}."
            )
        }

    override fun ScreenDimensionUnit.toPt() =
        when (this) {
            is PointPixels -> this
            is DependencyIndependentPixels -> context.convertDipToPt(this)
            is ScaledPixels -> context.convertSpToPt(this)
            is Pixels -> context.convertPxToPt(this)
            else -> throw UnsupportedConversionException(
                classToConvert = this::class,
                conversionType = PointPixels::class,
                message = "Cannot convert unknown type to ${PointPixels::class}."
            )
        }
}

inline fun <R> Context.screenDimensionUnitConversion(conversionBlock: ScreenDimensionUnitConverter.() -> R): R =
    conversionBlock(ContextScreenDimensionUnitConverter(this))

inline fun <R> View.screenDimensionUnitConversion(conversionBlock: ScreenDimensionUnitConverter.() -> R): R =
    conversionBlock(ContextScreenDimensionUnitConverter(context!!))

inline fun <U : ScreenDimensionUnit, R : ScreenDimensionUnit> Context.convert(
    unit: U,
    conversionBlock: ScreenDimensionUnitConverter.(U) -> R
): R = conversionBlock(ContextScreenDimensionUnitConverter(this), unit)

inline fun <U : ScreenDimensionUnit, R : ScreenDimensionUnit> View.convert(
    unit: U,
    conversionBlock: ScreenDimensionUnitConverter.(U) -> R
): R = conversionBlock(ContextScreenDimensionUnitConverter(context), unit)