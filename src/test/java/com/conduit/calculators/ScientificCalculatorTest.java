package com.conduit.calculators;

import com.conduit.operands.StandardOperand;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

class ScientificCalculatorTest {
    private static final Logger logger = LoggerFactory.getLogger(ScientificCalculatorTest.class);
    private final ScientificCalculator calculator = new ScientificCalculator(new StandardOperand());

    /**
     * 덧셈 연산을 테스트합니다.
     */
    @Test
    void testAddition() {
        assertEquals(5.0, calculator.calculate("2", "+", "3"), "덧셈 테스트 실패");
        logger.info("덧셈 테스트 성공: 2 + 3 = 5.0");
    }

    /**
     * 뺄셈 연산을 테스트합니다.
     */
    @Test
    void testSubtraction() {
        assertEquals(1.0, calculator.calculate("4", "-", "3"), "뺄셈 테스트 실패");
        logger.info("뺄셈 테스트 성공: 4 - 3 = 1.0");
    }

    /**
     * 곱셈 연산을 테스트합니다.
     */
    @Test
    void testMultiplication() {
        assertEquals(12.0, calculator.calculate("4", "*", "3"), "곱셈 테스트 실패");
        logger.info("곱셈 테스트 성공: 4 * 3 = 12.0");
    }

    /**
     * 나눗셈 연산을 테스트합니다.
     */
    @Test
    void testDivision() {
        assertEquals(2.0, calculator.calculate("6", "/", "3"), "나눗셈 테스트 실패");
        logger.info("나눗셈 테스트 성공: 6 / 3 = 2.0");
    }

    /**
     * 0으로 나눌 경우 예외가 발생하는지 테스트합니다.
     */
    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.calculate("6", "/", "0"));
        assertEquals("0으로 나눌 수 없습니다.", exception.getMessage(), "0 나누기 테스트 실패");
        logger.info("0 나누기 예외 테스트 성공");
    }

    /**
     * 사인 연산을 테스트합니다.
     */
    @Test
    void testSine() {
        assertEquals(1.0, calculator.calculate("90", "sin", "0"), 0.0001, "사인 함수 테스트 실패");
        logger.info("사인 테스트 성공: sin(90) = 1.0");
    }

    /**
     * 코사인 연산을 테스트합니다.
     */
    @Test
    void testCosine() {
        assertEquals(0.0, calculator.calculate("90", "cos", "0"), 0.0001, "코사인 함수 테스트 실패");
        logger.info("코사인 테스트 성공: cos(90) = 0.0");
    }

    /**
     * 탄젠트 연산을 테스트합니다.
     */
    @Test
    void testTangent() {
        assertEquals(1.0, calculator.calculate("45", "tan", "0"), 0.0001, "탄젠트 함수 테스트 실패");
        logger.info("탄젠트 테스트 성공: tan(45) = 1.0");
    }

    /**
     * 잘못된 연산자가 입력되었을 때 예외가 발생하는지 테스트합니다.
     */
    @Test
    void testInvalidOperator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("6", "%", "2"));
        assertEquals("잘못된 연산자입니다: %", exception.getMessage(), "잘못된 연산자 테스트 실패");
        logger.info("잘못된 연산자 예외 테스트 성공");
    }

    /**
     * 잘못된 피연산자가 입력되었을 때 예외가 발생하는지 테스트합니다.
     */
    @Test
    void testInvalidOperands() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("abc", "+", "2"));
        assertEquals("잘못된 숫자 형식입니다: abc", exception.getMessage(), "잘못된 숫자 입력 테스트 실패");
        logger.info("잘못된 숫자 입력 예외 테스트 성공");
    }
}

