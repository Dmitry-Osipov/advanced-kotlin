package com.osipov.koans.classes

fun main() {
    println(eval(Num(2)))
    println(eval(Sum(Num(1), Num(3))))
}

fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value  // Произошёл автокаст после проверки
        is Sum -> eval(expr.left) + eval(expr.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr