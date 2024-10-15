package com.osipov.koans.conventions

fun main() {
    test(MyDate(2015, 10, 1), MyDate(2015, 12, 31))
    test(MyDate(2015, 12, 31), MyDate(2015, 10, 1))
}

fun test(date1: MyDate, date2: MyDate) {
    println(date1 < date2)  // благодаря compareTo возможно сравнивать объекты на >, < или =
}
