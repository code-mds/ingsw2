package ch.supsi.basicmvc.view;


import ch.supsi.basicmvc.event.DoSomethingElseEvent;
import ch.supsi.basicmvc.event.DoneSomethingEvent;
import ch.supsi.basicmvc.event.HandledErrorEvent;
import ch.supsi.basicmvc.model.Model;
import org.junit.Test;
import org.mockito.Mockito;

import java.beans.PropertyChangeEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DoerViewTest {

    @Test
    public void constructor0() {
        DoerView view = new DoerView(null);
        assertNotNull(view);
        assertTrue(view instanceof AbstractView);
        assertNull(view.model);
    }

    @Test
    public void constructor1() {
        Model modelMock = Mockito.mock(Model.class);

        DoerView view = new DoerView(modelMock);
        assertNotNull(view);
        assertTrue(view instanceof AbstractView);
        assertNotNull(view.model);
        assertEquals(modelMock, view.model);
    }

    @Test
    public void propertyChange0() {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        DoerView view = new DoerView(null);
        view.propertyChange(null);

        assertEquals("", myOut.toString());

        System.setOut(System.out);
    }

    @Test
    public void propertyChange1() {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        PropertyChangeEvent eventMock = Mockito.mock(HandledErrorEvent.class);

        DoerView view = new DoerView(null);
        view.propertyChange(eventMock);

        assertEquals("", myOut.toString());

        System.setOut(System.out);
    }

    @Test
    public void propertyChange2() {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        PropertyChangeEvent eventMock = Mockito.mock(DoneSomethingEvent.class);

        DoerView view = new DoerView(null);
        view.propertyChange(eventMock);

        assertEquals("DoerView...something was done!" + System.lineSeparator(), myOut.toString());

        System.setOut(System.out);
    }

    @Test
    public void propertyChange3() {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        PropertyChangeEvent eventMock = Mockito.mock(DoSomethingElseEvent.class);

        DoerView view = new DoerView(null);
        view.propertyChange(eventMock);

        assertEquals("DoerView...something else was done!" + System.lineSeparator(), myOut.toString());

        System.setOut(System.out);
    }

}
