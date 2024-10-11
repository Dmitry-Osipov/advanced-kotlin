package com.osipov

import com.osipov.delegate.Person
import com.osipov.funbctions.checkNull
import com.osipov.funbctions.multiplyBy2
import com.osipov.oop.AgeInline
import com.osipov.oop.ColorType
import com.osipov.oop.DataClassExample
import com.osipov.oop.Outer
import test.Main
import java.util.*

internal interface Flyable {
    fun fly()
    fun sing()
}

fun main() {
    val bird = object : Flyable {
        var name: String = ""
            get() = field.uppercase()
            set(value) {
                println("Call setter")
                field = value
            }

        var age: Int = 0

        override fun fly() {
            println("I am flying")
        }

        override fun sing() {
            println("I am singing")
        }
    }
    bird.fly()
    bird.sing()
    println()

    println(if (bird.name == "") "NO NAME" else bird.name)
    bird.name = "Temp"
    println(bird.name)
    bird.age = 20
    println(bird.age)
    println()

    val myProperty: Int by lazy { bird.age }
    println(myProperty)
    println()

    val person = Person("John", 30)
    println(person.name)
    person.name = "Jane"
    println(person.age)
    println(person.hello)
    println(person.hello)
    println()

    val dataClass = DataClassExample("Dmitry", 24)
    println(dataClass)
    val copyDataClass: DataClassExample = dataClass.deepCopy()
    println(copyDataClass)
    println(dataClass.name === copyDataClass.name)  // Если бы оставили стандартную реализацию, было бы true
    val (name, age) = dataClass
    println("name = $name, age = $age")
    println()

    val color = ColorType.RED
    println("Color = $color, type = ${color.type}")
    color.printTypes()
    println(color.rgb)
    println()

    Outer().Inner().innerMethod()
    Outer.Nested().nestedMethod()
    println()

    val person1 = com.osipov.oop.Person("John", AgeInline(40))
    println("Name: ${person1.name}, Age: ${person1.age}")
    println()

    repeat(10) {
        val randInt = Main.getRandomNumberOrNull(1, 100)
        if (checkNull(randInt)) println("randInt is null") else println(multiplyBy2(randInt))
    }
    println()

    mapOf("1" to 1, "2" to 2, "3" to 3)
        .forEach { (_, v) -> println(multiplyBy2(v))}
    val numbers = listOf(1, 2, 3, 4, 5)
    val evenNumbers = numbers.filter(fun(n) = n % 2 == 0)
    println(evenNumbers)
    println()

    val random = Random()
    repeat(10) {
        val result = runCatching {
            if (random.nextBoolean()) {
                return@runCatching "Success"
            }

            throw RuntimeException("Failure")
        }

        println(result.getOrElse { it.message })
    }
    println()
}