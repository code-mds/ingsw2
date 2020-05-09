package ch.supsi.basicmvc;

import ch.supsi.basicmvc.command.Command;
import ch.supsi.basicmvc.command.DoNothingCommand;
import ch.supsi.basicmvc.command.DoSomethingCommand;
import ch.supsi.basicmvc.command.HandleErrorCommand;
import ch.supsi.basicmvc.controller.DoController;
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
        DoController controller = new DoController(model);

        // set views as model observers
        // i.e., views will observe the model and will react when notified
        model.addPropertyChangeListener(doerView);
        model.addPropertyChangeListener(errorView);

        // fire a few commands...
        Random random = new Random();
        Command command = null;
        for (int i=0 ; i < NUMBER_OF_COMMANDS ; i++) {
            // get a pseudo random number between 0 and 2
            int n = random.nextInt(3);

            // randomly create a do-something, a do-nothing, or a something-wrong command
            switch (n) {
                case 0:
                    command = new DoSomethingCommand(model);
                    break;
                case 1:
                    command = new DoNothingCommand(model);
                    break;
                case 2:
                    command = new HandleErrorCommand(model);
                    break;
            }

            // activate controller with the command
            controller.controlDo(command);
        }
    }

}
