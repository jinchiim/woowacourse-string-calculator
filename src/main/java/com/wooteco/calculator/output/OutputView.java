package com.wooteco.calculator.output;

import com.wooteco.calculator.output.model.Printer;

public class OutputView {

    private final Printer printer;

    public OutputView(Printer printer) {
        this.printer = printer;
    }

    public void printCalculateResult(int calculateResult) {
        printer.printLine("계산한 결과는 %s 입니다.", calculateResult);
    }
}
