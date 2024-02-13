package com.wooteco.calculator;

import com.wooteco.calculator.input.InputView;
import com.wooteco.calculator.input.model.Reader;
import com.wooteco.calculator.input.model.ReaderImpl;
import com.wooteco.calculator.output.OutputView;
import com.wooteco.calculator.output.model.Printer;
import com.wooteco.calculator.output.model.PrinterImpl;
import java.util.Scanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {
        Printer printer = new PrinterImpl();
        OutputView outputView = new OutputView(printer);

        Scanner scanner = new Scanner(System.in);
        Reader reader = new ReaderImpl(scanner);
        InputView inputView = new InputView(reader);

        new Cashier(inputView, outputView).calculate();
        ;
    }

}
