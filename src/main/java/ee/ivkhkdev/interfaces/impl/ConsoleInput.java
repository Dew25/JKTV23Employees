package ee.ivkhkdev.interfaces.impl;

import ee.ivkhkdev.interfaces.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    @Override
    public String nextLine() {
        return new Scanner(System.in).nextLine();
    }
}
