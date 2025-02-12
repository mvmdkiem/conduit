package com.conduit;

import com.conduit.calculators.Calculator;
import com.conduit.inputs.Input;
import com.conduit.outputs.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.mockito.Mockito.*;

/**
 * CalculatorMainRunner의 동작을 테스트하는 클래스
 */
class CalculatorMainTest {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorMainTest.class);

    private Input mockInput;
    private Calculator mockCalculator;
    private Output mockOutput;

    @BeforeEach
    void setUp() {
        mockInput = mock(Input.class);
        mockCalculator = mock(Calculator.class);
        mockOutput = mock(Output.class);
    }

    /**
     * 정상적인 덧셈 연산이 수행되는지 테스트합니다.
     */
    @Test
    void testAdditionOperation() {
        when(mockInput.getInput())
                .thenReturn(new String[]{"2", "+", "3"}) // 첫 번째 입력: 정상 연산
                .thenReturn(new String[]{}); // 두 번째 입력: 종료

        when(mockCalculator.calculate("2", "+", "3")).thenReturn(5.0);

        new CalculatorMainRunner(mockInput, mockCalculator, mockOutput).run();

        verify(mockOutput).printResult(5.0);
        verify(mockCalculator).calculate("2", "+", "3");
        logger.info("덧셈 테스트 성공: 2 + 3 = 5.0");
    }

    /**
     * 잘못된 입력 형식 처리 테스트
     */
    @Test
    void testInvalidInputFormat() {
        when(mockInput.getInput())
                .thenReturn(new String[]{"2", "+"}) // 잘못된 입력
                .thenReturn(new String[]{}); // 종료

        new CalculatorMainRunner(mockInput, mockCalculator, mockOutput).run();

        verify(mockOutput, never()).printResult(anyDouble());
        verify(mockCalculator, never()).calculate(anyString(), anyString(), anyString());
        logger.info("잘못된 입력 처리 테스트 성공");
    }

    /**
     * 삼각함수 연산 테스트 (사인)
     */
    @Test
    void testSineOperation() {
        when(mockInput.getInput())
                .thenReturn(new String[]{"90", "sin"})
                .thenReturn(new String[]{}); // 종료

        when(mockCalculator.calculate("90", "sin", "0")).thenReturn(1.0);

        new CalculatorMainRunner(mockInput, mockCalculator, mockOutput).run();

        verify(mockOutput).printResult(1.0);
        verify(mockCalculator).calculate("90", "sin", "0");
        logger.info("사인 연산 테스트 성공: sin(90) = 1.0");
    }

    /**
     * 프로그램 종료 테스트 (빈 입력)
     */
    @Test
    void testExitOnEmptyInput() {
        when(mockInput.getInput()).thenReturn(new String[]{}); // 종료

        new CalculatorMainRunner(mockInput, mockCalculator, mockOutput).run();

        verify(mockOutput, never()).printResult(anyDouble());
        verify(mockCalculator, never()).calculate(anyString(), anyString(), anyString());
        logger.info("빈 입력 시 프로그램 종료 테스트 성공");
    }

    /**
     * 0으로 나누기 시 예외 처리 테스트
     */
    @Test
    void testDivisionByZero() {
        when(mockInput.getInput())
                .thenReturn(new String[]{"6", "/", "0"})
                .thenReturn(new String[]{}); // 종료

        when(mockCalculator.calculate("6", "/", "0"))
                .thenThrow(new ArithmeticException("0으로 나눌 수 없습니다."));

        new CalculatorMainRunner(mockInput, mockCalculator, mockOutput).run();

        verify(mockOutput, never()).printResult(anyDouble());
        verify(mockCalculator).calculate("6", "/", "0");
        logger.info("0 나누기 예외 처리 테스트 성공");
    }
}
