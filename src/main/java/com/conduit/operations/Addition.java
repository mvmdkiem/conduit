
package com.conduit.operations;

/**
 * 덧셈 연산을 수행하는 클래스
 */
public class Addition implements Operation {
    @Override
    public double apply(double operand1, double operand2) {
        return operand1 + operand2;
    }
}