package ee.ivkhkdev;



import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.service.EmployeeService;

import java.util.Scanner;

public class App {
    private EmployeeService employeeService = new EmployeeService();
    private Input input;
    public App(Input input) {
        this.input=input;
    }

    public static Employee[] employees = new Employee[10];

    public void run() {
        System.out.println("Программа \"Работники\"");
        boolean repeat = true;
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить пользователя");
            System.out.println("2. Удалить пользователя");
            System.out.print("Введите номер задачи: ");
            int task = Integer.parseInt(input.nextLine());
            switch (task) {
                case 0:
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Добавление пользователя");
                    if(employeeService.createEmployee(input)){
                        System.out.println("Пользователь добавлен");
                    };
                    break;
                case 2:
                    System.out.println("Удаление пользователя");
                    if(employeeService.removeEmployee(input)){
                        System.out.println("Пользователь удален");
                    }else{
                        System.out.println("Пользователя удалить не удалось");
                    };
                    break;
                default:
                    System.out.println("Выбирайте из списка задач!");
                    break;
            }
        }while (repeat);
        System.out.println("До свидания! :)");
    }
}
