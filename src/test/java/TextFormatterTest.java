import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;


class TextFormatterTest {

    @ParameterizedTest
    @CsvSource(value = {"Some Text : SOME TEXT", "other Sample : OTHER SAMPLE",
            "TEXT To Convert : TEXT TO CONVERT"}, delimiter = ':')
    void shouldReturnTextFormattedToUpperCase(String inputText, String expectedResult) {
        String actualResult = TextFormatter.formatToUpperCase(inputText);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionForNullAndEmptyValue(String text) {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> TextFormatter.formatToUpperCase(text));
    }

}