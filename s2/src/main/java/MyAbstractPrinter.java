import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class MyAbstractPrinter implements MyPrinter {
    protected IMyList<String> myList;
    private List<LineTrasfomer> transformers = new ArrayList<>();
    private List<OutputStream> outputStreams = new ArrayList<>();

    public MyAbstractPrinter(Reader reader) throws IOException {
        try(reader) {
            myList = loadData(reader);
        }
    }

    abstract MyIterator<String> getIterator();

    @Override
    public void printData() throws IOException {
        MyIterator<String> it = getIterator();
        while(it.hasMoreElements()) {
            String line = it.nextElement();
            for (var transformer: transformers) {
                line = transformer.transform(line);
            }
            for (var stream : outputStreams) {
                stream.write(line.getBytes());
                stream.write(System.lineSeparator().getBytes());
            }
        }
    }

    @Override
    public void addTransformer(LineTrasfomer transformer) {
        transformers.add(transformer);
    }

    @Override
    public void addOutputStream(PrintStream stream) {
        outputStreams.add(stream);
    }

    private IMyList<String> loadData(Reader reader) throws IOException {
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
