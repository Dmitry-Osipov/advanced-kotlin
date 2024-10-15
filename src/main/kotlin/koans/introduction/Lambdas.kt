package com.osipov.koans.introduction

fun main() {
    println(containsEven(listOf(1, 2, 3 ,4)))
}

fun containsEven(collection: Collection<Int>): Boolean = collection.any { it % 2 == 0 }  // Здесь it - это замена
// выражению x -> x из Java