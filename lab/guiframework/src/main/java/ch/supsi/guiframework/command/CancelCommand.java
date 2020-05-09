package ch.supsi.guiframework.command;

import ch.supsi.guiframework.model.CancelHandler;

public class CancelCommand<T extends CancelHandler> extends AbstractCommand implements Command {

    protected CancelCommand(T handler) {
        super(handler);
    }

    public static CancelCommand create(CancelHandler handler) throws InstantiationException {
        if (handler == null) {
            throw new InstantiationException("command handler cannot be null!");
        }

        CancelCommand command = new CancelCommand(handler);
        return command;
    }

    @Override
    public void execute() throws NoSuchFieldException {
        if (handler == null) {
            throw new NoSuchFieldException("command handler is null!");
        }

        ((CancelHandler)handler).cancel();
    }

}
