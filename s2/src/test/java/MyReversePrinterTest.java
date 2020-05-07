import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MyReversePrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {

    }

    @Test
    void printData() throws IOException {
        InputStream in = MyReversePrinter.class.getResourceAsStream("/text.txt");
        MyReversePrinter printer = new MyReversePrinter(in);
        var list =  printer.loadData();
        PrintStream stream = new PrintStream(outContent);
        printer.printData(list, stream);

        String result = "CCC" + System.lineSeparator() +
                "BBB" + System.lineSeparator() +
                "AAA" + System.lineSeparator();
        assertEquals(outContent.toString(), result);
    }

    @Test
    void loadData() {
        assertThrows(FileNotFoundException.class, () -> new MyReversePrinter("path_not_existing"));
    }
}