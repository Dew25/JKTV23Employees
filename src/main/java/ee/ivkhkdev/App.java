package ee.ivkhkdev;

import ee.ivkhkdev.intefaces.EmployeeRepository;
import ee.ivkhkdev.intefaces.Input;
import ee.ivkhkdev.intefaces.impl.ConsoleInput;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.services.EmployeeService;

import java.util.Scanner;

public class App {
    public static Employee[] employees;
    private final EmployeeRepository employeeRepository;

    private Input input;
    private final EmployeeService employeeService;

    public App(Input input, EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.input = input;
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        employees = employeeRepository.loadEmployees();
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
                    if(employeeService.createEmployee(input,employeeRepository)){
                        System.out.println("Сотрудник добавлен");
                    }
                    break;
                case 2:
                    System.out.println("Список сотрудников");
                    if(employeeService.printListEmployees(input)){
                        System.out.println("Конец списка");
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
