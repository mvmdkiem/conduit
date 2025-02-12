package com.conduit.calculators;

import com.conduit.operands.StandardOperand;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {
    private static final Logger logger = LoggerFactory.getLogger(BasicCalculatorTest.class);
    private final BasicCalculator calculator = new BasicCalculator(new StandardOperand());

    /**
     * 덧셈 연산을 테스트합니다.
     */
    @Test
    void testAddition() {
        assertEquals(8.0, calculator.calculate("5", "+", "3"), "덧셈 테스트 실패");
        logger.info("덧셈 테스트 성공: 5 + 3 = 8.0");
    }

    /**
     * 뺄셈 연산을 테스트합니다.
     */
    @Test
    void testSubtraction() {
        assertEquals(2.0, calculator.calculate("5", "-", "3"), "뺄셈 테스트 실패");
        logger.info("뺄셈 테스트 성공: 5 - 3 = 2.0");
    }

    /**
     * 곱셈 연산을 테스트합니다.
     */
    @Test
    void testMultiplication() {
        assertEquals(15.0, calculator.calculate("5", "*", "3"), "곱셈 테스트 실패");
        logger.info("곱셈 테스트 성공: 5 * 3 = 15.0");
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
}

