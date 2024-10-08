package ee.ivkhkdev;

import ee.ivkhkdev.intefaces.Input;
import ee.ivkhkdev.intefaces.impl.EmployeeFileService;
import ee.ivkhkdev.intefaces.impl.InputEmployee;
import ee.ivkhkdev.model.Address;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.Person;
import ee.ivkhkdev.services.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AppTest {
    OutputStream defaultOut;
    ByteArrayOutputStream mockOut;
    Input mockInput;

    @BeforeEach
    void setUp() {
        mockInput = mock(Input.class);
        defaultOut = System.out;
        mockOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOut));
    }

    @AfterEach
    void tearDown() {
        System.setOut(new PrintStream(defaultOut));
    }
    @Test
    public void testRunExit() {
        when(mockInput.nextLine()).thenReturn("0");
        App app = new App(mockInput,new EmployeeService(new InputEmployee()),new EmployeeFileService());
        app.run();
        String actualOut = mockOut.toString();
//        System.setOut(new PrintStream(defaultOut));
//        System.out.println(mockOut.toString());
        String expectedOutFragment = "До свидания! :)";
        assertTrue(actualOut.contains(expectedOutFragment));
    }
    @Test
    public void testRunTask1() {
        when(mockInput.nextLine()).thenReturn("1","0");
        InputEmployee inputEmployeeMock = mock(InputEmployee.class);
        when(inputEmployeeMock.addEmployee(mockInput)).thenReturn(
                new Employee(
                        "Director",
                        "3000",
                        new Person("Ivan",
                                "Ivanov",
                                new Address(
                                        "Johvi",
                                        "Kooli",
                                        "32",
                                        "3"
                                )
                        )
                )
        );
        App app = new App(mockInput, new EmployeeService(inputEmployeeMock),new EmployeeFileService());
        app.run();
        String actualOut = mockOut.toString();
//        System.setOut(new PrintStream(defaultOut));
//        System.out.println(mockOut.toString());
        String expectedOutFragment1 = "Сотрудник добавлен";
        String expectedOutFragment2 = "До свидания! :)";
        assertTrue(actualOut.contains(expectedOutFragment1));
        assertTrue(actualOut.contains(expectedOutFragment2));
    }
    @Test
    void testRunPrintListEmployees(){
        InputEmployee inputEmployeeMock = mock(InputEmployee.class);
        when(mockInput.nextLine()).thenReturn("1","2","0");
        when(inputEmployeeMock.addEmployee(mockInput)).thenReturn(
                new Employee(
                        "Director",
                        "3000",
                        new Person("Ivan",
                                "Ivanov",
                                new Address(
                                        "Johvi",
                                        "Kooli",
                                        "32",
                                        "3"
                                )
                        )
                )
        );

        App app = new App(mockInput, new EmployeeService(inputEmployeeMock),new EmployeeFileService());
        app.run();
        String actualOut = mockOut.toString();
        System.setOut(new PrintStream(defaultOut));
        System.out.println(mockOut.toString());
        String expectedOutFragment1 = "Конец списка";

        assertTrue(actualOut.contains(expectedOutFragment1));
    }
}