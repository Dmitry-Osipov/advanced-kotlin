package com.osipov.koans.introduction

import java.util.regex.Pattern

fun main() {
    val successDate = "13 JUN 1992"
    val failureDate = "13 JULY 1989"
    val pattern = Pattern.compile(getPattern())
    println(pattern.matcher(successDate).matches())
    println(pattern.matcher(failureDate).matches())
}

const val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """\d{2} $month \d{4}"""  // Строковые шаблоны уже экранируют все символы внутри + такие
// шаблоны удобно использовать для регулярок