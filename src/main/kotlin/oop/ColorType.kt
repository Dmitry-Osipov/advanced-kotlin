package com.osipov.oop

enum class ColorType(val type: String) {
    RED("Красный"),
    BLUE("Синий"),
    GREEN("Зелёный");

    val rgb = "0xFFFFFF"

    fun printTypes() = listOf(BLUE, RED, GREEN).forEach { println(it.type) }
}