package ch.supsi.guiframework.command;

import ch.supsi.guiframework.model.OkHandler;

public class OkCommand<T extends OkHandler> extends AbstractCommand implements Command {

    protected OkCommand(T handler) {
        super(handler);
    }

    public static OkCommand create(OkHandler handler) throws InstantiationException {
        if (handler == null) {
            throw new InstantiationException("command handler cannot be null!");
        }

        OkCommand command = new OkCommand(handler);
        return command;
    }

    @Override
    public void execute() throws NoSuchFieldException {
        if (handler == null) {
            throw new NoSuchFieldException("command handler is null!");
        }

        ((OkHandler)handler).ok();
    }

}
