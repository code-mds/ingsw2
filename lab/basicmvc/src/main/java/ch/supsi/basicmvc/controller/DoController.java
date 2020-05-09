package ch.supsi.basicmvc.controller;

import ch.supsi.basicmvc.command.Command;
import ch.supsi.basicmvc.model.AbstractModel;


public class DoController extends AbstractController {

    public DoController(AbstractModel model) {
        super(model);
    }

    public boolean controlDo(Command command) {
        if (command == null) {
            return false;
        }

        command.execute();

        return true;
    }

}
