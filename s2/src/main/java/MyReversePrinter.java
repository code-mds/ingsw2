import java.io.*;

public class MyReversePrinter {
    private final Reader reader;
    MyReversePrinter(String path) throws FileNotFoundException {
        reader = new FileReader(path);
    }

    MyReversePrinter(InputStream in) {
        reader = new InputStreamReader(in);
    }

    public static void main(String[] args) throws IOException {
        MyReversePrinter printer = new MyReversePrinter("C:\\Users\\massi\\source\\ingsw2\\s2\\src\\main\\resources\\text.txt");
        var list = printer.loadData();
        printer.printData(list, System.out);
    }

    void printData(IMyList<String> myList, PrintStream stream) {
        MyIterator<String> it = myList.getBackwardIterator();
        while(it.hasMoreElements())
            stream.println(it.nextElement());
    }

    IMyList<String> loadData() throws IOException {
        IMyList<String> myList = new MyList<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while(line != null) {
            myList.addElement(line);
            line = bufferedReader.readLine();
        }
        return myList;
    }
}
