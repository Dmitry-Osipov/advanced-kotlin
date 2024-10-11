package com.osipov.coroutines

import kotlinx.coroutines.*
import java.io.File

fun main() {
    val example = DispatchersExample()

    example.default()
    println("-----------------------------------")
    example.io()
    println("---------------------------------")
    example.unconfined()
    println("---------------------------------")
    example.fixedThreadPoolContext()
}

@SuppressWarnings("kotlin:S6310")
class DispatchersExample {
    fun default() {
        runBlocking {
            launch(Dispatchers.Default) {
                val result = (1..1_000_000).sum()
                println(result)
            }
        }
    }

    fun io() {
        runBlocking {
            launch(Dispatchers.IO) {
                val filePath = "/home/user/IdeaProjects/kotlin/src/main/kotlin/coroutines/data.txt"
                val fileContent = File(filePath).readText()
                println(fileContent)
            }
        }
    }

// Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher,
// e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'
//    fun main() {
//        runBlocking {
//            launch(Dispatchers.Main) {
//                println(Thread.currentThread().name)
//            }
//        }
//    }

    fun unconfined() {
        runBlocking {
            launch(Dispatchers.Unconfined) {
                println("Запущено на потоке: ${Thread.currentThread().name}")
                delay(1000)
                println("После задержки на потоке: ${Thread.currentThread().name}")
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
    fun fixedThreadPoolContext() {
        runBlocking {
            launch(newSingleThreadContext("MyThread")) {
                println("Запущено на потоке: ${Thread.currentThread().name}")
            }
        }
    }
}