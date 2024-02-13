package com.wooteco.calculator.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.wooteco.calculator.input.model.TestReaderImpl;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @DisplayName("숫자로 이루어지지 않을 경우 예외를 throw 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "a,b,c",
            "1,3,b",
            "//;\\na^2^3"
    })
    void notContainsNumberTest(String input) {
        TestReaderImpl testReader = new TestReaderImpl(input);
        InputView inputView = new InputView(testReader);

        assertThatThrownBy(inputView::getSeparatedInput)
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("공백이거나 null일 경우 예외를 throw 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "",
            " "
    })
    void notContainsNullOrBlank(String input) {
        TestReaderImpl testReader = new TestReaderImpl(input);
        InputView inputView = new InputView(testReader);

        assertThatThrownBy(inputView::getSeparatedInput)
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("정해진 separator로 이루어진 경우, 이를 구분한다.")
    void canSeparateDefault() {
        TestReaderImpl testReader = new TestReaderImpl("1,2:3,4:5");
        InputView inputView = new InputView(testReader);

        List<Integer> expectResult = List.of(1, 2, 3, 4, 5);
        assertThat(inputView.getSeparatedInput()).isEqualTo(expectResult);
    }

    @Test
    @DisplayName("커스텀 separator로 이루어진 경우, 이를 구분한다.")
    void canSeparateCustom() {
        TestReaderImpl testReader = new TestReaderImpl("//;\\n1;2;3");
        InputView inputView = new InputView(testReader);

        List<Integer> expectResult = List.of(1, 2, 3);
        assertThat(inputView.getSeparatedInput()).isEqualTo(expectResult);
    }
}
