package copier;

import mylist.MyList;
import stats.StatCollector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineReader {
    private final String path;
    private final StatCollector statCollector;

    public LineReader(String path, StatCollector statCollector) {
        this.path = path;
        this.statCollector = statCollector;
    }

    public MyList<String> readAllLines() throws IOException {
        MyList<String> myList = new MyList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            statCollector.parse(line);
            while(line != null) {
                myList.addElement(line);
                line = bufferedReader.readLine();
            }
        }

        return myList;
    }
}
