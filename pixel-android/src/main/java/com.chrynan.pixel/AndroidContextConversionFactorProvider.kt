package com.chrynan.pixel

import android.content.Context

/**
 * A default Android implementation of a [ConversionFactorProvider] using the provided [Context] for the factors.
 *
 * @author chRyNaN
 */
class AndroidContextConversionFactorProvider(context: Context) : ConversionFactorProvider {

    override val dipToPxFactor = context.resources.displayMetrics.density

    override val spToPxFactor = context.resources.displayMetrics.scaledDensity

    override val ptToPxFactor =
        context.resources.displayMetrics.densityDpi / ConversionFactorProvider.POINT_PIXELS_PER_INCH
}
