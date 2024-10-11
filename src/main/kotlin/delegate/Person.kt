package com.osipov.delegate

class Person(name: String, age: Int) {
    var name: String by WriteLoggingDelegate(name)
    val age: Int by ReadLoggingDelegate(age)
    val hello: String by lazy { println("Hello everyone"); "Hello" }
}