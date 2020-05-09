package stats;

import java.io.IOException;
import java.io.OutputStream;

public interface StatWriter {
    void print() throws IOException;
}
