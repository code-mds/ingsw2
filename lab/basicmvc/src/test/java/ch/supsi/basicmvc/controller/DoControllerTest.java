package ch.supsi.basicmvc.controller;


import ch.supsi.basicmvc.command.Command;
import ch.supsi.basicmvc.model.Model;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class DoControllerTest {

    @Test
    public void constructor0() {
        DoController controller = new DoController(null);
        assertNotNull(controller);
        assertTrue(controller instanceof AbstractController);
        assertNull(controller.model);
    }

    @Test
    public void constructor1() {
        Model modelMock = Mockito.mock(Model.class);

        DoController controller = new DoController(modelMock);
        assertNotNull(controller);
        assertTrue(controller instanceof AbstractController);
        assertNotNull(controller.model);
        assertEquals(modelMock, controller.model);
    }

    @Test
    public void controlDo0() {
        DoController controller = new DoController(null);
        boolean ret = controller.controlDo(null);
        assertFalse(ret);
    }

    @Test
    public void controlDo1() {
        Command commandMock = Mockito.mock(Command.class);

        DoController controller = new DoController(null);
        boolean ret = controller.controlDo(commandMock);
        assertTrue(ret);
    }

}
