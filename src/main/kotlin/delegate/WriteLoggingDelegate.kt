package com.osipov.delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class WriteLoggingDelegate<T>(private var value: T) : ReadWriteProperty<Any?, T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        println("Getting value for '${property.name}' = $value")
        return value
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        println("Setting value for '${property.name}' to $value")
        this.value = value
    }
}