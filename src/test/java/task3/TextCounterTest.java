package task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


class TextCounterTest {

    private static Stream<Arguments> providesStringsForLengthCalculation() {
        return Stream.of(
                Arguments.of("Some text", 9),
                Arguments.of("Test", 4),
                Arguments.of("Text for test", 13),
                Arguments.of("", 0),
                Arguments.of(" ",0),
                Arguments.of(null, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("providesStringsForLengthCalculation")
    void shouldReturnTextLength(String inputText, int expResult) {
        int result = TextCounter.getTextLength(inputText);
        Assertions.assertEquals(expResult, result);
    }
}