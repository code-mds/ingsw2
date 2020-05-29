import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class CarTestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IEngine.class).to(MockEngine.class);
        bind(IBody.class).to(MockBody.class);
    }
    @Provides
    Wheel[] provideWheels (){
        return new Wheel[] { new Wheel(), new Wheel(), new Wheel(), new Wheel() };
    }
}
