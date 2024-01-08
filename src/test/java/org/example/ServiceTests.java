package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTests {

    @Test
    public void testIsEven_WhenInputIsEven_ReturnsTrue() {
        Service service = new Service();
        boolean result = service.isEven(4);
        assertTrue(result);
    }

    @Test
    public void testIsEven_WhenInputIsOdd_ReturnsFalse() {
        Service service = new Service();
        boolean result = service.isEven(5);
        assertFalse(result);
    }

    @Test
    public void testHighComplexityMethod_WhenAIsZeroAndBAndCArePositive_PrintsCorrectMessages() {
        Service service = new Service();
        service.highComplexityMethod(0, 1, 2);
        // Verify the correct messages are printed
    }

    @Test
    public void testHighComplexityMethod_WhenAIsNegativeAndBAndCAreNonPositive_PrintsCorrectMessages() {
        Service service = new Service();
        service.highComplexityMethod(-1, -2, -3);
        // Verify the correct messages are printed
    }

    // Add more tests for different scenarios of highComplexityMethod
}