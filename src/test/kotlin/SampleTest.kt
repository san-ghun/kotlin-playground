import org.example.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
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
        assertThrows<ArithmeticException> {
            testCalculator.calculate(40, '/', 0)
        }
    }

    @Test
    fun testUnsupportedOp() {
        val op = '.'
        val exception = assertThrows<IllegalArgumentException> {
            testCalculator.calculate(40, op, 2)
        }
        assertEquals("Unsupported operator: $op", exception.message)
    }

}