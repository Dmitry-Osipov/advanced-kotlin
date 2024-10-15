package com.osipov.koans.introduction

fun main() {
    sendMessageToClient(
        Client(PersonalInfo("dimaosipov00@gmail.com")),
        "Hello"
    ) { email, message -> println("to $email; message $message") }
    sendMessageToClient(
        Client(null),
        "Hello"
    ) { email, message -> println("to $email; message $message") }
}

fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
) {
    val email = client?.personalInfo?.email
    if (email != null && message != null) {
        mailer.sendMessage(email, message)
    }
}

class Client(val personalInfo: PersonalInfo?)

class PersonalInfo(val email: String?)

fun interface Mailer {
    fun sendMessage(email: String, message: String)
}