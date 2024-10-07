package ee.ivkhkdev;

import ee.ivkhkdev.intefaces.Input;
import ee.ivkhkdev.intefaces.impl.ConsoleInput;

import java.util.Scanner;

public class App {
    private Input input;

    public App(Input input) {
        this.input = input;
    }

    public void run() {
        System.out.println("Программа \"Работники\"");
        boolean repeat = true;
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить пользователя");
            System.out.print("Введите номер задачи: ");
            int task = Integer.parseInt(input.nextLine());
            switch (task) {
                case 0:
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Добавление пользователя");
                    break;
                default:
                    System.out.println("Выбирайте из списка задач!");
                    break;
            }
        }while (repeat);
        System.out.println("До свидания! :)");
    }
}
