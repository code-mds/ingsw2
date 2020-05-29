import com.google.inject.Inject;

public class Wheel {
    static double WEIGHT = 50;

    @Inject
    ITire tear;

    public double getWeight() {
        return WEIGHT + tear.getWeight();
    }
}
