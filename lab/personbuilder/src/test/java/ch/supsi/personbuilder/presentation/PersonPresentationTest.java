package ch.supsi.personbuilder.presentation;


import ch.supsi.personbuilder.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class PersonPresentationTest {


    @Test(expected = InstantiationException.class)
    public void constructor0() throws InstantiationException {
        new PersonPresentation(null);
    }

    @Test
    public void constructor() throws InstantiationException {
        Person person = Mockito.mock(Person.class);

        PersonPresentation presentation = new PersonPresentation(person);
        Assert.assertNotNull(presentation);
        Assert.assertEquals(presentation.person, person);
    }

    @Test
    public void present0() throws InstantiationException {
        Person person = Mockito.mock(Person.class);

        String expectedPresentation = "PERSON PRESENTATION...";

        String presentation = new PersonPresentation(person).present();
        Assert.assertEquals(expectedPresentation, presentation);
    }

    @Test
    public void present1() throws InstantiationException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getFirstname()).thenReturn("");
        Mockito.when(person.getMiddlename()).thenReturn("");
        Mockito.when(person.getLastname()).thenReturn("");
        Mockito.when(person.getEmailAddress()).thenReturn("");
        Mockito.when(person.getCellPhoneNumber()).thenReturn("");

        String expectedPresentation = "PERSON PRESENTATION...";

        String presentation = new PersonPresentation(person).present();
        Assert.assertEquals(expectedPresentation, presentation);
    }

    @Test
    public void present2() throws InstantiationException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getFirstname()).thenReturn("first name");
        Mockito.when(person.getMiddlename()).thenReturn("middle name");
        Mockito.when(person.getLastname()).thenReturn("last name");
        Mockito.when(person.getEmailAddress()).thenReturn("email address");
        Mockito.when(person.getCellPhoneNumber()).thenReturn("cell phone number");

        String expectedPresentation = "PERSON PRESENTATION...";
        expectedPresentation += "\n" + "first name...first name";
        expectedPresentation += "\n" + "middle name...middle name";
        expectedPresentation += "\n" + "last name...last name";
        expectedPresentation += "\n" + "email address...email address";
        expectedPresentation += "\n" + "cell phone number...cell phone number";

        String presentation = new PersonPresentation(person).present();
        Assert.assertEquals(expectedPresentation, presentation);
    }

    @Test
    public void present3() throws InstantiationException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getFirstname()).thenReturn("first name");
        Mockito.when(person.getMiddlename()).thenReturn(null);
        Mockito.when(person.getLastname()).thenReturn("last name");
        Mockito.when(person.getEmailAddress()).thenReturn(null);
        Mockito.when(person.getCellPhoneNumber()).thenReturn("cell phone number");

        String expectedPresentation = "PERSON PRESENTATION...";
        expectedPresentation += System.lineSeparator() + "first name...first name";
        expectedPresentation += System.lineSeparator() + "last name...last name";
        expectedPresentation += System.lineSeparator() + "cell phone number...cell phone number";

        String presentation = new PersonPresentation(person).present();
        Assert.assertEquals(expectedPresentation, presentation);
    }

    @Test
    public void present4() throws InstantiationException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getMiddlename()).thenReturn("middle name");
        Mockito.when(person.getEmailAddress()).thenReturn("email address");

        String expectedPresentation = "PERSON PRESENTATION...";
        expectedPresentation += System.lineSeparator() + "middle name...middle name";
        expectedPresentation += System.lineSeparator() + "email address...email address";

        String presentation = new PersonPresentation(person).present();
        Assert.assertEquals(expectedPresentation, presentation);
    }

}
