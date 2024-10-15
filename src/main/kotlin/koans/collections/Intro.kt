package com.osipov.koans.collections

fun main() {
    println(shop.getSetOfCustomers())
}

fun Shop.getSetOfCustomers(): Set<Customer> = customers.toSet()