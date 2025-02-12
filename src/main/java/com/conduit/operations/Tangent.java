package com.conduit.operations;

/**
 * 탄젠트 연산을 수행하는 클래스
 */
public class Tangent implements Operation {
    @Override
    public double apply(double operand1, double operand2) {
        return Math.tan(Math.toRadians(operand1));
    }
}
