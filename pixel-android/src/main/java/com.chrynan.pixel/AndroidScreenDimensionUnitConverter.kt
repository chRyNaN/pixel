package com.chrynan.pixel

import android.content.Context

/**
 * A default Android implementation of the [ScreenDimensionUnitConverter] interface that uses the provided [Context]
 * for the conversions between [ScreenDimensionUnit]s. This class inherits from the [BaseScreenDimensionUnitConverter].
 *
 * @author chRyNaN
 */
class AndroidScreenDimensionUnitConverter(context: Context) : BaseScreenDimensionUnitConverter(
    converterFactorProvider = AndroidContextConversionFactorProvider(context = context)
)