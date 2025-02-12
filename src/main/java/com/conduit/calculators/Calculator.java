package com.conduit.calculators;

/**
 * Calculator 인터페이스는 기본적인 계산기 기능을 정의합니다.
 */
public interface Calculator {
    /**
     * 주어진 연산자와 피연산자에 따라 계산을 수행합니다.
     *
     * @param operand1 첫 번째 피연산자 (문자열 형식)
     * @param operator 연산자 (+, -, *, /, sin, cos, tan)
     * @param operand2 두 번째 피연산자 (일부 연산자는 필요 없음)
     * @return 연산 결과 (실수형)
     */
    double calculate(String operand1, String operator, String operand2);
}