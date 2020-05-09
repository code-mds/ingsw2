package stats;

public class TotalCharStat {
    private final char ch;
    private final int counter;

    public TotalCharStat(char ch, int counter) {
        this.ch = ch;
        this.counter = counter;
    }

    public char getCh() {
        return ch;
    }

    public int getCounter() {
        return counter;
    }
}
