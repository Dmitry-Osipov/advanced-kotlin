package com.osipov.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    channelExample(Channel())
    println("----------------------------------------")
    flowExample()
}

fun channelExample(channel: Channel<Int>) {
    runBlocking {
        launch {
            for (i in 1..5) {
                channel.send(i)
                delay(1000)
            }
            channel.close()
        }

        launch {
            for (item in channel) {
                println("Получено: $item")
            }
        }
    }
}

fun flowExample() {
    runBlocking {
        val flow = flow {
            for (i in 1..5) {
                emit(i)
                delay(1000)
            }
        }

        flow
            .map{ it * it }
            .filter { it % 2 == 0 }
            .collect { value ->
            println("Отфильтрованное и изменённое значение: $value")
        }
    }
}