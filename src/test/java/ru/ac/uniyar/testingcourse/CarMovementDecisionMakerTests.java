package ru.ac.uniyar.testingcourse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMovementDecisionMakerTests {

    CarMovementDecisionMaker state = new CarMovementDecisionMaker();

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/rules.csv", numLinesToSkip = 1)
    void testCarMovementDecisionWithCsv(
            @ConvertWith(BooleanArgumentConverter.class) Boolean red,
            @ConvertWith(TernarArgumentConverter.class) Ternar yellow,
            @ConvertWith(TernarArgumentConverter.class) Ternar green,
            @ConvertWith(BooleanArgumentConverter.class) Boolean canMove,
            @ConvertWith(BooleanArgumentConverter.class) Boolean getReady,
            @ConvertWith(BooleanArgumentConverter.class) Boolean toBeCautious
    ) {
        state.setTrafficLightState(red, yellow, green);
        assertThat(state.isToGo()).isEqualTo(canMove);
        assertThat(state.isToBePrepared()).isEqualTo(getReady);
        assertThat(state.isToBeCautious()).isEqualTo(toBeCautious);
    }
}