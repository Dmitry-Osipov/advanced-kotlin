package com.osipov.koans.conventions

import java.util.Calendar

fun main() {
    println(task1(MyDate(2015, 10, 1)))
    println(task2(MyDate(2020, 5, 15)))
}

fun task1(today: MyDate): MyDate {
    return today + TimeInterval.YEAR + TimeInterval.WEEK
}

fun task2(today: MyDate): MyDate {
    return today + TimeInterval.YEAR * 2 + TimeInterval.WEEK * 3 + TimeInterval.DAY * 5  // Благодаря оператору times
    // можем умножать разные значения друг с другом. Т.е. сочетание TimeInterval и Int дают нам класс
    // RepeatedTimeInterval, который затем мы складываем с MyDate благодаря перегрузке оператора +
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR,
    ;

    operator fun times(number: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, number)
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

fun MyDate.addTimeIntervals(timeInterval: TimeInterval, amount: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year + if (timeInterval == TimeInterval.YEAR) amount else 0, month, dayOfMonth)
    var timeInMillis = c.timeInMillis
    val millisecondsInADay = 24 * 60 * 60 * 1000L
    timeInMillis += amount * when(timeInterval) {
        TimeInterval.DAY -> millisecondsInADay
        TimeInterval.WEEK -> 7 * millisecondsInADay
        TimeInterval.YEAR -> 0L
    }
    val result = Calendar.getInstance()
    result.timeInMillis = timeInMillis
    return MyDate(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE))
}
