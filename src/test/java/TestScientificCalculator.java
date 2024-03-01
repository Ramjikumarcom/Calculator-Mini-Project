import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestScientificCalculator {

    @Test
    public void testSquareRoot() {
        assertEquals(2.0, ScientificCalculator.squareRoot(4.0), 0.0001);
        assertEquals(3.0, ScientificCalculator.squareRoot(9.0), 0.0001);
    }

    @Test
    public void testSquareRootNegativeInput() {
        assertEquals(Double.NaN, ScientificCalculator.squareRoot(-1), 0.0001);
    }

    @Test
    public void testFactorial() {
        assertEquals(120, ScientificCalculator.factorial(5), 0.0001);
        assertEquals(3628800, ScientificCalculator.factorial(10), 0.0001);
    }

    @Test
    public void testFactorialZero() {
        assertEquals(1, ScientificCalculator.factorial(0));
    }

    @Test
    public void testFactorialNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> ScientificCalculator.factorial(-1));
    }

    @Test
    public void testNaturalLog() {
        assertEquals(1.7917, ScientificCalculator.naturalLog(6.0), 0.0001);
    }

    @Test
    public void testNaturalLogNegativeInput() {
        assertEquals(Double.NaN, ScientificCalculator.squareRoot(-1), 0.0001);
    }

    @Test
    public void testNaturalLogOne() {
        assertEquals(0, ScientificCalculator.naturalLog(1), 0.0001);
    }

    @Test
    public void testPower() {
        assertEquals(8.0, ScientificCalculator.power(2.0, 3.0), 0.0001);
        assertEquals(1024.0, ScientificCalculator.power(2.0, 10.0), 0.0001);
    }

    @Test
    public void testPowerNegativeExponent() {
        assertEquals(0.25, ScientificCalculator.power(2, -2), 0.0001);
    }
}
