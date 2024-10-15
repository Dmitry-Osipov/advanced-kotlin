package com.osipov.koans.introduction

fun main() {
    println(useFoo())
    println(joinOptions(listOf("a", "b", "c")))
    println(tripleQuotedString)
}

private fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false): String =
    (if (toUpperCase) name.uppercase() else name) + number  // Можем задать аргументы по умолчанию

fun joinOptions(options: Collection<String>): String = options.joinToString(prefix = "[", postfix = "]")
// Переписываем значения в аргументах по умолчанию

fun useFoo(): List<String> = listOf(
    foo("a"),
    foo("b", number = 1),
    foo("c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)

const val question = "life, the universe, and everything"
const val answer = 42

val tripleQuotedString = """
    #question = "$question"
    #answer = $answer""".trimMargin("#")  // Избавляемся от символа префикса. Идёт именованным параметром.
// Если передавать именованные параметры в той же последовательности, то указывать явно название параметра не требуется
