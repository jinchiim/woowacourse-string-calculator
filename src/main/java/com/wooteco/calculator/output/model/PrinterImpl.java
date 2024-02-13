package com.wooteco.calculator.output.model;

public class PrinterImpl implements Printer {

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

    @Override
    public void printLine(String message, Object... args) {
        System.out.printf(message, args);
    }
}
