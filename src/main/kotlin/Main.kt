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

/* Subject
title: String calculator
objective: Build a string-based calculator for basic operations.
example:
- input: "2 + 3 * 4 / 2"
- output: 8
 */

/* Approach
1. MVP
- Split string with space(' ')
- Calculate by reading numbers and operators alternately
- Calculate from left to right
    - Implement operation precedence later

2. Exceptions
- Add exceptional cases like, "2 +", "abc + 3", "1 / 0" etc.
- Use `.toIntOrNull()` to validate number.
- Add message for exceptions.

3. Write Test Code
- Add new file `StringCalculatorTest.kt`
- Write test
    - "2 + 3" -> 5
    - "2 + 3 * 4" -> 20 (14 for later)
    - "1 / 0" -> `ArithmeticException`
    - "2 + " -> `IllegalArgumentException`

4. Implement Operation Precedence
- Edit logic to calculate "*" and "/" first.
- Two times iteration: first with "*" and "/", second with "+" and "-"
 */

class StringCalculator {
    fun calculate(expression: String): Int {
        val tokens = expression.split(" ")
        var result = tokens[0].toInt()

        var i = 1
        while (i < tokens.size) {
            val operator = tokens[i]
            val next = tokens[i + 1].toInt()

            result = applyOperator(result, operator, next)
            i += 2
        }
        return result
    }

    private fun applyOperator(a: Int, op: String, b: Int): Int {
        return when(op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> a / b
            else -> throw IllegalArgumentException("Unknown operator: $op")
        }
    }
}

fun main() {
//    val cal = Calculator(
//        operators = listOf(Addition(), Subtraction(), Multiplication(), Division())
//    )
//
//    println(cal.calculate(40, '+', 2))
//    println(cal.calculate(40, '*', 2))
//    println(cal.calculate(40, '-', 2))
//    println(cal.calculate(40, '/', 2))
//    println(cal.calculate(0, '/', 40))
//    println(cal.calculate(40, '/', 0))
//    println(cal.calculate(40, '.', 2))

    val calculator = StringCalculator()
    println(calculator.calculate("2 + 3 * 4 / 2"))  // expect 10 (currently not support operation precedence)
}
