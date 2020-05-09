package stats;

public class CharCounter implements StatCollector {
    private final char ch;
    private int counter;

    public CharCounter(char ch) {
        this.ch = ch;
    }

    @Override
    public void parse(String line) {
        counter += line
                .chars()
                .filter( c -> c == ch)
                .count();
    }

    public TotalCharStat getStats() {
        return new TotalCharStat(ch, counter);
    }
}
