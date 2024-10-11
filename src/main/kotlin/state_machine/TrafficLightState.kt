package com.osipov.state_machine

enum class TrafficLightState(val color: String) {
    RED("Red signal"),
    YELLOW("Yellow signal"),
    GREEN("Green signal"),
    ;
}