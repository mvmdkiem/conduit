package com.conduit.inputs;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String[] getInput() {
        System.out.print("계산식을 입력하세요 (예: 2 + 3): ");
        String inputLine = scanner.nextLine().trim();

        if (inputLine.isEmpty()) {
            return new String[0];
        }

        return inputLine.split(" ");
    }
}
