package ch.supsi.basicmvc;

import ch.supsi.basicmvc.controller.Controller;
import ch.supsi.basicmvc.model.Model;
import ch.supsi.basicmvc.view.DoerView;
import ch.supsi.basicmvc.view.ErrorView;

import java.util.Random;

public class Main {

    private static int NUMBER_OF_COMMANDS = 11;

    public static void main(String args[]) {
        // MVC scaffolding
        Model model = Model.instance();
        DoerView doerView = new DoerView(model);
        ErrorView errorView = new ErrorView(model);
        Controller controller = new Controller(model);

        // set views as model observers
        // i.e., views will observe the model and will react when notified
        model.addPropertyChangeListener(doerView);
        model.addPropertyChangeListener(errorView);

        // pseudo randomizer
        Random random = new Random();

        // fire a few commands pseudo randomly...
        for (int i=0 ; i < NUMBER_OF_COMMANDS ; i++) {
            System.out.println("ITERATION NUMBER..." + i);

            if (random.nextBoolean()) {
                // true: do
                controller.controlDo();
            } else {
                // false: error
                controller.controlHandleError();
            }
        }
    }

}
