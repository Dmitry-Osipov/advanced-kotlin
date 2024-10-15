package com.osipov.koans.classes

fun main() {
    println(getPeople())
    println(comparePeople())
}

data class Person(val name: String, val age: Int)  // data class формирует автоматически методы hashCode, equals,
// toString, getters and setters и copy (важно, происходит поверхностное копирование). Каждый из методов можно
// переопределить

fun getPeople(): List<Person> {
    return listOf(Person("Alice", 29), Person("Bob", 31))
}

fun comparePeople(): Boolean {
    val p1 = Person("Alice", 29)
    val p2 = Person("Alice", 29)
    return p1 == p2  // Перегрузка оператора на метод equals(). Чтобы сравнивать ссылки требуется указать ===
}