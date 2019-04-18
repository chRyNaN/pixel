package com.chrynan.pixel

import android.content.Context
import android.view.View

class ContextConversionFactorProvider(context: Context) : ConversionFactorProvider {

    override val dipToPxFactor = context.resources.displayMetrics.density

    override val spToPxFactor = context.resources.displayMetrics.scaledDensity

    override val ptToPxFactor =
        context.resources.displayMetrics.densityDpi / ConversionFactorProvider.POINT_PIXELS_PER_INCH
}

class ContextScreenDimensionUnitConverter(context: Context) :
    BaseScreenDimensionUnitConverter(ContextConversionFactorProvider(context))

inline fun <R> Context.screenDimensionUnitConversion(conversionBlock: ScreenDimensionUnitConverter.() -> R): R =
    conversionBlock(BaseScreenDimensionUnitConverter(ContextConversionFactorProvider(this)))

inline fun <R> View.screenDimensionUnitConversion(conversionBlock: ScreenDimensionUnitConverter.() -> R): R =
    conversionBlock(BaseScreenDimensionUnitConverter(ContextConversionFactorProvider(context!!)))

inline fun <U : ScreenDimensionUnit, R : ScreenDimensionUnit> Context.convert(
    unit: U,
    conversionBlock: ScreenDimensionUnitConverter.(U) -> R
): R = conversionBlock(BaseScreenDimensionUnitConverter(ContextConversionFactorProvider(this)), unit)

inline fun <U : ScreenDimensionUnit, R : ScreenDimensionUnit> View.convert(
    unit: U,
    conversionBlock: ScreenDimensionUnitConverter.(U) -> R
): R = conversionBlock(BaseScreenDimensionUnitConverter(ContextConversionFactorProvider(context)), unit)