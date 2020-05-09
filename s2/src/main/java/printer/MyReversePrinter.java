package printer;

import mylist.MyIterator;

import java.io.*;

public class MyReversePrinter extends MyAbstractPrinter {

    public MyReversePrinter(String path) throws IOException {
        super(new FileReader(path));
    }

    public MyReversePrinter(InputStream in) throws IOException {
        super(new InputStreamReader(in));
    }

    @Override
    MyIterator<String> getIterator() {
        return myList.getBackwardIterator();
    }
}
