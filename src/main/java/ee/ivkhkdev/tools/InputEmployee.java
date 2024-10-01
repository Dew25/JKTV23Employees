package ee.ivkhkdev.tools;

import ee.ivkhkdev.interfaces.EmployeeProvider;
import ee.ivkhkdev.interfaces.InputProvider;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.Person;

import java.util.Scanner;

public class InputEmployee implements EmployeeProvider {

    public Employee newEmployee(InputProvider inputProvider){
        Employee employee = new Employee();
        Person person = new Person();
        System.out.print("Имя: ");
        person.setFirstname(inputProvider.getInput());
        System.out.print("Фамилия: ");
        person.setLastname(inputProvider.getInput());
        employee.setPerson(person);
        System.out.print("Должность: ");
        employee.setPosition(inputProvider.getInput());
        System.out.print("Зарплата: ");
        employee.setSalary(inputProvider.getInput());
        return employee;
    }
}
