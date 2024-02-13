package com.wooteco.calculator.input;

import com.wooteco.calculator.input.model.Reader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private final Reader reader;

    private final static Pattern CUSTOM_SPLIT_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private final static String DEFAULT_SEPARATOR = ",|:";

    public InputView(final Reader reader) {
        this.reader = reader;
    }

    public List<Integer> getSeparatedInput() {
        System.out.print("계산기에 입력할 값을 적어주세요 : ");
        String input = reader.readLine();
        validateNotBlank(input);

        return extractNumbers(input);
    }

    private List<Integer> extractNumbers(String input) {
        if (input.startsWith("//")) {
            Matcher matcher = CUSTOM_SPLIT_PATTERN.matcher(input);
            if (matcher.find()) {
                return separateInput(matcher.group(1), matcher.group(2));
            }
            throw new RuntimeException("Pattern이 match되지 않습니다.");
        }
        return separateInput(DEFAULT_SEPARATOR, input);
    }

    private List<Integer> separateInput(String separator, final String input) {
        List<String> separatedInput = List.of(input.split(separator));

        return separatedInput.stream()
                .map(this::toInteger)
                .toList();
    }

    private int toInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자로 변환하지 못했습니다.");
        }
    }

    private void validateNotBlank(final String input) {
        if (input.isBlank()) {
            throw new RuntimeException("계산기에 넣을 값을 입력해주세요.");
        }
    }
}
