package com.conduit.operations;

/**
 * 코사인 연산을 수행하는 클래스
 */
public class Cosine implements Operation {
    @Override
    public double apply(double operand1, double operand2) {
        return Math.cos(Math.toRadians(operand1));
    }
}
