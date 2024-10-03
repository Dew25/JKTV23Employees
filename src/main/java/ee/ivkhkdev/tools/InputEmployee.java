package ee.ivkhkdev.tools;

import ee.ivkhkdev.App;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.Person;

import javax.swing.text.html.Option;
import java.util.Scanner;

public class InputEmployee {

    public Employee newEmployee(Input input){
        Employee employee = new Employee();
        Person person = new Person();
        System.out.print("Имя: ");
        person.setFirstname(input.nextLine());
        System.out.print("Фамилия: ");
        person.setLastname(input.nextLine());
        employee.setPerson(person);
        System.out.print("Должность: ");
        employee.setPosition(input.nextLine());
        System.out.print("Зарплата: ");
        employee.setSalary(input.nextLine());
        return employee;
    }
    public int findEmployeeNumber(Input input){
        System.out.print("Выберите номер сотрудника или нажмите n: ");
        try {
            return Integer.parseInt(input.nextLine());
        }catch (Exception x){
            return -1;
        }
    }
}
