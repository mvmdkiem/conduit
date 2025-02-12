package com.conduit.operations;

/**
 * 나눗셈 연산을 수행하는 클래스. 0으로 나누는 경우 예외를 발생시킵니다.
 */
public class Division implements Operation {
    @Override
    public double apply(double operand1, double operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return operand1 / operand2;
    }
}