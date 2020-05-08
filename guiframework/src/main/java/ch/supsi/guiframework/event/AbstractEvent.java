package ch.supsi.guiframework.event;


import java.beans.PropertyChangeEvent;

public class AbstractEvent extends PropertyChangeEvent  {

    public AbstractEvent(Object source) {
        this(source, null, null, null);
    }

    public AbstractEvent(Object source, String propertyName, Object oldValue, Object newValue) {
        super(source, propertyName, oldValue, newValue);
    }

}
