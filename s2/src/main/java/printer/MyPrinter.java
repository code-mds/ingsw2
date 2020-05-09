package printer;

import converter.LineTrasfomer;

import java.io.IOException;
import java.io.PrintStream;

public interface MyPrinter {
    void printData() throws IOException;
    void addTransformer(LineTrasfomer transformer);
    void addOutputStream(PrintStream stream);
}
