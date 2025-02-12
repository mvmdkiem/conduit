package com.conduit.operations;

/**
 * 뺄셈 연산을 수행하는 클래스
 */
public class Subtraction implements Operation {
    @Override
    public double apply(double operand1, double operand2) {
        return operand1 - operand2;
    }
}