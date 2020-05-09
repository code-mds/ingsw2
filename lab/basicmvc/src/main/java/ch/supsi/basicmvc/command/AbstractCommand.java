package ch.supsi.basicmvc.command;


import ch.supsi.basicmvc.model.AbstractModel;

abstract public class AbstractCommand implements Command {

    protected AbstractModel receiver;

    public AbstractCommand(AbstractModel receiver) {
        this.receiver = receiver;
    }

    public void setReceiver(AbstractModel receiver) {
        this.receiver = receiver;
    }

}
