@file:Suppress("unused")

package com.chrynan.inlinepixel

import kotlin.reflect.KClass

class UnsupportedConversionException(classToConvert: KClass<*>, conversionType: KClass<*>, message: String? = null) :
    RuntimeException("Cannot convert class $classToConvert to class $conversionType. Message: $message")