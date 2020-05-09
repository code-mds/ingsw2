package ch.supsi.statedemo.event;


import ch.supsi.guiframework.event.AbstractEvent;

public class StateChangedEvent extends AbstractEvent {

    public StateChangedEvent(Object source) {
        super(source);
    }

}
