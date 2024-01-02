package string.makingSlices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static string.makingSlices.RangeConfigurator.*;

import org.junit.jupiter.api.Test;

public class RangeConfiguratorTest {
    @Test
    void whenEndIsNullThenEndSupply() {
        RangeConfigurator configurator = new RangeConfigurator(1, null, 2, 8);
        String expected = "[start=1, end=8, step=2, length=8]";

        assertEquals(expected, configurator.toString());
    }

    @Test
    void whenStartIsNullThenStartSupply() {
        RangeConfigurator configurator = new RangeConfigurator(null, 3, 1, 5);
        String expected = "[start=0, end=3, step=1, length=5]";

        assertEquals(expected, configurator.toString());
    }

    @Test
    void whenStepIsNullThenStepSupply() {
        RangeConfigurator configurator = new RangeConfigurator(1, 3, null, 5);
        String expected = "[start=1, end=3, step=1, length=5]";

        assertEquals(expected, configurator.toString());
    }

    @Test
    void whenModulateStartThenReturnCorrect() {
        RangeConfigurator configurator = new RangeConfigurator(-3, 4, 1, 5);
        String expected = "[start=2, end=4, step=1, length=5]";

        assertEquals(expected, configurator.toString());
    }

    @Test
    void whenModulateEndThenReturnCorrect() {
        RangeConfigurator configurator = new RangeConfigurator(0, -2, 1, 5);
        String expected = "[start=0, end=3, step=1, length=5]";

        assertEquals(expected, configurator.toString());
    }
    @Test
    void whenStartEqualsEndThenReturnTheSame() {
        RangeConfigurator configurator = new RangeConfigurator(1, 1, 1, 5);
        String expected = "[start=1, end=1, step=1, length=5]";

        assertEquals(expected, configurator.toString());
    }

    @Test
    void whenIncorrectLengthThenThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new RangeConfigurator(
                        0, -2, 1, 0));
        String expectedMessage = WRONG_LENGTH;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
