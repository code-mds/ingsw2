package ch.supsi.statedemo.view;


import ch.supsi.guiframework.component.MyConsoleView;
import ch.supsi.guiframework.event.ModelHasChangedEvent;
import ch.supsi.guiframework.model.Observable;
import ch.supsi.statedemo.event.StateChangedEvent;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TextArea;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.beans.PropertyChangeEvent;

public class ConsoleViewTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @BeforeClass
    public static void beforeClass() {
        // WORKAROUND !!!
        // initialize javafx toolkit
        JFXPanel fxPanel = new JFXPanel();
    }

    @Test
    public void staticProperties0() {
        Assert.assertEquals(11, ConsoleView.DEFAULT_TEXT_ROWS);
    }

    @Test
    public void constructor0() {
        ConsoleView console = new ConsoleView(null);
        Assert.assertNotNull(console);
        Assert.assertNull(console.getModel());
    }

    @Test
    public void constructor1() {
        Observable modelMock = Mockito.mock(Observable.class);

        ConsoleView console = new ConsoleView(modelMock);
        Assert.assertNotNull(console);
        Assert.assertNotNull(console.getModel());
    }

    @Test
    public void create0() throws InstantiationException {
        exceptionRule.expect(InstantiationException.class);
        exceptionRule.expectMessage("view model cannot be null!");

        ConsoleView.create(null);
    }

    @Test
    public void create1() throws InstantiationException {
        Observable modelMock = Mockito.mock(Observable.class);

        ConsoleView console = ConsoleView.create(modelMock);
        Assert.assertNotNull(console);
        Assert.assertTrue(console instanceof MyConsoleView);
        Assert.assertNotNull(console.getModel());
        Assert.assertEquals(modelMock, console.getModel());
        Assert.assertEquals("console", console.getId());
        Assert.assertFalse(console.isEditable());
        Assert.assertEquals(ConsoleView.DEFAULT_TEXT_ROWS, console.getPrefRowCount());
    }

    @Test
    public void propertyChange0() throws InstantiationException {
        // ModelHasChangedEvent

        Observable modelMock = Mockito.mock(Observable.class);
        ModelHasChangedEvent eventMock = Mockito.mock(ModelHasChangedEvent.class);
        TextArea consoleMock = Mockito.mock(TextArea.class);

        ConsoleView console = ConsoleView.create(modelMock);

        ConsoleView consoleSpy = Mockito.spy(console);
        Mockito.when(consoleSpy.getActualComponent()).thenReturn(consoleMock);

        consoleSpy.propertyChange(eventMock);

        Mockito.verify(consoleMock, Mockito.times(1)).appendText("model has changed since last time we asked!\n");
    }

    @Test
    public void propertyChange1() throws InstantiationException {
        // StateChangedEvent

        Observable modelMock = Mockito.mock(Observable.class);
        StateChangedEvent eventMock = Mockito.mock(StateChangedEvent.class);
        TextArea consoleMock = Mockito.mock(TextArea.class);

        ConsoleView console = ConsoleView.create(modelMock);

        ConsoleView consoleSpy = Mockito.spy(console);
        Mockito.when(consoleSpy.getActualComponent()).thenReturn(consoleMock);

        consoleSpy.propertyChange(eventMock);

        Mockito.verify(consoleMock, Mockito.times(1)).appendText("component changed state...xxx\n");
    }

    @Test
    public void propertyChange3() throws InstantiationException {
        // some other event

        Observable modelMock = Mockito.mock(Observable.class);
        PropertyChangeEvent eventMock = Mockito.mock(PropertyChangeEvent.class);
        TextArea consoleMock = Mockito.mock(TextArea.class);

        ConsoleView console = ConsoleView.create(modelMock);

        ConsoleView consoleSpy = Mockito.spy(console);
        Mockito.when(consoleSpy.getActualComponent()).thenReturn(consoleMock);

        consoleSpy.propertyChange(eventMock);

        Mockito.verify(consoleMock, Mockito.times(1)).appendText("this event is not for me!\n");
    }
    
}
