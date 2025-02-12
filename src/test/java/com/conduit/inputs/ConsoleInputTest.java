package com.conduit.inputs;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class ConsoleInputTest {
    private static final Logger logger = LoggerFactory.getLogger(ConsoleInputTest.class);

    /**
     * 정상적인 콘솔 입력을 테스트합니다.
     */
    @Test
    void testValidConsoleInput() {
        String simulatedInput = "10 + 5\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ConsoleInput input = new ConsoleInput();
        String[] userInput = input.getInput();

        System.setIn(originalSystemIn);
        assertArrayEquals(new String[]{"10", "+", "5"}, userInput, "콘솔 입력 테스트 실패");
        logger.info("정상적인 콘솔 입력 테스트 성공: 10 + 5");
    }

    /**
     * 잘못된 입력(천 단위 구분자 포함)이 예외를 발생시키는지 테스트합니다.
     */
    @Test
    void testInvalidConsoleInput() {
        String simulatedInput = "10,000 + 5\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ConsoleInput input = new ConsoleInput();
        String[] userInput = input.getInput();

        System.setIn(originalSystemIn);
        assertNotEquals(new String[]{"10000", "+", "5"}, userInput, "잘못된 콘솔 입력 테스트 실패");
        logger.info("잘못된 콘솔 입력 예외 테스트 성공: 10,000 + 5");
    }

    /**
     * 연산자가 누락된 경우 예외가 발생하는지 테스트합니다.
     */
    @Test
    void testMissingOperatorInput() {
        String simulatedInput = "10 5\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ConsoleInput input = new ConsoleInput();
        String[] userInput = input.getInput();

        System.setIn(originalSystemIn);
        assertNotEquals(new String[]{"10", "5"}, userInput, "연산자 누락 테스트 실패");
        logger.info("연산자 누락 예외 테스트 성공: 10 5");
    }

    /**
     * 공백 입력이 예외를 발생시키는지 테스트합니다.
     */
    @Test
    void testEmptyInput() {
        String simulatedInput = "\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ConsoleInput input = new ConsoleInput();
        String[] userInput = input.getInput();

        System.setIn(originalSystemIn);
        assertEquals(0, userInput.length, "공백 입력 테스트 실패");
        logger.info("공백 입력 예외 테스트 성공");
    }
}