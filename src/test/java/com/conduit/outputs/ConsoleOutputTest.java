package com.conduit.outputs;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ConsoleOutputTest {
    private static final Logger logger = LoggerFactory.getLogger(ConsoleOutputTest.class);

    /**
     * 정상적인 숫자 출력이 이루어지는지 테스트합니다.
     */
    @Test
    void testValidOutput() {
        ConsoleOutput output = new ConsoleOutput();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        output.printResult(1234.5678);
        System.setOut(originalOut);

        String expectedOutput = "결과: 1234.5678\n";
        assertEquals(expectedOutput, outContent.toString(), "출력 테스트 실패");
        logger.info("출력 테스트 성공: {}", expectedOutput.trim());
    }

    /**
     * 0 출력이 정상적으로 이루어지는지 테스트합니다.
     */
    @Test
    void testZeroOutput() {
        ConsoleOutput output = new ConsoleOutput();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        output.printResult(0);
        System.setOut(originalOut);

        String expectedOutput = "결과: 0\n";
        assertEquals(expectedOutput, outContent.toString(), "출력 테스트 실패");
        logger.info("출력 테스트 성공: {}", expectedOutput.trim());
    }

    /**
     * 음수 출력이 정상적으로 이루어지는지 테스트합니다.
     */
    @Test
    void testNegativeOutput() {
        ConsoleOutput output = new ConsoleOutput();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        output.printResult(-123.45);
        System.setOut(originalOut);

        String expectedOutput = "결과: -123.45\n";
        assertEquals(expectedOutput, outContent.toString(), "음수 출력 테스트 실패");
        logger.info("음수 출력 테스트 성공: {}", expectedOutput.trim());
    }

    /**
     * 소수점이 포함된 출력이 정상적으로 이루어지는지 테스트합니다.
     */
    @Test
    void testDecimalOutput() {
        ConsoleOutput output = new ConsoleOutput();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        output.printResult(3.141592);
        System.setOut(originalOut);

        String expectedOutput = "결과: 3.141592\n";
        assertEquals(expectedOutput, outContent.toString(), "소수점 출력 테스트 실패");
        logger.info("소수점 출력 테스트 성공: {}", expectedOutput.trim());
    }
}
