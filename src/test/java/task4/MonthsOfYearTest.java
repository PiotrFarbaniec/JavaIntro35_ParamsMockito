package task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class MonthsOfYearTest {

    @ParameterizedTest
    @CsvSource(value = {"JANUARY, 1", "FEBRUARY, 2", "MAY, 5", "JULY, 7",
            "SEPTEMBER, 9", "NOVEMBER, 11", ", 0"})
    void shouldReturnMonthNumberForGivenEnumType(Month month, int expResult) {
        int result = MonthsOfYear.getMonthNumber(month);
        Assertions.assertEquals(expResult, result);
    }
}