package com.osipov.delegate

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ReadLoggingDelegate<T>(private var value: T) : ReadOnlyProperty<Any?, T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        println("Getting value for '${property.name}' = $value")
        return value
    }
}