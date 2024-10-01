package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.EmployeeProvider;
import ee.ivkhkdev.interfaces.InputProvider;
import ee.ivkhkdev.handlers.ConsoleHandler;
import ee.ivkhkdev.handlers.EmployeeHandler;
import ee.ivkhkdev.tools.InputEmployee;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        InputProvider inputProvider = new ConsoleHandler();
        EmployeeProvider employeeProvider = new InputEmployee();
        EmployeeHandler employeeHandler = new EmployeeHandler(inputProvider, employeeProvider);
        App app = new App(employeeHandler,employeeProvider,inputProvider);
        app.run();
    }
}