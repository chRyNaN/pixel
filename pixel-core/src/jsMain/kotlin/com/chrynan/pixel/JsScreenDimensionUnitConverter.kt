package com.chrynan.pixel

/**
 * A default Javascript implementation of the [ScreenDimensionUnitConverter] interface. This class inherits from the
 * [BaseScreenDimensionUnitConverter] class providing the [JsConversionFactorProvider] as the
 * [ConversionFactorProvider].
 *
 * To use this class, set an instance of it as the [Pixel.converter] value before performing any conversions.
 *
 * @see [JsConversionFactorProvider] for more information.
 *
 * @author chRyNaN
 */
class JsScreenDimensionUnitConverter :
    BaseScreenDimensionUnitConverter(converterFactorProvider = JsConversionFactorProvider())