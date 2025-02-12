package com.conduit.calculators;

import com.conduit.operands.Operand;
import com.conduit.operations.*;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicCalculator implements Calculator {
    private static final Logger logger = LoggerFactory.getLogger(BasicCalculator.class);
    private static final Map<String, Operation> operations = Map.of(
            "+", new Addition(),
            "-", new Subtraction(),
            "*", new Multiplication(),
            "/", new Division()
    );
    private final Operand operandParser;

    public BasicCalculator(Operand operandParser) {
        this.operandParser = operandParser;
    }

    @Override
    public double calculate(String operand1, String operator, String operand2) {
        double op1 = operandParser.parse(operand1);
        double op2 = operandParser.parse(operand2);
        Operation operation = operations.get(operator);

        if (operation == null) {
            throw new IllegalArgumentException("잘못된 연산자입니다: " + operator);
        }

        return operation.apply(op1, op2);
    }
}

