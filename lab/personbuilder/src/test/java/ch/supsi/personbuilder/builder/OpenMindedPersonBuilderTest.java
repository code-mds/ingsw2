package ch.supsi.personbuilder.builder;


import ch.supsi.personbuilder.model.ConcretePerson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OpenMindedPersonBuilderTest {

    OpenMindedPersonBuilder builder;

    @Before
    public void beforeEach() {
        builder = new OpenMindedPersonBuilder();
    }

    @Test
    public void constructor0() {
        Assert.assertNotNull(builder);
        Assert.assertTrue(builder instanceof OpenMindedPersonBuilder);
        Assert.assertTrue(builder instanceof AbstractPersonBuilder);
        Assert.assertTrue(builder instanceof PersonBuilder);
    }

    @Test
    public void build0() throws InstantiationException {
        ConcretePerson person = builder.build();
        Assert.assertNotNull(person);
    }

}
