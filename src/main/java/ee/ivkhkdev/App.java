package ee.ivkhkdev;



import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.service.EmployeeService;

import java.util.Scanner;

public class App {
    public static Employee[] employees = new Employee[10];
    private Scanner scanner = new Scanner(System.in);
    public void run() {
        System.out.println("Программа \"Работники\"");
        boolean repeat = true;
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить пользователя");
            System.out.print("Введите номер задачи: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Добавление пользователя");
                    EmployeeService employeeService = new EmployeeService();
                    if(employeeService.createEmployee()){
                        System.out.println("Пользователь добавлен");
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
