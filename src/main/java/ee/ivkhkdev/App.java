package ee.ivkhkdev;

import ee.ivkhkdev.intefaces.Input;
import ee.ivkhkdev.intefaces.impl.ConsoleInput;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.services.EmployeeService;

import java.util.Scanner;

public class App {
    public static Employee[] employees = new Employee[100];

    private Input input;
    private final EmployeeService employeeService;

    public App(Input input, EmployeeService employeeService) {
        this.input = input;
        this.employeeService = employeeService;
    }

    public void run() {
        System.out.println("Программа \"Работники\"");
        boolean repeat = true;
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить сотрудника");
            System.out.println("2. Список сотрудников");
            System.out.print("Введите номер задачи: ");
            int task = Integer.parseInt(input.nextLine());
            switch (task) {
                case 0:
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Добавление сотрудника");
                    if(employeeService.createEmployee(input)){
                        System.out.println("Сотрудник добавлен");
                    }
                    break;
                case 2:
                    System.out.println("Список сотрудников");
                    employeeService.printListEmployees(input);
                    break;
                default:
                    System.out.println("Выбирайте из списка задач!");
                    break;
            }
        }while (repeat);
        System.out.println("До свидания! :)");
    }
}
