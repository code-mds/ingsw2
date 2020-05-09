package ch.supsi.basicmvc.command;


import ch.supsi.basicmvc.model.AbstractModel;

public class DoSomethingCommand extends AbstractCommand {

    public DoSomethingCommand(AbstractModel receiver) {
        super(receiver);
    }

    @Override
    public boolean execute() {
        if (receiver == null) {
            return false;
        }

        receiver.doSomething();

        return true;
    }

}
