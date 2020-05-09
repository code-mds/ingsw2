package ch.supsi.statedemo.event;


import ch.supsi.guiframework.event.AbstractEvent;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class StateChangedEventTest {

    @Test
    public void constructor0() {
        Object mockObject = Mockito.mock(Object.class);

        StateChangedEvent event = new StateChangedEvent(mockObject);
        Assert.assertNotNull(event);
        Assert.assertTrue(event instanceof AbstractEvent);
    }

}
