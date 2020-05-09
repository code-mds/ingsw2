package ch.supsi.personbuilder.builder;


import ch.supsi.personbuilder.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Modifier;

public class AbstractPersonBuilderTest {

    private AbstractPersonBuilder abstractPersonBuilder;

    @Before
    public void beforeEach() {
        abstractPersonBuilder = Mockito.mock(AbstractPersonBuilder.class, Mockito.CALLS_REAL_METHODS);
    }

    @Test
    public void abstract0() throws ClassNotFoundException {
        Class abstractPersonBuilderClass = getClass().getClassLoader().loadClass("ch.supsi.personbuilder.builder.AbstractPersonBuilder");
        Assert.assertTrue(Modifier.isAbstract(abstractPersonBuilderClass.getModifiers()));
    }

    @Test
    public void getFirstname0() {
        Assert.assertNull(abstractPersonBuilder.getFirstname());

        abstractPersonBuilder.firstname = null;
        Assert.assertNull(abstractPersonBuilder.getFirstname());

        abstractPersonBuilder.firstname = "";
        Assert.assertEquals("", abstractPersonBuilder.getFirstname());

        abstractPersonBuilder.firstname = "first name";
        Assert.assertEquals("first name", abstractPersonBuilder.getFirstname());
    }

    @Test
    public void getMiddlename0() {
        Assert.assertNull(abstractPersonBuilder.getMiddlename());

        abstractPersonBuilder.middlename = null;
        Assert.assertNull(abstractPersonBuilder.getMiddlename());

        abstractPersonBuilder.middlename = "";
        Assert.assertEquals("", abstractPersonBuilder.getMiddlename());

        abstractPersonBuilder.middlename = "last name";
        Assert.assertEquals("last name", abstractPersonBuilder.getMiddlename());
    }

    @Test
    public void getLastname0() {
        Assert.assertNull(abstractPersonBuilder.getLastname());

        abstractPersonBuilder.lastname = null;
        Assert.assertNull(abstractPersonBuilder.getLastname());

        abstractPersonBuilder.lastname = "";
        Assert.assertEquals("", abstractPersonBuilder.getLastname());

        abstractPersonBuilder.lastname = "last name";
        Assert.assertEquals("last name", abstractPersonBuilder.getLastname());
    }

    @Test
    public void getEmailAddress0() {
        Assert.assertNull(abstractPersonBuilder.getEmailAddress());

        abstractPersonBuilder.emailAddress = null;
        Assert.assertNull(abstractPersonBuilder.getEmailAddress());

        abstractPersonBuilder.emailAddress = "";
        Assert.assertEquals("", abstractPersonBuilder.getEmailAddress());

        abstractPersonBuilder.emailAddress = "email address";
        Assert.assertEquals("email address", abstractPersonBuilder.getEmailAddress());
    }

    @Test
    public void getCellPhoneNumber0() {
        Assert.assertNull(abstractPersonBuilder.getCellPhoneNumber());

        abstractPersonBuilder.cellPhoneNumber = null;
        Assert.assertNull(abstractPersonBuilder.getCellPhoneNumber());

        abstractPersonBuilder.cellPhoneNumber = "";
        Assert.assertEquals("", abstractPersonBuilder.getCellPhoneNumber());

        abstractPersonBuilder.cellPhoneNumber = "cell phone number";
        Assert.assertEquals("cell phone number", abstractPersonBuilder.getCellPhoneNumber());
    }

    @Test
    public void withPerson0() {
        PersonBuilder builder = abstractPersonBuilder.withPerson(null);
        Assert.assertNotNull(builder);
        Assert.assertNull(abstractPersonBuilder.firstname);
        Assert.assertNull(abstractPersonBuilder.middlename);
        Assert.assertNull(abstractPersonBuilder.lastname);
        Assert.assertNull(abstractPersonBuilder.emailAddress);
        Assert.assertNull(abstractPersonBuilder.cellPhoneNumber);
    }

    @Test
    public void withPerson1() {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getFirstname()).thenReturn(null);
        Mockito.when(person.getMiddlename()).thenReturn(null);
        Mockito.when(person.getLastname()).thenReturn(null);
        Mockito.when(person.getEmailAddress()).thenReturn(null);
        Mockito.when(person.getCellPhoneNumber()).thenReturn(null);

        PersonBuilder builder = abstractPersonBuilder.withPerson(person);
        Assert.assertNotNull(builder);
        Assert.assertNull(abstractPersonBuilder.firstname);
        Assert.assertNull(abstractPersonBuilder.middlename);
        Assert.assertNull(abstractPersonBuilder.lastname);
        Assert.assertNull(abstractPersonBuilder.emailAddress);
        Assert.assertNull(abstractPersonBuilder.cellPhoneNumber);
    }

    @Test
    public void withPerson2() {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getFirstname()).thenReturn("");
        Mockito.when(person.getMiddlename()).thenReturn("");
        Mockito.when(person.getLastname()).thenReturn("");
        Mockito.when(person.getEmailAddress()).thenReturn("");
        Mockito.when(person.getCellPhoneNumber()).thenReturn("");

        PersonBuilder builder = abstractPersonBuilder.withPerson(person);
        Assert.assertNotNull(builder);
        Assert.assertTrue(abstractPersonBuilder.firstname.contentEquals(""));
        Assert.assertTrue(abstractPersonBuilder.middlename.contentEquals(""));
        Assert.assertTrue(abstractPersonBuilder.lastname.contentEquals(""));
        Assert.assertTrue(abstractPersonBuilder.emailAddress.contentEquals(""));
        Assert.assertTrue(abstractPersonBuilder.cellPhoneNumber.contentEquals(""));
    }

    @Test
    public void withFirstname0() {
        PersonBuilder personBuilder;

        personBuilder = abstractPersonBuilder.withFirstname(null);
        Assert.assertNotNull(personBuilder);
        Assert.assertNull(abstractPersonBuilder.firstname);

        personBuilder = abstractPersonBuilder.withFirstname("");
        Assert.assertNotNull(personBuilder);
        Assert.assertTrue(abstractPersonBuilder.firstname.contentEquals(""));

        personBuilder = abstractPersonBuilder.withFirstname("first name");
        Assert.assertNotNull(personBuilder);
        Assert.assertTrue(abstractPersonBuilder.firstname.contentEquals("first name"));
    }

    @Test
    public void withMiddlename0() {
        PersonBuilder personBuilder;

        personBuilder = abstractPersonBuilder.withMiddlename(null);
        Assert.assertNotNull(personBuilder);
        Assert.assertNull(abstractPersonBuilder.middlename);

        personBuilder = abstractPersonBuilder.withMiddlename("");
        Assert.assertNotNull(personBuilder);
        Assert.assertTrue(abstractPersonBuilder.middlename.contentEquals(""));

        personBuilder = abstractPersonBuilder.withMiddlename("middle name");
        Assert.assertNotNull(personBuilder);
        Assert.assertTrue(abstractPersonBuilder.middlename.contentEquals("middle name"));
    }

    @Test
    public void withLastname0() {
        PersonBuilder personBuilder;

        personBuilder = abstractPersonBuilder.withLastname(null);
        Assert.assertNotNull(personBuilder);
        Assert.assertNull(abstractPersonBuilder.lastname);

        personBuilder = abstractPersonBuilder.withLastname("");
        Assert.assertNotNull(personBuilder);
        Assert.assertTrue(abstractPersonBuilder.lastname.contentEquals(""));

        personBuilder = abstractPersonBuilder.withLastname("last name");
        Assert.assertNotNull(personBuilder);
        Assert.assertTrue(abstractPersonBuilder.lastname.contentEquals("last name"));
    }

    @Test
    public void withEmailAddress0() {
        PersonBuilder personBuilder;

        personBuilder = abstractPersonBuilder.withEmailAddress(null);
        Assert.assertNotNull(personBuilder);
        Assert.assertNull(abstractPersonBuilder.emailAddress);

        personBuilder = abstractPersonBuilder.withEmailAddress("");
        Assert.assertNotNull(personBuilder);
        Assert.assertTrue(abstractPersonBuilder.emailAddress.contentEquals(""));

        personBuilder = abstractPersonBuilder.withEmailAddress("email address");
        Assert.assertNotNull(personBuilder);
        Assert.assertTrue(abstractPersonBuilder.emailAddress.contentEquals("email address"));
    }

    @Test
    public void withCellPhoneNumber0() {
        PersonBuilder personBuilder;

        personBuilder = abstractPersonBuilder.withCellPhoneNumber(null);
        Assert.assertNotNull(personBuilder);
        Assert.assertNull(abstractPersonBuilder.cellPhoneNumber);

        personBuilder = abstractPersonBuilder.withCellPhoneNumber("");
        Assert.assertNotNull(personBuilder);
        Assert.assertTrue(abstractPersonBuilder.cellPhoneNumber.contentEquals(""));

        personBuilder = abstractPersonBuilder.withCellPhoneNumber("cell phone number");
        Assert.assertNotNull(personBuilder);
        Assert.assertTrue(abstractPersonBuilder.cellPhoneNumber.contentEquals("cell phone number"));
    }

    @Test
    public void withPerson3() {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getFirstname()).thenReturn("first name");
        Mockito.when(person.getMiddlename()).thenReturn("middle name");
        Mockito.when(person.getLastname()).thenReturn("last name");
        Mockito.when(person.getEmailAddress()).thenReturn("email address");
        Mockito.when(person.getCellPhoneNumber()).thenReturn("cell phone number");

        PersonBuilder builder = abstractPersonBuilder.withPerson(person);
        Assert.assertNotNull(builder);
        Assert.assertTrue(abstractPersonBuilder.firstname.contentEquals("first name"));
        Assert.assertTrue(abstractPersonBuilder.middlename.contentEquals("middle name"));
        Assert.assertTrue(abstractPersonBuilder.lastname.contentEquals("last name"));
        Assert.assertTrue(abstractPersonBuilder.emailAddress.contentEquals("email address"));
        Assert.assertTrue(abstractPersonBuilder.cellPhoneNumber.contentEquals("cell phone number"));
    }

}
