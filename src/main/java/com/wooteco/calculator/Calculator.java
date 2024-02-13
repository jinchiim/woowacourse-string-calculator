package com.wooteco.calculator;

import java.util.List;

public class Calculator {

    private final List<Integer> numbers;

    public Calculator(List<Integer> numbers) {
        validateNotNegative(numbers);
        this.numbers = numbers;
    }

    public int getCalculateResult() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void validateNotNegative(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < 0)) {
            throw new RuntimeException("음수가 들어가있습니다.");
        }
    }
}
