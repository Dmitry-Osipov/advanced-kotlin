package com.osipov.koans.collections

fun main() {
    println(shop.groupCustomersByCity())
}

fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = customers.groupBy { it.city }