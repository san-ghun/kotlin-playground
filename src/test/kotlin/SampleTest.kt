import org.example.*
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class CalculatorTest {

    private val testCalculator: Calculator = Calculator(
        operators = listOf(Addition(), Subtraction(), Multiplication(), Division())
    )

    @Test
    fun testAddition() {
        val expected = 42
        assertEquals(expected, testCalculator.calculate(40, '+', 2))
    }

    @Test
    fun testSubtraction() {
        val expected = 38
        assertEquals(expected, testCalculator.calculate(40, '-', 2))
    }

    @Test
    fun testMultiplication() {
        val expected = 80
        assertEquals(expected, testCalculator.calculate(40, '*', 2))
    }

    @Test
    fun testDivision_01() {
        val expected = 20
        assertEquals(expected, testCalculator.calculate(40, '/', 2))
    }

    @Test
    fun testDivision_02() {
        val expected = 0
        assertEquals(expected, testCalculator.calculate(0, '/', 2))
    }

    @Test
    fun testDivisionByZero() {
        val expected = ArithmeticException("/ by zero")
        assertEquals(expected, testCalculator.calculate(40, '/', 0))
    }

    @Test
    fun testUnsupportedOp() {
        val op = '.'
        val expected = IllegalArgumentException("Unsupported operator: $op")
        assertEquals(expected, testCalculator.calculate(40, op, 0))
    }

}