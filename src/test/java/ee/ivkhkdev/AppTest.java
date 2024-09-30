package ee.ivkhkdev;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    public void testRunExit() {
        String input = "0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        App app = new App();
        app.run();
        String output = out.toString();
        assertTrue(output.contains("До свидания! :)"));
    }
    @Test
    public void testRunTask1() {
        String input = "1\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        App app = new App();
        app.run();
        String output = out.toString();
        assertTrue(output.contains("Пользователь добавлен"));
    }
}