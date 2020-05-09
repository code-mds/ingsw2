package ch.supsi.basicmvc.controller;


import ch.supsi.basicmvc.model.Model;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ControllerTest {

    @Test
    public void constructor0() {
        Model mock_model = Mockito.mock(Model.class);

        Controller controller = new Controller(mock_model);
        assertNotNull(controller);
        assertTrue(controller instanceof AbstractController);
    }

    @Test
    public void congtrolDoTest0() {
        Model mock_model = Mockito.mock(Model.class);

        Controller controller = new Controller(mock_model);
        assertNotNull(controller);
        assertTrue(controller instanceof AbstractController);

        controller.controlDo();
        Mockito.verify(mock_model, Mockito.times(1)).doSomething();
        Mockito.verify(mock_model, Mockito.times(1)).doSomethingElse();
    }

    @Test
    public void controlHandleError0() {
        Model mock_model = Mockito.mock(Model.class);

        Controller controller = new Controller(mock_model);
        assertNotNull(controller);
        assertTrue(controller instanceof AbstractController);

        controller.controlHandleError();
        Mockito.verify(mock_model, Mockito.times(1)).handleError();
    }

}
