package com.chrynan.pixel

import android.content.Context

class AndroidScreenDimensionUnitConverter(context: Context) : BaseScreenDimensionUnitConverter(
    converterFactorProvider = AndroidContextConversionFactorProvider(context = context)
)