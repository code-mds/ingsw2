package ch.supsi.personbuilder.model;


import ch.supsi.personbuilder.builder.PersonBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ConcretePersonTest {

    @Test(expected = InstantiationException.class)
    public void constructor0() throws InstantiationException {
        new ConcretePerson(null);
    }

    @Test
    public void constructor1() throws InstantiationException {
        PersonBuilder builder = Mockito.mock(PersonBuilder.class);

        ConcretePerson person = new ConcretePerson(builder);
        Assert.assertNotNull(person);
        Assert.assertTrue(person instanceof AbstractPerson);
        Assert.assertTrue(person instanceof Person);
    }

}
