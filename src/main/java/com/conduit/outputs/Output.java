package com.conduit.outputs;

/**
 * Output 인터페이스는 계산 결과를 출력하는 기능을 정의합니다.
 */
public interface Output {
    /**
     * 계산 결과를 출력합니다.
     *
     * @param result 출력할 결과 값
     */
    void printResult(double result);
}