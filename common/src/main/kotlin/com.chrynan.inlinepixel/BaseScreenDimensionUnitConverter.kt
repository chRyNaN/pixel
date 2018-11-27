@file:Suppress("unused")

package com.chrynan.inlinepixel

open class BaseScreenDimensionUnitConverter(private val converterFactorProvider: ConversionFactorProvider) :
    ScreenDimensionUnitConverter {

    override fun ScreenDimensionUnit.toPx() =
        when (this) {
            is Pixels -> this
            is DependencyIndependentPixels -> convertDipToPx(this)
            is ScaledPixels -> convertSpToPx(this)
            is PointPixels -> convertPtToPx(this)
            else -> throw UnsupportedConversionException(
                classToConvert = this::class,
                conversionType = Pixels::class,
                message = "Cannot convert unknown type to ${Pixels::class}."
            )
        }

    override fun ScreenDimensionUnit.toDip() =
        when (this) {
            is DependencyIndependentPixels -> this
            is Pixels -> convertPxToDip(this)
            is ScaledPixels -> convertSpToDip(this)
            is PointPixels -> convertPtToDip(this)
            else -> throw UnsupportedConversionException(
                classToConvert = this::class,
                conversionType = DependencyIndependentPixels::class,
                message = "Cannot convert unknown type to ${DependencyIndependentPixels::class}."
            )
        }

    override fun ScreenDimensionUnit.toSp() =
        when (this) {
            is ScaledPixels -> this
            is DependencyIndependentPixels -> convertDipToSp(this)
            is Pixels -> convertPxToSp(this)
            is PointPixels -> convertPtToSp(this)
            else -> throw UnsupportedConversionException(
                classToConvert = this::class,
                conversionType = ScaledPixels::class,
                message = "Cannot convert unknown type to ${ScaledPixels::class}."
            )
        }

    override fun ScreenDimensionUnit.toPt() =
        when (this) {
            is PointPixels -> this
            is DependencyIndependentPixels -> convertDipToPt(this)
            is ScaledPixels -> convertSpToPt(this)
            is Pixels -> convertPxToPt(this)
            else -> throw UnsupportedConversionException(
                classToConvert = this::class,
                conversionType = PointPixels::class,
                message = "Cannot convert unknown type to ${PointPixels::class}."
            )
        }

    private fun convertDipToPx(dip: DependencyIndependentPixels) =
        Pixels((dip.value * converterFactorProvider.dipToPxFactor).toInt())

    private fun convertPxToDip(px: Pixels) =
        DependencyIndependentPixels((px.value / converterFactorProvider.dipToPxFactor).toInt())

    private fun convertSpToPx(sp: ScaledPixels) = Pixels((sp.value * converterFactorProvider.spToPxFactor).toInt())

    private fun convertPxToSp(px: Pixels) = ScaledPixels((px.value / converterFactorProvider.spToPxFactor).toInt())

    private fun convertPtToPx(pt: PointPixels) =
        Pixels((pt.value * converterFactorProvider.ptToPxFactor).toInt())

    private fun convertPxToPt(px: Pixels) =
        PointPixels((px.value / converterFactorProvider.ptToPxFactor).toInt())

    private fun convertSpToDip(sp: ScaledPixels) = convertPxToDip(convertSpToPx(sp))

    private fun convertPtToDip(pt: PointPixels) = convertPxToDip(convertPtToPx(pt))

    private fun convertDipToSp(dip: DependencyIndependentPixels) = convertPxToSp(convertDipToPx(dip))

    private fun convertPtToSp(pt: PointPixels) = convertPxToSp(convertPtToPx(pt))

    private fun convertDipToPt(dip: DependencyIndependentPixels) = convertPxToPt(convertDipToPx(dip))

    private fun convertSpToPt(sp: ScaledPixels) = convertPxToPt(convertSpToPx(sp))
}