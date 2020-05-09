package ch.supsi.guiframework.command;

import ch.supsi.guiframework.model.ApplyHandler;

public class ApplyCommand<T extends ApplyHandler> extends AbstractCommand implements Command {

    protected ApplyCommand(T handler) {
        super(handler);
    }

    public static ApplyCommand create(ApplyHandler handler) throws InstantiationException{
        if (handler == null) {
            throw new InstantiationException("command handler cannot be null!");
        }

        ApplyCommand command = new ApplyCommand(handler);
        return command;
    }

    @Override
    public void execute() throws NoSuchFieldException {
        if (handler == null) {
            throw new NoSuchFieldException("command handler is null!");
        }

        ((ApplyHandler)handler).apply();
    }

}
