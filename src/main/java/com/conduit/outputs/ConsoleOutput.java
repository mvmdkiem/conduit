package com.conduit.outputs;

import java.text.DecimalFormat;

public class ConsoleOutput implements Output {
    private static final DecimalFormat formatter = new DecimalFormat("0.######");

    @Override
    public void printResult(double result) {
        System.out.println("결과: " + formatter.format(result));
    }
}
