import com.google.inject.AbstractModule;

public class TearModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ITear.class).to(WinterTear.class);
    }
}
