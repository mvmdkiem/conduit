package com.conduit.calculators;

import com.conduit.operands.Operand;
import com.conduit.operations.*;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ScientificCalculator 클래스는 사칙연산과 삼각함수를 포함한
 * 다양한 수학 연산을 수행하는 과학 계산기입니다.
 */
public class ScientificCalculator implements Calculator {
    private static final Logger logger = LoggerFactory.getLogger(ScientificCalculator.class);

    private static final Map<String, Operation> operations = Map.of(
            "+", new Addition(),
            "-", new Subtraction(),
            "*", new Multiplication(),
            "/", new Division(),
            "sin", new Sine(),
            "cos", new Cosine(),
            "tan", new Tangent()
    );

    private final Operand operandParser;

    /**
     * ScientificCalculator 생성자.
     *
     * @param operandParser 피연산자 파싱을 담당하는 객체
     */
    public ScientificCalculator(Operand operandParser) {
        this.operandParser = operandParser;
    }

    /**
     * 주어진 연산을 수행합니다.
     * 삼각함수(sin, cos, tan)는 두 번째 피연산자를 무시합니다.
     *
     * @param operand1 첫 번째 피연산자
     * @param operator 연산자 (+, -, *, /, sin, cos, tan)
     * @param operand2 두 번째 피연산자 (사칙연산에만 필요)
     * @return 연산 결과
     * @throws IllegalArgumentException 지원되지 않는 연산자가 입력된 경우 예외 발생
     */
    @Override
    public double calculate(String operand1, String operator, String operand2) {
        double op1 = operandParser.parse(operand1);
        double op2 = (operator.equals("sin") || operator.equals("cos") || operator.equals("tan")) ? 0 : operandParser.parse(operand2);
        Operation operation = operations.get(operator);

        if (operation == null) {
            throw new IllegalArgumentException("잘못된 연산자입니다: " + operator);
        }

        double result = operation.apply(op1, op2);
        logger.info("계산 수행: {} {} {} = {}", operand1, operator, operand2, result);
        return result;
    }
}
