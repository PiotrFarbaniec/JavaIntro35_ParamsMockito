package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CheckNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 14, 16, 20,48, 102, 112, 1120})
    void shouldReturnTrueForEvenNumbers(int numbers) {
        boolean result = CheckNumber.isEvenNumber(numbers);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource (ints = {1, 5, 7, 9, 11, 13, 15})
    void shouldReturnFalseForOddNumbers (int numbers) {
        boolean result = CheckNumber.isEvenNumber(numbers);
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"432 = 9", "12 = 3", "136 = 10", "2579 = 23", "14834 = 20"}, delimiter = '=')
    void shouldReturnAddedSingleNumbersOfGivenValue(int input, int expResults) {
        int result = CheckNumber.addSingleNumbersOfValue(input);
        Assertions.assertEquals(expResults, result);
    }
}