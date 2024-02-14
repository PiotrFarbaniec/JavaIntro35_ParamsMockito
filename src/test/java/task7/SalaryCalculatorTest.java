package task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

class SalaryCalculatorTest {

    private SalaryPayable salaryPayable = mock(SalaryCalculator.class);
    private BonusPayable bonusPayable = mock(SalaryCalculator.class);



    @ParameterizedTest
    @CsvSource(value = {"2500, 500, 1000, 4000", "3000, 1000, 1000, 5000",
            "3500, 0, 1000, 4500", "4000, 500, 1500, 6000"})

    void shouldReturnTotalSalaryAmount(double inputSalary, double saturdaysBonus,
                                       double oneTimeBonus, double expectedResult) {
        // given
        Mockito.when(salaryPayable.getBasicSalaryAmount()).thenReturn(inputSalary);
        Mockito.when(bonusPayable.getBonusForSaturdays()).thenReturn(saturdaysBonus);
        SalaryCalculator bonus = new SalaryCalculator(oneTimeBonus);

        // when
        double actualResult = salaryPayable.getBasicSalaryAmount()
                + bonusPayable.getBonusForSaturdays()
                + bonus.getTotalSalary();

        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }



    @ParameterizedTest
    @CsvSource(value = {"2500, 2500", "3000, 3000", "3500, 3500", "4000, 4000"} )
    void shouldReturnBasicSalaryAmount(double inputSalary, double expectedResult) {
        // given
        Mockito.when(salaryPayable.getBasicSalaryAmount()).thenReturn(inputSalary);

        // when
        double actualResult = salaryPayable.getBasicSalaryAmount();

        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }



    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1000, 1000", "1500, 1500", "2000, 2000"} )
    void shouldReturnBonusForSaturdays(double inputBonus, double expectedResult) {
        // given
        Mockito.when(bonusPayable.getBonusForSaturdays()).thenReturn(inputBonus);

        // when
        double actualResult = bonusPayable.getBonusForSaturdays();

        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }
}