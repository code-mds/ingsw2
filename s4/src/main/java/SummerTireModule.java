import com.google.inject.AbstractModule;

public class SummerTireModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ITire.class).to(SummerTire.class);
    }
}
