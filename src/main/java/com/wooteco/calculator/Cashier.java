package com.wooteco.calculator;

import com.wooteco.calculator.input.InputView;
import com.wooteco.calculator.output.OutputView;
import java.util.List;

public class Cashier {

    private final InputView inputView;
    private final OutputView outputView;

    public Cashier(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void calculate() {
        List<Integer> numbers = inputView.getSeparatedInput();
        int calculatedResult = new Calculator(numbers).getCalculateResult();
        outputView.printCalculateResult(calculatedResult);
    }
}
