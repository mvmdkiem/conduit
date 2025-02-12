package com.conduit.operands;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

class StandardOperandTest {
    private static final Logger logger = LoggerFactory.getLogger(StandardOperandTest.class);
    private final Operand operands = new StandardOperand();

    /**
     * 정수 입력을 정상적으로 파싱하는지 테스트합니다.
     */
    @Test
    void testValidIntegerOperand() {
        assertEquals(10.0, operands.parse("10"), "정수 입력 테스트 실패");
        logger.info("정수 입력 테스트 성공: 10 → 10.0");
    }

    /**
     * 소수 입력을 정상적으로 파싱하는지 테스트합니다.
     */
    @Test
    void testValidDecimalOperand() {
        assertEquals(3.14, operands.parse("3.14"), "소수 입력 테스트 실패");
        logger.info("소수 입력 테스트 성공: 3.14 → 3.14");
    }

    /**
     * 알파벳이 포함된 입력이 예외를 발생시키는지 테스트합니다.
     */
    @Test
    void testInvalidAlphabeticOperand() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> operands.parse("abc"));
        assertEquals("잘못된 숫자 형식입니다: abc", exception.getMessage(), "알파벳 포함된 입력 테스트 실패");
        logger.info("알파벳 포함된 입력 예외 테스트 성공");
    }

    /**
     * 천 단위 구분자(,)가 포함된 입력이 예외를 발생시키는지 테스트합니다.
     */
    @Test
    void testInvalidCommaOperand() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> operands.parse("1,000"));
        assertEquals("잘못된 숫자 형식입니다: 1,000", exception.getMessage(), "천 단위 구분자 포함된 입력 테스트 실패");
        logger.info("천 단위 구분자 포함된 입력 예외 테스트 성공");
    }

    /**
     * 소수점 앞에 숫자가 없는 경우 예외가 발생하는지 테스트합니다.
     */
    @Test
    void testInvalidLeadingDotOperand() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> operands.parse(".123"));
        assertEquals("잘못된 숫자 형식입니다: .123", exception.getMessage(), "소수점 앞 숫자 없는 입력 테스트 실패");
        logger.info("소수점 앞 숫자 없는 입력 예외 테스트 성공");
    }

    /**
     * 소수점 뒤에 숫자가 없는 경우 예외가 발생하는지 테스트합니다.
     */
    @Test
    void testInvalidTrailingDotOperand() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> operands.parse("123."));
        assertEquals("잘못된 숫자 형식입니다: 123.", exception.getMessage(), "소수점 뒤 숫자 없는 입력 테스트 실패");
        logger.info("소수점 뒤 숫자 없는 입력 예외 테스트 성공");
    }

    /**
     * 음수 입력이 예외를 발생시키는지 테스트합니다.
     */
    @Test
    void testNegativeOperand() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> operands.parse("-5"));
        assertEquals("잘못된 숫자 형식입니다: -5", exception.getMessage(), "음수 입력 테스트 실패");
        logger.info("음수 입력 예외 테스트 성공");
    }
}