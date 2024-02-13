package com.wooteco.calculator.input.model;

public class TestReaderImpl implements Reader {

    private final String input;

    public TestReaderImpl(String input) {
        this.input = input;
    }

    @Override
    public String readLine() {
        return input;
    }
}
