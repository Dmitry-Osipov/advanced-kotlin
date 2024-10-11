package com.osipov.state_machine

fun main() {
    val trafficController = TrafficController(TrafficLightState.RED)

    repeat(6) {
        trafficController.showState()
        trafficController.nextState()
    }
}