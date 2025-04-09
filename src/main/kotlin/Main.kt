package org.example

interface Operator {
    fun supports(symbol: Char): Boolean
    fun operate(a: Int, b: Int): Int
}

class Addition: Operator {
    override fun supports(symbol: Char) = symbol == '+'
    override fun operate(a: Int, b: Int) = a + b
}

class Subtraction: Operator {
    override fun supports(symbol: Char) = symbol == '-'
    override fun operate(a: Int, b: Int) = a - b
}

class Multiplication: Operator {
    override fun supports(symbol: Char) = symbol == '*'
    override fun operate(a: Int, b: Int) = a * b
}

class Division: Operator {
    override fun supports(symbol: Char) = symbol == '/'
    override fun operate(a: Int, b: Int) = a / b
}

class Calculator(private val operators: List<Operator>) {
    fun calculate(a: Int, op: Char, b: Int): Int {
        val operator = operators.find { it.supports(op) }
            ?: throw IllegalArgumentException("Unsupported operator: $op")
        return operator.operate(a, b)
    }
}

fun main() {
    val cal = Calculator(
        operators = listOf(Addition(), Subtraction(), Multiplication(), Division())
    )

    println(cal.calculate(40, '+', 2))
    println(cal.calculate(40, '*', 2))
    println(cal.calculate(40, '-', 2))
    println(cal.calculate(40, '/', 2))
    println(cal.calculate(0, '/', 40))
//    println(cal.calculate(40, '/', 0))
//    println(cal.calculate(40, '.', 2))
}
