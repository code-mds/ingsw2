package ch.supsi.guiframework.component;

import ch.supsi.guiframework.model.Handler;
import ch.supsi.guiframework.model.Observable;

import java.beans.PropertyChangeListener;


abstract public class MyAbstractView<T extends Handler> implements PropertyChangeListener {

    protected Observable model;

    public MyAbstractView(Observable model) {
        this.model = model;
    }

}
