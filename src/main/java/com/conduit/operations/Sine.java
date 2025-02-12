package com.conduit.operations;

/**
 * 사인 연산을 수행하는 클래스
 */
public class Sine implements Operation {
    @Override
    public double apply(double operand1, double operand2) {
        return Math.sin(Math.toRadians(operand1));
    }
}
