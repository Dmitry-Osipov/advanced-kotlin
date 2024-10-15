package com.osipov.koans.collections

fun main() {
    println(shop.getCustomerCities())
    println("-----------------------------------------------")
    println(shop.getCustomersFrom(City("Moscow")))
}

fun Shop.getCustomerCities(): Set<City> = customers.map { it.city }.toSet()

fun Shop.getCustomersFrom(city: City): List<Customer> = customers.filter { it.city == city }