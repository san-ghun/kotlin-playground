package org.example

fun main() {
    println(calculate(40, '+', 2))
    println(calculate(40, '-', 2))
    println(calculate(40, '*', 2))
    println(calculate(40, '/', 2))
    println(calculate(0, '/', 40))
//    println(calculate(40, '/', 0))
//    println(calculate(40, '.', 2))
}

fun calculate(a: Int, op: Char, b: Int): Int {
    return when (op) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        '/' -> {
            if (b == 0) throw IllegalArgumentException("Division by zero.")
            a / b
        }
        else -> throw IllegalArgumentException("Unsupported operator: $op")
    }
}

class Sample() {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}