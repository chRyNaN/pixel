@file:Suppress("unused")

package com.chrynan.pixel

open class BaseScreenDimensionUnitConverter(private val converterFactorProvider: ConversionFactorProvider) :
    ScreenDimensionUnitConverter {

    override fun ScreenDimensionUnit.toPx() =
        when (type) {
            ScreenDimensionType.PIXEL -> this as Pixels
            ScreenDimensionType.DENSITY_INDEPENDENT_PIXELS -> convertDipToPx(this as DensityIndependentPixels)
            ScreenDimensionType.SCALED_PIXEL -> convertSpToPx(this as ScaledPixels)
            ScreenDimensionType.POINT_PIXEL -> convertPtToPx(this as PointPixels)
        }

    override fun ScreenDimensionUnit.toDip(): DensityIndependentPixels =
        when (type) {
            ScreenDimensionType.DENSITY_INDEPENDENT_PIXELS -> this as DensityIndependentPixels
            ScreenDimensionType.PIXEL -> convertPxToDip(this as Pixels)
            ScreenDimensionType.SCALED_PIXEL -> convertSpToDip(this as ScaledPixels)
            ScreenDimensionType.POINT_PIXEL -> convertPtToDip(this as PointPixels)
        }

    override fun ScreenDimensionUnit.toSp(): ScaledPixels =
        when (type) {
            ScreenDimensionType.SCALED_PIXEL -> this as ScaledPixels
            ScreenDimensionType.DENSITY_INDEPENDENT_PIXELS -> convertDipToSp(this as DensityIndependentPixels)
            ScreenDimensionType.PIXEL -> convertPxToSp(this as Pixels)
            ScreenDimensionType.POINT_PIXEL -> convertPtToSp(this as PointPixels)
        }

    override fun ScreenDimensionUnit.toPt(): PointPixels =
        when (type) {
            ScreenDimensionType.POINT_PIXEL -> this as PointPixels
            ScreenDimensionType.DENSITY_INDEPENDENT_PIXELS -> convertDipToPt(this as DensityIndependentPixels)
            ScreenDimensionType.SCALED_PIXEL -> convertSpToPt(this as ScaledPixels)
            ScreenDimensionType.PIXEL -> convertPxToPt(this as Pixels)
        }

    private fun convertDipToPx(dip: DensityIndependentPixels) =
        Pixels((dip.value * converterFactorProvider.dipToPxFactor))

    private fun convertPxToDip(px: Pixels) =
        DensityIndependentPixels((px.value / converterFactorProvider.dipToPxFactor))

    private fun convertSpToPx(sp: ScaledPixels) = Pixels((sp.value * converterFactorProvider.spToPxFactor))

    private fun convertPxToSp(px: Pixels) = ScaledPixels((px.value / converterFactorProvider.spToPxFactor))

    private fun convertPtToPx(pt: PointPixels) =
        Pixels((pt.value * converterFactorProvider.ptToPxFactor))

    private fun convertPxToPt(px: Pixels) =
        PointPixels((px.value / converterFactorProvider.ptToPxFactor))

    private fun convertSpToDip(sp: ScaledPixels) = convertPxToDip(convertSpToPx(sp))

    private fun convertPtToDip(pt: PointPixels) = convertPxToDip(convertPtToPx(pt))

    private fun convertDipToSp(dip: DensityIndependentPixels) = convertPxToSp(convertDipToPx(dip))

    private fun convertPtToSp(pt: PointPixels) = convertPxToSp(convertPtToPx(pt))

    private fun convertDipToPt(dip: DensityIndependentPixels) = convertPxToPt(convertDipToPx(dip))

    private fun convertSpToPt(sp: ScaledPixels) = convertPxToPt(convertSpToPx(sp))
}