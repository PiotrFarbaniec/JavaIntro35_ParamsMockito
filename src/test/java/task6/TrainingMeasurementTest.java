package task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

class TrainingMeasurementTest {

    private static Stream<Arguments> providesValuesForTrainingTimeRating() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(25, 1),
                Arguments.of(29, 1),
                Arguments.of(30, 2),
                Arguments.of(45, 2),
                Arguments.of(60, 2),
                Arguments.of(61, 3),
                Arguments.of(65, 3));
    }

    private static Stream<Arguments> providesValuesForCalorieBurnRating() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(200, 1),
                Arguments.of(300, 1),
                Arguments.of(301, 2),
                Arguments.of(350, 2),
                Arguments.of(399, 2),
                Arguments.of(400, 3),
                Arguments.of(420, 3));
    }

    private static Stream<Arguments> providesValuesForHeartRateRating() {
        return Stream.of(
                Arguments.of(176, 1),
                Arguments.of(180, 1),
                Arguments.of(160, 2),
                Arguments.of(170, 2),
                Arguments.of(175, 2),
                Arguments.of(1, 3),
                Arguments.of(100, 3),
                Arguments.of(159, 3));
    }


    @ParameterizedTest
    @MethodSource("providesValuesForTrainingTimeRating")
    void shouldReturnTrainingTimeEvaluation(int input, int expectedResult) {
        //given
        TrainingMeasurement training = new TrainingMeasurement(input, 0, 0);

        //when
        int actualResult = training.getTrainingTimeEvaluation();

        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }


    @ParameterizedTest
    @ValueSource(ints = {-10, -1})
    void shouldThrowExceptionForIllegalTrainingTimeValues(int input) {
        //when given
        TrainingMeasurement training = new TrainingMeasurement(input, 0, 0);

        //then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> training.getTrainingTimeEvaluation());
    }



    @ParameterizedTest
    @MethodSource("providesValuesForCalorieBurnRating")
    void shouldReturnCalorieBurnEvaluation(double input, int expectedResult) {
        //given
        TrainingMeasurement training = new TrainingMeasurement(0, input, 0);

        //when
        int actualResult = training.getCalorieBurnEvaluation();

        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }


    @ParameterizedTest
    @ValueSource(doubles = {-5, -0.1})
    void shouldThrowExceptionForIllegalBurnCaloriesValues(double input) {
        //when given
        TrainingMeasurement training = new TrainingMeasurement(0, input, 0);

        //then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> training.getCalorieBurnEvaluation());
    }


    @ParameterizedTest
    @MethodSource("providesValuesForHeartRateRating")
    void shouldReturnHeartRateEvaluation(int input, int expectedResult) {
        //given
        TrainingMeasurement training = new TrainingMeasurement(0, 0, input);

        //when
        int actualResult = training.getHeartRateEvaluation();

        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void shouldThrowExceptionForIllegalHeartRateValues(int input) {
        //when given
        TrainingMeasurement training = new TrainingMeasurement(0, 0, input);

        //then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> training.getHeartRateEvaluation());
    }


    @ParameterizedTest
    @CsvSource(value = {"25, 250, 176 , LOW", "25, 250, 165 , GOOD", "40, 350, 165 , VERY_GOOD",
            "50, 400, 155 , VERY_GOOD", "61, 400, 155 , EXCELLENT"})
    void shouldReturnAverageTrainingRating(int time, double calories, int bpm, Ratings expectedResult) {
        //given
        TrainingMeasurement training = new TrainingMeasurement(time, calories, bpm);

        //when
        Ratings actualResult = training.getAverageTrainingRating();

        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }
}