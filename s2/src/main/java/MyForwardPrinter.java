import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyForwardPrinter extends MyAbstractPrinter {

    public MyForwardPrinter(String path) throws IOException {
        super(new FileReader(path));
    }

    public MyForwardPrinter(InputStream in) throws IOException {
        super(new InputStreamReader(in));
    }

    @Override
    MyIterator<String> getIterator() {
        return myList.getForwardIterator();
    }
}
