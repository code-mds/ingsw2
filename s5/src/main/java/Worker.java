import jdk.jshell.spi.ExecutionControl;

public class Worker {
    private final int startingValue;
    public Worker(int startingValue) {
        this.startingValue = startingValue;
    }

    public static int conversion(int value) {
        if(value % 2 == 0)
            return value/2;

        return value*3+1;
    }

    public  int sequence() {
        if(startingValue <= 2)
            throw new IllegalArgumentException();

        int seq = 0;
        int value = startingValue;
        do {
            value = conversion(value);
            seq++;
        } while(value != 1);
        return seq;
    }
}
