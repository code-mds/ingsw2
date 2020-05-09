package ch.supsi.personbuilder.builder;


import ch.supsi.personbuilder.model.ConcretePerson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PickyPersonBuilderTest {

    PickyPersonBuilder builder;

    @Before
    public void beforeEach() {
        builder = new PickyPersonBuilder();
    }

    @Test
    public void constructor0() {
        Assert.assertNotNull(builder);
        Assert.assertTrue(builder instanceof PickyPersonBuilder);
        Assert.assertTrue(builder instanceof AbstractPersonBuilder);
        Assert.assertTrue(builder instanceof PersonBuilder);
    }

    @Test(expected = InstantiationException.class)
    public void build0() throws InstantiationException {
        PickyPersonBuilder builderSpy = Mockito.spy(builder);
        Mockito.when(builderSpy.getFirstname()).thenReturn(null);
        Mockito.when(builderSpy.getLastname()).thenReturn("last name");

        builderSpy.build();
    }

    @Test(expected = InstantiationException.class)
    public void build1() throws InstantiationException {
        PickyPersonBuilder builderSpy = Mockito.spy(builder);
        Mockito.when(builderSpy.getFirstname()).thenReturn("");
        Mockito.when(builderSpy.getLastname()).thenReturn("last name");

        builderSpy.build();
    }

    @Test(expected = InstantiationException.class)
    public void build2() throws InstantiationException {
        PickyPersonBuilder builderSpy = Mockito.spy(builder);
        Mockito.when(builderSpy.getFirstname()).thenReturn("first name");
        Mockito.when(builderSpy.getLastname()).thenReturn(null);

        builderSpy.build();
    }

    @Test(expected = InstantiationException.class)
    public void build3() throws InstantiationException {
        PickyPersonBuilder builderSpy = Mockito.spy(builder);
        Mockito.when(builderSpy.getFirstname()).thenReturn("first name");
        Mockito.when(builderSpy.getLastname()).thenReturn("");

        builderSpy.build();
    }

    @Test
    public void build() throws InstantiationException {
        PickyPersonBuilder builderSpy = Mockito.spy(builder);
        Mockito.when(builderSpy.getFirstname()).thenReturn("first name");
        Mockito.when(builderSpy.getLastname()).thenReturn("last name");

        ConcretePerson person = builderSpy.build();
        Assert.assertNotNull(person);
    }

}
