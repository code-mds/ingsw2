package ch.supsi.basicmvc.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

abstract public class AbstractModel implements DoerHandler, ErrorHandler {

    protected PropertyChangeSupport pcs;

    public AbstractModel() {
        pcs = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pcs.removePropertyChangeListener(pcl);
    }

}
