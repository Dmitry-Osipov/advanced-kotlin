package com.osipov.state_machine

object GreenSignal : TrafficSignal {
    override fun nextState(): TrafficLightState = TrafficLightState.YELLOW

    override fun getState(): String = TrafficLightState.GREEN.color
}