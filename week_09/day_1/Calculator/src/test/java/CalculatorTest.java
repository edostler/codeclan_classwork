import models.Calculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setup() throws Exception {
        calculator = new Calculator(3, 4);
    }

    @Test
    public void canAdd() {
        assertEquals(7, calculator.add());
    }

    @Test
    public void canSubtract() {
        assertEquals(-1, calculator.subtract());
    }

    @Test
    public void canMultiply() {
        assertEquals(12, calculator.multiply());
    }

    @Test
    public void canDivide() {
        assertEquals(0.75, calculator.divide(), 0.01);
    }

}
