package ee.ivkhkdev.handlers;

import ee.ivkhkdev.App;
import ee.ivkhkdev.interfaces.EmployeeProvider;
import ee.ivkhkdev.interfaces.InputProvider;
import ee.ivkhkdev.model.Employee;

public class EmployeeHandler {
    private final InputProvider inputProvider;
    private final EmployeeProvider employeeProvider;
    public EmployeeHandler(InputProvider inputProvider, EmployeeProvider employeeProvider) {
        this.inputProvider = inputProvider;
        this.employeeProvider = employeeProvider;
    }
    public void addEmployee(EmployeeProvider employeeProvider){
        System.out.println("Добавление пользователя");
        Employee employee = employeeProvider.newEmployee(inputProvider);
        for(int i=0; i < App.employees.length; i++){
            if(i == 0 && App.employees[i] == null) {
                App.employees[i]=employee;
                System.out.println("Пользователь добавлен");
                break;
            }else if(i>0 && App.employees[i] == null){
                App.employees[i]=employee;
                System.out.println("Пользователь добавлен");
                break;
            }else{
                continue;
            }
        }

    }

    public void listEmployees() {
        for (int i = 0; i < App.employees.length; i++){
            Employee employee = App.employees[i];
            System.out.printf("%d. %s %s. %s. %s.%n",
                    i+1,
                    employee.getPerson().getFirstname(),
                    employee.getPerson().getLastname(),
                    employee.getPosition(),
                    employee.getSalary()
            );
        }
    }
}
