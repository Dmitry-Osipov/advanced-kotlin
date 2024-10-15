package com.osipov.koans.collections

fun main() {
    println(shop.nameToCustomerMap())
    println(shop.customerToCityMap())
    println(shop.customerNameToCityMap())
}

// Любая associate - это аналог toMap, но:
// - associateBy принимает лямбду, которая встаёт первым аргументов в toMap
// - associateWith принимает лямбду, которая встаёт вторым аргументом в toMap
// - associate принимает лямбду, где левая часть встаёт первым аргументом, а правая часть встаёт вторым аргументом

fun Shop.nameToCustomerMap(): Map<String, Customer> = customers.associateBy(Customer::name)  // Замена на java:
// this.getCustomers().stream().collect(Collectors.toMap(Customer::getName, customer -> customer))

fun Shop.customerToCityMap(): Map<Customer, City> = customers.associateWith(Customer::city)  // Замена на java:
// this.getCustomers().stream().collect(Collectors.toMap(customer -> customer, Customer::getCity))

fun Shop.customerNameToCityMap(): Map<String, City> = customers.associate { it.name to it.city }  // Замена на java:
// this.getCustomers().stream().collect(Collectors.toMap(Customer::getName, Customer::getCity))
