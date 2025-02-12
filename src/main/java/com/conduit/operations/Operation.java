package com.conduit.operations;

/**
 * Operation 인터페이스는 기본적인 수학 연산을 수행하는 기능을 정의합니다.
 */
public interface Operation {
    /**
     * 두 개의 피연산자에 대한 연산을 수행합니다.
     *
     * @param operand1 첫 번째 피연산자
     * @param operand2 두 번째 피연산자
     * @return 연산 결과
     */
    double apply(double operand1, double operand2);
}