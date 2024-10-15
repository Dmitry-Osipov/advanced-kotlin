package com.osipov.koans.conventions

fun main() {
    println(
        checkInRange(
            MyDate(2010, 4, 13),
            MyDate(2015, 12, 1),
            MyDate(2020, 9, 22)
        )
    )
}

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in first..last  // Благодаря compareTo можно создать объект Range и проверить границы
}