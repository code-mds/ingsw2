package ch.supsi.basicmvc.view;

import ch.supsi.basicmvc.event.HandledErrorEvent;
import ch.supsi.basicmvc.model.Model;

import java.beans.PropertyChangeEvent;


public class ErrorView extends AbstractView {

    public ErrorView(Model model) {
        super(model);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event instanceof HandledErrorEvent) {
            System.err.println(this.getClass().getSimpleName() + "...an error was handled!");

        } else {
            // any other event is not for me ... so I discard it and do nothing.

        }
    }

}
