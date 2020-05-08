package ch.supsi.statedemo.model;

import ch.supsi.guiframework.model.DataHandler;
import ch.supsi.guiframework.model.Observable;

import java.util.Random;


public class Model extends Observable implements DataHandler {

    protected static Model model;

    protected boolean changed;

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

    @Override
    public void setChanged(boolean changed) {
        this.changed = changed;
    }

}
