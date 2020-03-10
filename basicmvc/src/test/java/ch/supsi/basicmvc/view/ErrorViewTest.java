package ch.supsi.basicmvc.view;


import ch.supsi.basicmvc.event.DoneSomethingEvent;
import ch.supsi.basicmvc.event.HandledErrorEvent;
import ch.supsi.basicmvc.model.Model;
import org.junit.Test;
import org.mockito.Mockito;

import java.beans.PropertyChangeEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ErrorViewTest {

    @Test
    public void constructor0() {
        ErrorView view = new ErrorView(null);
        assertNotNull(view);
        assertTrue(view instanceof AbstractView);
        assertNull(view.model);
    }

    @Test
    public void constructor1() {
        Model modelMock = Mockito.mock(Model.class);

        ErrorView view = new ErrorView(modelMock);
        assertNotNull(view);
        assertTrue(view instanceof AbstractView);
        assertNotNull(view.model);
        assertEquals(modelMock, view.model);
    }

    @Test
    public void propertyChange0() {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));

        ErrorView view = new ErrorView(null);
        view.propertyChange(null);

        assertEquals("", myOut.toString());

        System.setOut(System.out);
    }

    @Test
    public void propertyChange1() {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));

        PropertyChangeEvent eventMock = Mockito.mock(DoneSomethingEvent.class);

        ErrorView view = new ErrorView(null);
        view.propertyChange(eventMock);

        assertEquals("", myOut.toString());

        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void propertyChange2() {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));

        PropertyChangeEvent eventMock = Mockito.mock(HandledErrorEvent.class);

        ErrorView view = new ErrorView(null);
        view.propertyChange(eventMock);

        assertEquals("ErrorView...an error was handled!" + System.lineSeparator(), myOut.toString());

        System.setOut(System.out);
    }

}
