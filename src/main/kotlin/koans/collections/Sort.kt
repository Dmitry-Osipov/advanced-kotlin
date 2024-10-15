package com.osipov.koans.collections

fun main() {
    println(shop.getCustomersSortedByOrders())
}

fun Shop.getCustomersSortedByOrders(): List<Customer> = customers.sortedByDescending { it.orders.size }