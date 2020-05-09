package ch.supsi.basicmvc.model;

import ch.supsi.basicmvc.event.DoSomethingElseEvent;
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
        // do something ...
        System.out.println("I am the model and I am doing something...");

        // finally notify listeners something was done
        pcs.firePropertyChange(new DoneSomethingEvent(this));
    }

    @Override
    public void doSomethingElse() {
        // do something else ...
        System.out.println("I am the model and I am doing something else...");

        // finally notify listeners something else was done
        pcs.firePropertyChange(new DoSomethingElseEvent(this));
    }

    @Override
    public void handleError() {
        // handle error ...
        System.out.println("I am the model and I am handling an error...");

        // finally notify listeners an error was handled
        pcs.firePropertyChange(new HandledErrorEvent(this));
    }

}
