package ee.ivkhkdev;

import ee.ivkhkdev.intefaces.Input;
import ee.ivkhkdev.intefaces.impl.ConsoleInput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        App app = new App(input);
        app.run();
    }
}