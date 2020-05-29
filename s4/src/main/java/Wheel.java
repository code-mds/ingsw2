import com.google.inject.Inject;

public class Wheel {
    static double WEIGHT = 50;

    @Inject
    ITear tear;

    public double getWeight() {
        return WEIGHT + tear.getWeight();
    }
}
