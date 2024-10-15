package com.osipov.koans.classes

fun main() {
    println(eval(SealedNum(2)))
    println(eval(SealedSum(SealedNum(1), SealedNum(3))))
}

fun eval(expr: SealedClassesExpr): Int =
    when (expr) {
        is SealedNum -> expr.value
        is SealedSum -> eval(expr.left) + eval(expr.right)
    }

sealed interface SealedClassesExpr  // Благодаря sealed классы только этого пакета могут реализовать интерфейс

class SealedNum(val value: Int) : SealedClassesExpr

class SealedSum(val left: SealedClassesExpr, val right: SealedClassesExpr) : SealedClassesExpr