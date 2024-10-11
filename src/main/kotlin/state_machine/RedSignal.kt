package com.osipov.state_machine

object RedSignal : TrafficSignal {
    override fun nextState(): TrafficLightState = TrafficLightState.GREEN

    override fun getState(): String = TrafficLightState.RED.color
}