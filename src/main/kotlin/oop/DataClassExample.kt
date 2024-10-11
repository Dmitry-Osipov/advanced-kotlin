package com.osipov.oop

data class DataClassExample(var name: String, var age: Int) : Cloneable {
    override fun toString(): String {
        return "DataClassExample{name='$name', age=$age}"
    }

    @Deprecated(
        message = "Superficial copying",
        replaceWith = ReplaceWith("deepCopy()"),
        level = DeprecationLevel.ERROR
    )
    fun copy(): Nothing {
        throw IllegalAccessException("This method cannot be called")
    }

    fun deepCopy(): DataClassExample {
        return DataClassExample(String(name.toCharArray()), age)
    }
}