package ee.ivkhkdev;

import ee.ivkhkdev.intefaces.EmployeeProvider;
import ee.ivkhkdev.intefaces.EmployeeRepository;
import ee.ivkhkdev.intefaces.Input;
import ee.ivkhkdev.intefaces.impl.ConsoleInput;
import ee.ivkhkdev.intefaces.impl.EmployeeFileService;
import ee.ivkhkdev.intefaces.impl.InputEmployee;
import ee.ivkhkdev.services.EmployeeService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Input input = new ConsoleInput();
        EmployeeProvider employeeProvider = new InputEmployee();
        EmployeeService employeeService = new EmployeeService(employeeProvider);
        EmployeeRepository employeeRepository = new EmployeeFileService();
        App app = new App(input,employeeService,employeeRepository);
        app.run();
    }
}