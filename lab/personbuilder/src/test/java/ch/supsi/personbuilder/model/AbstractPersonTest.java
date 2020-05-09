package ch.supsi.personbuilder.model;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Modifier;

public class AbstractPersonTest {
    
    private AbstractPerson abstractPerson;
    
    @Before
    public void beforeEach() {
        abstractPerson = Mockito.mock(AbstractPerson.class, Mockito.CALLS_REAL_METHODS);
    }

    @Test
    public void abstract0() throws ClassNotFoundException {
        Class abstractPersonClass = getClass().getClassLoader().loadClass("ch.supsi.personbuilder.model.AbstractPerson");
        Assert.assertTrue(Modifier.isAbstract(abstractPersonClass.getModifiers()));
    }

    @Test
    public void firstname0() {
        Assert.assertNull(abstractPerson.getFirstname());

        abstractPerson.firstname = null;
        Assert.assertNull(abstractPerson.getFirstname());

        abstractPerson.firstname = "";
        Assert.assertEquals("", abstractPerson.getFirstname());

        abstractPerson.firstname = "first name";
        Assert.assertEquals("first name", abstractPerson.getFirstname());
    }

    @Test
    public void middlename0() {
        Assert.assertNull(abstractPerson.getMiddlename());

        abstractPerson.middlename = null;
        Assert.assertNull(abstractPerson.getMiddlename());

        abstractPerson.middlename = "";
        Assert.assertEquals("", abstractPerson.getMiddlename());

        abstractPerson.middlename = "last name";
        Assert.assertEquals("last name", abstractPerson.getMiddlename());
    }

    @Test
    public void lastname0() {
        Assert.assertNull(abstractPerson.getLastname());

        abstractPerson.lastname = null;
        Assert.assertNull(abstractPerson.getLastname());

        abstractPerson.lastname = "";
        Assert.assertEquals("", abstractPerson.getLastname());

        abstractPerson.lastname = "last name";
        Assert.assertEquals("last name", abstractPerson.getLastname());
    }

    @Test
    public void emailAddress0() {
        Assert.assertNull(abstractPerson.getEmailAddress());

        abstractPerson.emailAddress = null;
        Assert.assertNull(abstractPerson.getEmailAddress());

        abstractPerson.emailAddress = "";
        Assert.assertEquals("", abstractPerson.getEmailAddress());

        abstractPerson.emailAddress = "email address";
        Assert.assertEquals("email address", abstractPerson.getEmailAddress());
    }

    @Test
    public void emailCellPhoneNumber0() {
        Assert.assertNull(abstractPerson.getCellPhoneNumber());

        abstractPerson.cellPhoneNumber = null;
        Assert.assertNull(abstractPerson.getCellPhoneNumber());

        abstractPerson.cellPhoneNumber = "";
        Assert.assertEquals("", abstractPerson.getCellPhoneNumber());

        abstractPerson.cellPhoneNumber = "cell phone number";
        Assert.assertEquals("cell phone number", abstractPerson.getCellPhoneNumber());
    }

}
