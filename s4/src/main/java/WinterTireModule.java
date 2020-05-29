import com.google.inject.AbstractModule;

public class WinterTireModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ITire.class).to(WinterTire.class);
    }
}
