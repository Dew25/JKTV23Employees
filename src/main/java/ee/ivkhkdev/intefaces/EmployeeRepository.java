package ee.ivkhkdev.intefaces;

import ee.ivkhkdev.App;
import ee.ivkhkdev.model.Employee;

public interface EmployeeRepository {
    boolean saveEmployees(Employee[] employees);
    Employee[] loadEmployees();
}
