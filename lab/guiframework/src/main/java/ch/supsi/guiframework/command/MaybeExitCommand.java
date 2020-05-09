package ch.supsi.guiframework.command;

import ch.supsi.guiframework.model.ExitHandler;

public class MaybeExitCommand<T extends ExitHandler> extends AbstractCommand implements Command {

    protected MaybeExitCommand(T handler) {
        super(handler);
    }

    public static MaybeExitCommand create(ExitHandler handler) throws InstantiationException {
        if (handler == null) {
            throw new InstantiationException("command handler cannot be null!");
        }

        MaybeExitCommand command = new MaybeExitCommand(handler);
        return command;
    }

    @Override
    public void execute() throws NoSuchFieldException {
        if (handler == null) {
            throw new NoSuchFieldException("command handler is null!");
        }

        ((ExitHandler)handler).controlExit();
    }

}
