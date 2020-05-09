package ch.supsi.guiframework.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

abstract public class Observable {

    protected PropertyChangeSupport pcs;

    public Observable() {
        this.pcs = new PropertyChangeSupport(this);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return this.pcs;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pcs.removePropertyChangeListener(pcl);
    }

}
