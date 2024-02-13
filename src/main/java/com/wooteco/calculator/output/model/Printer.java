package com.wooteco.calculator.output.model;

public interface Printer {

    void printLine(String message);

    void printLine(String message, Object... args);
}
