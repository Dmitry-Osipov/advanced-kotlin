package com.osipov.koans.introduction

import java.lang.IllegalArgumentException

fun main() {
    checkAge(10)
}

fun checkAge(age: Int?) {
    if (age == null || age !in 0..150) failWithWrongAge(age)
    println("Congrats! Next year you'll be ${age + 1}.")
}

private fun failWithWrongAge(age: Int?): Nothing {  // Nothing используется, когда функция гарантированно не завершится:
    // мы ожидаем либо выброс ошибки, либо бесконечный цикл
    throw IllegalArgumentException("Wrong age: $age")
}