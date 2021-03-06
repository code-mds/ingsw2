import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;

public class CarModule extends AbstractModule {
    private AbstractModule tireModule;
    public CarModule(AbstractModule tireModule) {
        this.tireModule = tireModule;
    }

    @Override
    protected void configure() {
        bind(IBody.class).to(Body.class);
        bind(IEngine.class).to(Engine.class);
    }

    @Provides
    Wheel[] provideWheels() {
        Injector injector = Guice.createInjector(tireModule);
        Wheel[] wheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            wheels[i] = injector.getInstance(Wheel.class);
        }
        return wheels;
    }
}
