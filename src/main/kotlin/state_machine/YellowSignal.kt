package com.osipov.state_machine

object YellowSignal : TrafficSignal {
    override fun nextState(): TrafficLightState = TrafficLightState.RED

    override fun getState(): String = TrafficLightState.YELLOW.color
}