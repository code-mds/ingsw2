package ch.supsi.basicmvc.view;

import ch.supsi.basicmvc.event.DoneNothingEvent;
import ch.supsi.basicmvc.event.DoneSomethingEvent;
import ch.supsi.basicmvc.model.Model;

import java.beans.PropertyChangeEvent;


public class DoerView extends AbstractView {

    public DoerView(Model model) {
        super(model);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event instanceof DoneSomethingEvent) {
            System.out.println(this.getClass().getSimpleName() + "...something was done!");

        } else if (event instanceof DoneNothingEvent) {
            System.out.println(this.getClass().getSimpleName() + "...nothing was done!");

        } else {
            // any other event is not for me ... so I discard it and do nothing.

        }
    }

}
