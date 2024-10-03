package ee.ivkhkdev.service;

import ee.ivkhkdev.App;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.Person;
import ee.ivkhkdev.tools.InputEmployee;

import java.beans.Customizer;

public class EmployeeService {

    public boolean createEmployee(Input input) {
        Employee employee = new InputEmployee().newEmployee(input);
        for(int i = 0; i < App.employees.length; i++){
            if(i == 0 && App.employees[i] == null){
                App.employees[i] = employee;
                break;
            }else if(i == 0 && App.employees[i] == null){
                    App.employees[i] = employee;
                    break;
            }
        }
        return true;
    }

    public boolean removeEmployee(Input input) {
        this.printLisnCusotmers();
        int num = new InputEmployee().findEmployeeNumber(input);
        if(num > 0) {
            App.employees[num-1]=null;
            return true;
        }else{
            return false;
        }
    }
    public void printLisnCusotmers(){
        int n = 1;
        for(Employee employee : App.employees){
            if(employee != null){
                System.out.printf("%d. id: %s %s %s. %s. %s EUR%n",
                        n++,
                        employee.getId().toString(),
                        employee.getPerson().getFirstname(),
                        employee.getPerson().getLastname(),
                        employee.getPerson(),
                        employee.getSalary()
                );
            }
        }
    }
}
