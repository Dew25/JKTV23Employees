package ee.ivkhkdev.intefaces.impl;

import ee.ivkhkdev.App;
import ee.ivkhkdev.intefaces.EmployeeProvider;
import ee.ivkhkdev.intefaces.Input;
import ee.ivkhkdev.model.Address;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.Person;

public class InputEmployee implements EmployeeProvider {
    @Override
    public Employee addEmployee(Input input) {
        Address address = new Address();
        Person person = new Person();

        Employee employee = new Employee();
        System.out.println("Новый сотрудник");
        System.out.print("Имя: ");
        person.setFirstname(input.nextLine());
        System.out.print("Фамилия: ");
        person.setLastname(input.nextLine());

        System.out.print("Должность: ");
        employee.setPosition(input.nextLine());
        System.out.print("Зарплата: ");
        employee.setSalary(input.nextLine());

        System.out.println("Адрес: ");
        System.out.print("Город: ");
        address.setCity(input.nextLine());
        System.out.print("Улица: ");
        address.setStreet(input.nextLine());
        System.out.print("Дом: ");
        address.setHouse(input.nextLine());
        System.out.print("Квартира: ");

        address.setAppartment(input.nextLine());
        person.setAddress(address);

        employee.setPerson(person);

        return employee;
    }

    @Override
    public void listEmployees() {
        for (int i=0;i< App.employees.length;i++){
            Employee employee = App.employees[i];
            if(employee != null){
                System.out.printf("%d. %s %s. %s. %s%n",
                        i+1,
                        employee.getPerson().getFirstname(),
                        employee.getPerson().getLastname(),
                        employee.getPosition(),
                        employee.getSalary()
                );
            }
        }
    }
}
