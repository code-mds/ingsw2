package copier;

import iteration.IteratorStrategy;
import mylist.MyIterator;
import mylist.MyList;
import converter.LineTrasfomer;

import java.io.IOException;
import java.io.OutputStream;

public class LineWriter {
    private final LineTrasfomer converter;
    private final OutputStream outStream;
    private final IteratorStrategy iteratorStragy;

    public LineWriter(OutputStream outStream, LineTrasfomer converter, IteratorStrategy iteratorStragy) {
        this.converter = converter;
        this.outStream = outStream;
        this.iteratorStragy = iteratorStragy;
    }

    public void printAllLines(MyList<String> storage) throws IOException {
        MyIterator<String> it = iteratorStragy.getIterator(storage);
        while(it.hasMoreElements()) {
            String line = converter.transform(it.nextElement());
            outStream.write(line.getBytes());
            outStream.write(System.lineSeparator().getBytes());
        }
    }
}
