package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class AppTest {
    Input inputMock = Mockito.mock(Input.class);
    PrintStream defaultOut = System.out;
    ByteArrayOutputStream outMock = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outMock));
    }

    @AfterEach
    void tearDown(){
        System.setOut(defaultOut);
    }

    @Test
    @Order(1)
    public void testRunExit() {
        when(inputMock.nextLine()).thenReturn("0");
        App app = new App(inputMock);
        app.run();
        assertTrue(outMock.toString().contains("До свидания! :)"));
    }

    @Test
    @Order(2)
    public void testRunTask1AddEmployee() {
        when(inputMock.nextLine()).thenReturn("1","Ivan", "Ivanov", "Director","3000", "0");
        App app = new App(inputMock);
        app.run();
        assertTrue(outMock.toString().contains("Пользователь добавлен"));
    }
    @Test
    @Order(3)
    public void testRunTask1RemoveEmployee() {
        when(inputMock.nextLine()).thenReturn("2", "0");
        App app = new App(inputMock);
        app.run();
        assertTrue(outMock.toString().contains("Пользователя удалить не удалось"));
    }

}