package ch.supsi.basicmvc.event;


import ch.supsi.basicmvc.model.Model;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class DoneNothingEventTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor0() {
        new DoneNothingEvent(null);
    }

    @Test
    public void constructor1() {
        Model modelMock = Mockito.mock(Model.class);

        DoneNothingEvent event = new DoneNothingEvent(modelMock);
        assertNotNull(event);
        assertTrue(event instanceof AbstractEvent);
        assertNotNull(event.getSource());
        assertEquals(modelMock, event.getSource());
    }

}
