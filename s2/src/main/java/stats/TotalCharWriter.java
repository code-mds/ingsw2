package stats;

import java.io.IOException;
import java.io.OutputStream;

public class TotalCharWriter implements StatWriter {
    private final TotalCharStat stat;
    private final OutputStream outStream;

    public TotalCharWriter(OutputStream outStream, TotalCharStat stat) {
        this.stat = stat;
        this.outStream = outStream;
    }

    @Override
    public void print() throws IOException {
        String report = String.format("Total counter of char %c is %d%s",
                stat.getCh(), stat.getCounter(), System.lineSeparator());
        outStream.write(report.getBytes());
    }
}
