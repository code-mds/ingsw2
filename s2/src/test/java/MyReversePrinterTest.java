import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MyReversePrinterTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void printData() throws IOException {
        InputStream in = MyList.class.getResourceAsStream("/text.txt");
        MyReversePrinter printer = new MyReversePrinter(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        printer.addOutputStream(new PrintStream(outContent));
        printer.printData();

        String sepator = System.lineSeparator();
        String result = "CCC" + sepator + "BBB" + sepator + "AAA" + sepator;
        assertEquals(outContent.toString(), result);
    }

    @Test
    void loadData() {
        assertThrows(FileNotFoundException.class, () -> new MyReversePrinter("path_not_existing"));
    }
}