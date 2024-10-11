package com.osipov.oop

fun main() {
    val nums = Stack<Number>()
    nums.push(0)
    val producer: List<Int> = listOf(1, 2, 3)
    nums.addAll(producer)
    println("nums: $nums")
    val consumer: MutableList<Any> = mutableListOf("1", "2", "3")
    nums.pop()
    nums.popAll(consumer)
    println(nums.isEmpty())
    println("nums: $nums")
    println("consumer: $consumer")
}

class Stack<T> : Iterable<T> {
    private var head: Node<T>? = null

    fun push(value: T) {
        head = Node(value, head)
    }

    fun pop(): T {
        val value = requireNotNull(head) { "Stack is empty" }.value
        head = head?.next
        return value
    }

    fun addAll(elements: Collection<out T>) {
        elements.forEach { push(it) }
    }

    fun popAll(collection: MutableCollection<in T>) {
        while (!isEmpty()) collection.add(pop())
    }

    fun isEmpty(): Boolean = head == null

    override fun iterator(): Iterator<T> {
        var current = head

        return object : Iterator<T> {
            override fun hasNext(): Boolean = !isEmpty()

            override fun next(): T {
                val value = current?.value ?: throw NoSuchElementException("No more elements")
                current = current?.next
                return value
            }
        }
    }

    override fun toString(): String = "Stack{head=$head}"

    private class Node<T>(val value: T, var next: Node<T>? = null) {
        override fun toString(): String = "Node{value=$value, next=$next}"
    }
}
