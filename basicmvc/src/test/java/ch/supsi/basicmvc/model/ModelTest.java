package ch.supsi.basicmvc.model;


import ch.supsi.basicmvc.event.DoSomethingElseEvent;
import ch.supsi.basicmvc.event.DoneSomethingEvent;
import ch.supsi.basicmvc.event.HandledErrorEvent;
import org.junit.Test;
import org.mockito.Mockito;

import java.beans.PropertyChangeSupport;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ModelTest {

    @Test
    public void constructor0() {
        Model model = new Model();
        assertNotNull(model);
        assertTrue(model instanceof AbstractModel);
        assertNotNull(model.pcs);
        assertTrue(model.pcs instanceof PropertyChangeSupport);
        assertEquals(0, model.pcs.getPropertyChangeListeners().length);
    }

    @Test
    public void instance0() {
        Model model1 = Model.instance();
        assertNotNull(model1);
        assertTrue(model1 instanceof AbstractModel);
        assertNotNull(model1.pcs);
        assertTrue(model1.pcs instanceof PropertyChangeSupport);
        assertEquals(0, model1.pcs.getPropertyChangeListeners().length);

        Model model2 = Model.instance();
        assertNotNull(model2);
        assertTrue(model2 instanceof AbstractModel);
        assertNotNull(model2.pcs);
        assertTrue(model2.pcs instanceof PropertyChangeSupport);
        assertEquals(0, model2.pcs.getPropertyChangeListeners().length);

        assertEquals(model1, model2);
    }

    @Test
    public void doSomethingTest0() {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        Model model = new Model();
        PropertyChangeSupport pcsMock = Mockito.mock(PropertyChangeSupport.class);
        model.pcs = pcsMock;

        model.doSomething();
        assertEquals("I am the model and I am doing something..." + System.lineSeparator(), myOut.toString());
        Mockito.verify(model.pcs, Mockito.times(1)).firePropertyChange(Mockito.any(DoneSomethingEvent.class));

        System.setOut(System.out);
    }

    @Test
    public void doSomethingElseTest0() {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        Model model = new Model();
        PropertyChangeSupport pcsMock = Mockito.mock(PropertyChangeSupport.class);
        model.pcs = pcsMock;

        model.doSomethingElse();
        assertEquals("I am the model and I am doing something else..." + System.lineSeparator(), myOut.toString());
        Mockito.verify(model.pcs, Mockito.times(1)).firePropertyChange(Mockito.any(DoSomethingElseEvent.class));

        System.setOut(System.out);
    }

    @Test
    public void handleErrorTest0() {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        Model model = new Model();
        PropertyChangeSupport pcsMock = Mockito.mock(PropertyChangeSupport.class);
        model.pcs = pcsMock;

        model.handleError();
        assertEquals("I am the model and I am handling an error..." + System.lineSeparator(), myOut.toString());
        Mockito.verify(model.pcs, Mockito.times(1)).firePropertyChange(Mockito.any(HandledErrorEvent.class));

        System.setOut(System.out);
    }

}
