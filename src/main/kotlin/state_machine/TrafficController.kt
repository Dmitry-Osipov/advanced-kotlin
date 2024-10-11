package com.osipov.state_machine

class TrafficController(private var state: TrafficLightState = TrafficLightState.YELLOW) {
    // Map для хранения сигналов. В Spring мы бы всем классам проставили @Component, а эта Map инжектилась бы сама
    private val signals: Map<TrafficLightState, TrafficSignal> = mapOf(
        TrafficLightState.RED to RedSignal,
        TrafficLightState.YELLOW to YellowSignal,
        TrafficLightState.GREEN to GreenSignal,
    )

    fun nextState() {
        state = signals[state]?.nextState() ?: throw IllegalStateException("Unknown traffic signal: ${state.color}")
    }

    fun showState() {
        println(signals[state]?.getState())
    }
}