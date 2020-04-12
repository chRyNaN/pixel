package com.chrynan.pixel

import android.content.Context

/**
 * A default Android implementation of the [ScreenDimensionUnitConverter] interface that uses the provided [Context]
 * for the conversions between [ScreenDimensionUnit]s. This class inherits from the [BaseScreenDimensionUnitConverter]
 * class.
 *
 * To use this class, set an instance of it as the [Pixel.converter] value before performing any conversions.
 *
 * @see [AndroidContextConversionFactorProvider] for more information.
 *
 * @author chRyNaN
 */
class AndroidScreenDimensionUnitConverter(context: Context) : BaseScreenDimensionUnitConverter(
    converterFactorProvider = AndroidContextConversionFactorProvider(context = context)
)