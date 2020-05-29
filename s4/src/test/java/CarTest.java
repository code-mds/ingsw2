import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void getWeight() {
        Injector injector = Guice.createInjector(new CarTestModule());
        Car carTest = injector.getInstance(Car.class);
        double expected = MockEngine.WEIGHT + MockBody.WEIGHT + Interior.WEIGHT + Frame.WEIGHT + Wheel.WEIGHT * 4;
        assertEquals(expected, carTest.getWeight());
    }
}