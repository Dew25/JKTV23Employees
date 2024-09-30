package ee.ivkhkdev.tools;

import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.Person;

import java.util.Scanner;

public class InputEmployee {
    private Scanner scanner = new Scanner(System.in);
    public Employee newEmployee(){
        Employee employee = new Employee();
        Person person = new Person();
        System.out.print("Имя: ");
        person.setFirstname(scanner.nextLine());
        System.out.print("Фамилия: ");
        person.setLastname(scanner.nextLine());
        employee.setPerson(person);
        System.out.print("Должность: ");
        employee.setPosition(scanner.nextLine());
        System.out.print("Зарплата: ");
        employee.setSalary(scanner.nextLine());
        return employee;
    }
}
