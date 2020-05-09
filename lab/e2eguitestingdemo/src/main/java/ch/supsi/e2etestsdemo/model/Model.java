package ch.supsi.e2etestsdemo.model;

import ch.supsi.guiframework.event.ModelHasChangedEvent;
import ch.supsi.guiframework.model.DataHandler;
import ch.supsi.guiframework.model.Observable;


public class Model extends Observable implements DataHandler {

    protected static Model model;

    private boolean changed;

    protected Model() {
        super();
    }

    // singleton
    public static Model instance() {
        if (model == null) {
            model = new Model();
        }

        return model;
    }

    @Override
    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
        getPropertyChangeSupport().firePropertyChange(new ModelHasChangedEvent(this));
    }

}
