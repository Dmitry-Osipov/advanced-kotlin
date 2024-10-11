package com.osipov.oop

class Outer {
    private val outerProperty = "Outer Property"

    inner class Inner {
        fun innerMethod() {
            println("Accessing outer property: $outerProperty")
        }
    }

    class Nested {
        fun nestedMethod() {
            println("Accessing nested property")
        }
    }
}