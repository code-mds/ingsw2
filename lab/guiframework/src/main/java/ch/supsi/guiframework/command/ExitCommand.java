package ch.supsi.guiframework.command;

import ch.supsi.guiframework.model.ExitHandler;

public class ExitCommand<T extends ExitHandler> extends AbstractCommand implements Command {

    protected ExitCommand(T handler) {
        super(handler);
    }

    public static ExitCommand create(ExitHandler handler) throws InstantiationException {
        if (handler == null) {
            throw new InstantiationException("command handler cannot be null!");
        }

        ExitCommand command = new ExitCommand(handler);
        return command;
    }

    @Override
    public void execute() throws NoSuchFieldException {
        if (handler == null) {
            throw new NoSuchFieldException("command handler is null!");
        }

        ((ExitHandler)handler).exit();
    }

}
