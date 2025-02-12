package com.conduit;

import com.conduit.calculators.Calculator;
import com.conduit.inputs.Input;
import com.conduit.outputs.Output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CalculatorMain의 실행을 담당하는 클래스 (테스트 가능하도록 별도 분리)
 */
public class CalculatorMainRunner {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorMainRunner.class);

    private final Input input;
    private final Calculator calculator;
    private final Output output;

    public CalculatorMainRunner(Input input, Calculator calculator, Output output) {
        this.input = input;
        this.calculator = calculator;
        this.output = output;
    }

    public void run() {
        while (true) {
            try {
                logger.info("계산식을 입력하세요 (예: 2 + 3 또는 90 sin): ");
                String[] userInput = input.getInput();

                if (userInput.length == 0) {
                    logger.info("입력값이 없습니다. 프로그램을 종료합니다.");
                    break;
                }

                if (userInput.length < 2 || userInput.length > 3) {
                    logger.error("잘못된 입력 형식입니다. 예: 2 + 3 또는 90 sin");
                    continue;
                }

                String operand1 = userInput[0];
                String operator = userInput[1];
                String operand2 = userInput.length == 3 ? userInput[2] : "0";

                double result = calculator.calculate(operand1, operator, operand2);
                output.printResult(result);

            } catch (Exception e) {
                logger.error("오류 발생: {}", e.getMessage());
            }
        }
    }
}
