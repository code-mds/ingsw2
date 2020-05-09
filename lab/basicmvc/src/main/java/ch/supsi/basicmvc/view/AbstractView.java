package ch.supsi.basicmvc.view;

import ch.supsi.basicmvc.model.AbstractModel;

import java.beans.PropertyChangeListener;


abstract public class AbstractView implements PropertyChangeListener {

    protected AbstractModel model;

    public AbstractView(AbstractModel model) {
        this.model = model;
    }

}
