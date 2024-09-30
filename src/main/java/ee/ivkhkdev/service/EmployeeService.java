package ee.ivkhkdev.service;

import ee.ivkhkdev.App;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.Person;
import ee.ivkhkdev.tools.InputEmployee;

public class EmployeeService {

    public boolean createEmployee(InputEmployee inputEmployee) {
        Employee employee = inputEmployee.newEmployee();
        App.employees[0] = employee;
        return true;
    }
}
