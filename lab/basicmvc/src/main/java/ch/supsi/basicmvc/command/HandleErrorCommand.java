package ch.supsi.basicmvc.command;


import ch.supsi.basicmvc.model.AbstractModel;

public class HandleErrorCommand extends AbstractCommand {

    public HandleErrorCommand(AbstractModel receiver) {
        super(receiver);
    }

    @Override
    public boolean execute() {
        if (receiver == null) {
            return false;
        }

        receiver.handleError();

        return true;
    }

}
