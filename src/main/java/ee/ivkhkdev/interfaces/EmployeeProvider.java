package ee.ivkhkdev.interfaces;

import ee.ivkhkdev.model.Employee;

public interface EmployeeProvider{
    Employee newEmployee(InputProvider inputProvider);
}
