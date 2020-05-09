package ch.supsi.basicmvc.command;


import ch.supsi.basicmvc.model.Model;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class DoNothingCommandTest {

    @Test
    public void constructor0() {
        DoNothingCommand command = new DoNothingCommand(null);
        assertNotNull(command);
        assertTrue(command instanceof Command);
        assertNull(command.receiver);
    }

    @Test
    public void constructor1() {
        Model modelMock = Mockito.mock(Model.class);

        DoNothingCommand command = new DoNothingCommand(modelMock);
        assertNotNull(command);
        assertTrue(command instanceof Command);
        assertNotNull(command.receiver);
        assertEquals(modelMock, command.receiver);
    }

    @Test
    public void execute0() {
        DoNothingCommand command = new DoNothingCommand(null);
        boolean ret = command.execute();
        assertFalse(ret);
    }

    @Test
    public void execute1() {
        Model modelMock = Mockito.mock(Model.class);

        DoNothingCommand command = new DoNothingCommand(modelMock);
        boolean ret = command.execute();
        assertTrue(ret);
    }

}
