package com.osipov.koans.conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

    operator fun rangeTo(other: MyDate): DateRange = DateRange(this, other)

    operator fun plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)

    operator fun plus(timeIntervals: RepeatedTimeInterval): MyDate =
        addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)
}
