import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class CarModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IBody.class).to(Body.class);
        bind(IEngine.class).to(Engine.class);
    }

    @Provides
    Wheel[] provideWheels() {
        return new Wheel[] { new Wheel(), new Wheel(), new Wheel(), new Wheel() };
    }
}
