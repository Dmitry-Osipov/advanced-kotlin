package com.osipov.oop

class Companion {
    companion object {
        @JvmStatic
        fun add(a: Int, b: Int): Int {
            return a + b
        }
    }
}