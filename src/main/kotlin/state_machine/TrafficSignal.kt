package com.osipov.state_machine

interface TrafficSignal {
    fun nextState(): TrafficLightState
    fun getState(): String
}