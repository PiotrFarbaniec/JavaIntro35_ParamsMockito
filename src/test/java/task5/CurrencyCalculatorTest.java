package task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

class CurrencyCalculatorTest {

    private Exchangeable exchangeable = mock(CurrencyCalculator.class);

    @ParameterizedTest
    @EnumSource(Currencies.class)
    void shouldReturnValueArrayForCurrency(Currencies currency) {
        //given
        double[] expectedValues = {4.30, 4.35};
        Mockito.when(exchangeable.getCurrencyValuesFromDatabase(currency)).thenReturn(expectedValues);

        //when
        double[] actualValues = exchangeable.getCurrencyValuesFromDatabase(currency);

        //then
        Assertions.assertArrayEquals(expectedValues, actualValues);
    }


    @ParameterizedTest
    @CsvSource(value = {"1000, 229.8850574712644", "1001, 230.37974683544306",
            "2500, 575.3739930955121", "2501, 576.599423631124",
            "5000, 1152.7377521613835", "5001, 1156.3005780346823"})
    void shouldReturnQuantityPurchasedCurrencyAndPurchasePrice(int amount, double expectedResult ) {
        //given
        double[] expectedValues = {4.30, 4.35};
        Mockito.when(exchangeable.getCurrencyValuesFromDatabase(Currencies.EUR)).thenReturn(expectedValues);
        CurrencyCalculator cc = new CurrencyCalculator();

        //when
        double actualResult = cc.buyCurrency(Currencies.EUR, amount);

        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }
}