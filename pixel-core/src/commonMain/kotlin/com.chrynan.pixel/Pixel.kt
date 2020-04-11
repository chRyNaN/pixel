package com.chrynan.pixel

object Pixel {

    lateinit var converter: ScreenDimensionUnitConverter
}

fun ScreenDimensionUnit.toPx() = Pixel.converter.run {
    toPx()
}

fun ScreenDimensionUnit.toDip() = Pixel.converter.run {
    toDip()
}

fun ScreenDimensionUnit.toSp() = Pixel.converter.run {
    toSp()
}

fun ScreenDimensionUnit.toPt() = Pixel.converter.run {
    toPt()
}