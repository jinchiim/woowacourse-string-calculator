package com.wooteco.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("Integer List가 주어졌을때, sum을 하는지 확인한다.")
    void canCalculate() {
        List<Integer> sampleNumbers = List.of(1, 2, 3);

        assertThat(new Calculator(sampleNumbers).getCalculateResult()).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 주어졌을때 error를 throw 한다.")
    void validateNegative() {
        List<Integer> sampleNumbers = List.of(1, 2, -3);

        assertThatThrownBy(() -> new Calculator(sampleNumbers))
                .isInstanceOf(RuntimeException.class);
    }
}
