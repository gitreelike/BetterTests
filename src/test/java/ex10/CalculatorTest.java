package ex10;

import bt.Calculator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    Calculator serviceUnderTest = new Calculator();

    @Test
    public void canAddNumbers() {
        assertThat(serviceUnderTest.add(10, 20)).isEqualTo(30);
    }
}
