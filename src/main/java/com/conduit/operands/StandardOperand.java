package com.conduit.operands;

import java.util.regex.Pattern;

public class StandardOperand implements Operand {
    // 정규 표현식: 숫자 형식 검증 (정수 또는 소수)
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+(\\.[0-9]+)?$");

    @Override
    public double parse(String operand) {
        if (!NUMBER_PATTERN.matcher(operand).matches()) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + operand);
        }
        return Double.parseDouble(operand);
    }
}
