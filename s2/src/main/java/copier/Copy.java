package copier;

import mylist.MyList;
import stats.StatWriter;
import stats.TotalCharWriter;

import java.io.IOException;

public class Copy {
    protected MyList<String> storage;
    public Copy(LineReader in) throws IOException {
        storage = in.readAllLines();
    }

    public void toOutput(LineWriter out) throws IOException {
        out.printAllLines(storage);
    }

    public void toOutput(StatWriter statWriter) throws IOException {
        statWriter.print();
    }
}
