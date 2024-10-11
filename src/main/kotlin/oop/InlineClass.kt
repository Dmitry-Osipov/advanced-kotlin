package com.osipov.oop

@JvmInline
value class AgeInline(val age: Int) {
    init {
        require(age >= 0) { "Age cannot be negative" }
    }
}

data class Person(val name: String, val age: AgeInline)
