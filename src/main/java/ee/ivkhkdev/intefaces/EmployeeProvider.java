package ee.ivkhkdev.intefaces;

import ee.ivkhkdev.model.Employee;

public interface EmployeeProvider {
    Employee addEmployee(Input input);
    void listEmployees();
}
