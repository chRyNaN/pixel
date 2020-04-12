package com.chrynan.pixel

interface ScreenDimensionUnitConverter {

    fun ScreenDimensionUnit.toPx(): Pixels

    fun ScreenDimensionUnit.toDip(): DensityIndependentPixels

    fun ScreenDimensionUnit.toSp(): ScaledPixels

    fun ScreenDimensionUnit.toPt(): PointPixels
}