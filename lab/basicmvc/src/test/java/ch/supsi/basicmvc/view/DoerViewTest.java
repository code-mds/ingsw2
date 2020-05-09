package ch.supsi.basicmvc.view;


import ch.supsi.basicmvc.event.DoneNothingEvent;
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
        ByteArrayOutputStream myErr = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));

        DoerView view = new DoerView(null);
        view.propertyChange(null);

        assertEquals("", myOut.toString());
        assertEquals("", myErr.toString());

        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void propertyChange1() {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        ByteArrayOutputStream myErr = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));

        PropertyChangeEvent eventMock = Mockito.mock(HandledErrorEvent.class);

        DoerView view = new DoerView(null);
        view.propertyChange(eventMock);

        assertEquals("", myOut.toString());
        assertEquals("", myErr.toString());

        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void propertyChange2() {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        ByteArrayOutputStream myErr = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));

        PropertyChangeEvent eventMock = Mockito.mock(DoneSomethingEvent.class);

        DoerView view = new DoerView(null);
        view.propertyChange(eventMock);

        assertEquals("DoerView...something was done!\n", myOut.toString());
        assertEquals("", myErr.toString());

        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void propertyChange3() {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        ByteArrayOutputStream myErr = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));

        PropertyChangeEvent eventMock = Mockito.mock(DoneNothingEvent.class);

        DoerView view = new DoerView(null);
        view.propertyChange(eventMock);

        assertEquals("DoerView...nothing was done!" + System.lineSeparator(), myOut.toString());
        assertEquals("", myErr.toString());

        System.setOut(System.out);
        System.setErr(System.err);
    }

}
