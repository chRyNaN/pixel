@file:Suppress("unused")

package com.chrynan.inlinepixel

interface ConversionFactorProvider {

    companion object {

        const val POINT_PIXELS_PER_INCH = 72f
    }

    val dipToPxFactor: Float

    val spToPxFactor: Float

    val ptToPxFactor: Float
}