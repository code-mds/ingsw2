public class MockEngine implements IEngine {
    static double WEIGHT = 500;

    @Override
    public double getWeight() {
        return WEIGHT;
    }
}
