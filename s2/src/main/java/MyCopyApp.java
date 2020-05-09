import copier.Copy;
import copier.LineReader;
import copier.LineWriter;
import iteration.BackwardStrategy;
import iteration.ForwardStrategy;
import stats.CharCounter;
import stats.TotalCharWriter;

import java.io.IOException;

public class MyCopyApp {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\massi\\source\\ingsw2\\s2\\src\\main\\resources\\text.txt";

        var statCollector = new CharCounter('A');
        Copy copy = new Copy(new LineReader(path, statCollector));
        copy.toOutput(new LineWriter(System.out, String::toLowerCase, new ForwardStrategy()));
        copy.toOutput(new LineWriter(System.err, String::toUpperCase, new BackwardStrategy()));
        copy.toOutput(new TotalCharWriter(System.out, statCollector.getStats()));
    }
}
