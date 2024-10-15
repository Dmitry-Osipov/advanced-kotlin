package com.osipov.koans.conventions

fun main() {
    val invokable = Invokable()
    repeat(2) {
        invokable()  // можно заменить на invokable.invoke()
    }
    println(invokable.numberOfInvocations)
}

class Invokable {
    var numberOfInvocations: Int = 0
        private set

    operator fun invoke(): Invokable {  // Благодаря этому оператору мы можем вызывать методы на самом объекте или через
        // специальный метод
        numberOfInvocations++
        return this
    }
}
