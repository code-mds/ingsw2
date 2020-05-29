import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainProgram {
    public static void main(String... args) {
        Injector injector = Guice.createInjector(new CarModule());
        Car car = injector.getInstance(Car.class);
        System.out.println("Peso macchina:" + car.getWeight());
    }
}
