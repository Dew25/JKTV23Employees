package ee.ivkhkdev;



import ee.ivkhkdev.interfaces.EmployeeProvider;
import ee.ivkhkdev.interfaces.InputProvider;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.handlers.EmployeeHandler;

public class App {
    public static Employee[] employees = new Employee[10];
    private final EmployeeHandler employeeHandler;
    private final InputProvider inputProvider;
    private final EmployeeProvider employeeProvider;

    public App(EmployeeHandler employeeHandler, EmployeeProvider employeeProvider, InputProvider inputProvider) {
        this.employeeHandler = employeeHandler;
        this.inputProvider = inputProvider;
        this.employeeProvider = employeeProvider;
    }

    public void run() {
        System.out.println("Программа \"Работники\"");
        boolean repeat = true;
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить работника");
            System.out.println("2. Список работников");
            System.out.print("Введите номер задачи: ");
            int task = Integer.parseInt(inputProvider.getInput());
            switch (task) {
                case 0:
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case 1:
                    employeeHandler.addEmployee(employeeProvider);
                    break;
                case 2:
                    employeeHandler.listEmployees();
                    break;
                default:
                    System.out.println("Выбирайте из списка задач!");
                    break;
            }
        }while (repeat);
        System.out.println("До свидания! :)");
    }
}
