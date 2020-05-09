package ch.supsi.basicmvc.model;

import ch.supsi.basicmvc.event.DoneNothingEvent;
import ch.supsi.basicmvc.event.DoneSomethingEvent;
import ch.supsi.basicmvc.event.HandledErrorEvent;


public class Model extends AbstractModel {

    private static Model model;

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
    public void doSomething() {
        // do something here ...

        // finally notify listeners something was done
        pcs.firePropertyChange(new DoneSomethingEvent(this));
    }

    @Override
    public void doSomethingElse() {

    }

    @Override
    public void doNothing() {
        // do nothing ...

        // finally notify listeners nothing was done
        pcs.firePropertyChange(new DoneNothingEvent(this));
    }

    @Override
    public void handleError() {
        // handle error ...

        // finally notify listeners an error was handled
        pcs.firePropertyChange(new HandledErrorEvent(this));
    }

}
