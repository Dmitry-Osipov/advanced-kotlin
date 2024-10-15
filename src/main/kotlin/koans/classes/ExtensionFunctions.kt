package com.osipov.koans.classes

fun main() {
    println(1.r())
    println(Pair(1, 2).r())
}

fun Int.r(): RationalNumber = RationalNumber(this, 1)  // Функция расширения позволяет добавлять к
// уже созданным классам свои методы. Важно: нельзя переопределять существующие методы и можно обращаться только к
// публичным филдам, свойствам и методам

fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)

data class RationalNumber(val numerator: Int, val denominator: Int)