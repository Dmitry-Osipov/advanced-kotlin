package com.osipov.koans.collections

data class Shop(val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>) {
    override fun toString(): String = "$name from ${city.name}"
}

data class Order(val products: List<Product>, val isDelivered: Boolean)

data class Product(val name: String, val price: Double) {
    override fun toString(): String = "'$name' for $price"
}

data class City(val name: String) {
    override fun toString(): String = name
}

val shop = Shop(
    "Naike", listOf(
        Customer(
            "Customer #1", City("Moscow"),
            listOf(
                Order(listOf(Product("1", 1.0)), false)
            )
        ),
        Customer(
            "Customer #2", City("Ryazan"),
            listOf(
                Order(listOf(Product("2", 5.0)), false),
                Order(listOf(Product("3", 2.0)), true)
            )
        )
    )
)
