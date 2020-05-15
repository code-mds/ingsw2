import converter.LowerCaseTransformer;
import printer.MyForwardPrinter;
import printer.MyPrinter;
import printer.MyReversePrinter;

import java.io.IOException;

public class MyPrinterApp {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\massi\\source\\ingsw2\\s2\\src\\main\\resources\\text.txt";

        // backward
        MyPrinter printer = new MyReversePrinter(path);
        printer.addOutputStream(System.out);
        printer.printData();

        // forward
        printer = new MyForwardPrinter(path);
        printer.addTransformer(new LowerCaseTransformer());
        printer.addOutputStream(System.out);
        printer.addOutputStream(System.err);
        printer.printData();

    }
}
