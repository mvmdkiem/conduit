package com.conduit;

import com.conduit.calculators.Calculator;
import com.conduit.calculators.ScientificCalculator;
import com.conduit.inputs.ConsoleInput;
import com.conduit.inputs.Input;
import com.conduit.operands.StandardOperand;
import com.conduit.outputs.ConsoleOutput;
import com.conduit.outputs.Output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CalculatorMain 클래스는 계산기 프로그램의 진입점을 제공합니다.
 */
public class CalculatorMain {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorMain.class);

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Calculator calculator = new ScientificCalculator(new StandardOperand());
        Output output = new ConsoleOutput();

        new CalculatorMainRunner(input, calculator, output).run();
    }
}
