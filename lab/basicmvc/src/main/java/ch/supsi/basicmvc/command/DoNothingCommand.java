package ch.supsi.basicmvc.command;


import ch.supsi.basicmvc.model.AbstractModel;

public class DoNothingCommand extends AbstractCommand {

    public DoNothingCommand(AbstractModel receiver) {
        super(receiver);
    }

    @Override
    public boolean execute() {
        if (receiver == null) {
            return false;
        }

        receiver.doNothing();

        return true;
    }

}
