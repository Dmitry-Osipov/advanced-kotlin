package com.osipov.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    val supervisor = SupervisorJob()

    val job = launch(supervisor) {
        try {
            println("Корутина launch начала выполнение")
            throw RuntimeException("Ошибка в launch корутине")
        } catch (e: Exception) {
            println(e.message)
        }
    }

    job.join()
    println("Корутина завершена")

    println("------------------------------------------------")

    val deferred = async(supervisor) {
        println("Корутина async начала выполнение")
        throw RuntimeException("Ошибка в async корутине")
    }

    try {
        deferred.await()
    } catch (e: Exception) {
        println("Исключение перехвачено в async: ${e.message}")
    }
}