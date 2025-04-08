package org.example

fun main() {
    println(calculate(40, '+', 2))
    println(calculate(40, '-', 2))
    println(calculate(40, '*', 2))
    println(calculate(40, '/', 2))
    println(calculate(40, '.', 2))
    println(calculate(0, '/', 40))
    println(calculate(40, '/', 0))
}

fun calculate(a: Int, op: Char, b: Int): Int {
    val result = when (op) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        '/' -> a / b
        else -> 0
    }
    return result
}

class Sample() {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}