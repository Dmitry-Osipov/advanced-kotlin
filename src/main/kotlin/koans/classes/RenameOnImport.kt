package com.osipov.koans.classes

import kotlin.random.Random as KRandom
import java.util.Random as JRandom

fun main() {
    println(useDifferentRandomClasses())
}

fun useDifferentRandomClasses(): String {
    return "Kotlin random: " +
            KRandom.nextInt(2) +
            " Java random:" +
            JRandom().nextInt(2)
}