package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.EmployeeProvider;
import ee.ivkhkdev.interfaces.InputProvider;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.Person;
import ee.ivkhkdev.handlers.EmployeeHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AppTest {
    PrintStream defaultOut;
    ByteArrayOutputStream out;
    InputProvider mockInputProvider;
    EmployeeProvider mockEmployeeProvider;
    EmployeeHandler employeeHandler;
    @BeforeEach
    public void setUp(){
        mockInputProvider = mock(InputProvider.class);
        mockEmployeeProvider = mock(EmployeeProvider.class);
        employeeHandler = new EmployeeHandler(mockInputProvider,mockEmployeeProvider);
        defaultOut = System.out;
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }
    @AfterEach
    public void tearDown() {
        mockInputProvider = null;
        mockEmployeeProvider=null;
        employeeHandler = null;
    }
    @Test
    public void testRunExit() {
        when(mockInputProvider.getInput())
                .thenReturn("0");
        when(mockEmployeeProvider.newEmployee(mockInputProvider)).thenReturn(new Employee("Директор","3000",new Person("Иван","Иванов")));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        App app = new App(employeeHandler,mockEmployeeProvider,mockInputProvider);
        app.run();
        String output = out.toString();
        assertTrue(output.contains("До свидания! :)"));

    }
    @Test
    public void testRunTask1() {
        when(mockInputProvider.getInput())
                .thenReturn("1")
                .thenReturn("0");
        when(mockEmployeeProvider.newEmployee(mockInputProvider)).thenReturn(new Employee("Директор","3000",new Person("Иван","Иванов")));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        App app = new App(employeeHandler,mockEmployeeProvider,mockInputProvider);
        app.run();
        String output = out.toString();
        System.setOut(defaultOut);
        System.out.println(output);
        assertTrue(output.contains("До свидания! :)"));
        assertTrue(App.employees[0] != null);
    }
    @Test
    public void testRunTask2(){
        when(mockInputProvider.getInput())
                .thenReturn("2")
                .thenReturn("0");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        App app = new App(employeeHandler,mockEmployeeProvider,mockInputProvider);
        app.run();
        String output = out.toString();
        System.setOut(defaultOut);
        System.out.println(output);
        assertTrue(output.contains("Иван"));
        assertTrue(output.contains("До свидания! :)"));
    }
}