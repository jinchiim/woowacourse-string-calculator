package com.wooteco.calculator.input.model;

import java.util.Scanner;

public class ReaderImpl implements Reader {

    private final Scanner scanner;

    public ReaderImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }


}
