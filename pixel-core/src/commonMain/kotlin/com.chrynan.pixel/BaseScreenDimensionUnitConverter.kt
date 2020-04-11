@file:Suppress("unused")

package com.chrynan.pixel

open class BaseScreenDimensionUnitConverter(private val converterFactorProvider: ConversionFactorProvider) :
    ScreenDimensionUnitConverter {

    override fun ScreenDimensionUnit.toPx() =
        when (this) {
            is Pixels -> this
            is DependencyIndependentPixels -> convertDipToPx(this)
            is ScaledPixels -> convertSpToPx(this)
            is PointPixels -> convertPtToPx(this)
        }

    override fun ScreenDimensionUnit.toDip() =
        when (this) {
            is DependencyIndependentPixels -> this
            is Pixels -> convertPxToDip(this)
            is ScaledPixels -> convertSpToDip(this)
            is PointPixels -> convertPtToDip(this)
        }

    override fun ScreenDimensionUnit.toSp() =
        when (this) {
            is ScaledPixels -> this
            is DependencyIndependentPixels -> convertDipToSp(this)
            is Pixels -> convertPxToSp(this)
            is PointPixels -> convertPtToSp(this)
        }

    override fun ScreenDimensionUnit.toPt() =
        when (this) {
            is PointPixels -> this
            is DependencyIndependentPixels -> convertDipToPt(this)
            is ScaledPixels -> convertSpToPt(this)
            is Pixels -> convertPxToPt(this)
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