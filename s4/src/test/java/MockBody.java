public class MockBody implements IBody {
    static double WEIGHT = 500;

    @Override
    public double getWeight() {
        return WEIGHT;
    }
}
