package one.chest.solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SolutionTest {
    @Test
    void calculateWaterAmount() {
        assertEquals(0, Solution.calculateWaterAmount(new int[]{1, 1, 0, 0}));
        assertEquals(0, Solution.calculateWaterAmount(new int[]{1, 0, 0, 0}));
        assertEquals(0, Solution.calculateWaterAmount(new int[]{0, 0, 0, 1}));
        assertEquals(0, Solution.calculateWaterAmount(new int[]{0, 1, 0, 0}));
        assertEquals(0, Solution.calculateWaterAmount(new int[]{1, 1, 1, 1}));
        assertEquals(0, Solution.calculateWaterAmount(new int[]{1, 2, 1, 1}));

        assertEquals(1, Solution.calculateWaterAmount(new int[]{1, 1, 0, 1}));
        assertEquals(1, Solution.calculateWaterAmount(new int[]{1, 2, 1, 2}));

        assertEquals(9, Solution.calculateWaterAmount(new int[]{5, 2, 3, 4, 5, 4, 0, 3, 1}));
        assertEquals(10, Solution.calculateWaterAmount(new int[]{0, 5, 0, 5, 0, 5, 1}));
        assertEquals(9, Solution.calculateWaterAmount(new int[]{0, 5, 0, 5, 1, 5, 1}));
        assertEquals(12, Solution.calculateWaterAmount(new int[]{0, 5, 3, 2, 3, 0, 5}));
    }

    @Test
    void should_throw_exception_on_invalid_input() {
        assertThrows(AssertionError.class, () -> Solution.calculateWaterAmount(new int[]{0, -1, 5, 0}));
    }

    @Test
    void should_return_zero_when_no_data() {
        assertEquals(0, Solution.calculateWaterAmount(new int[]{}));
    }
}