package ch.supsi.e2etestsdemo.command;


import ch.supsi.guiframework.command.AbstractCommand;
import ch.supsi.guiframework.command.Command;
import ch.supsi.e2etestsdemo.model.ButtonStateHandler;

public class ToggleIconCommand<T extends ButtonStateHandler> extends AbstractCommand implements Command {

    protected ToggleIconCommand(T handler) {
        super(handler);
    }

    public static ToggleIconCommand create(ButtonStateHandler handler) throws InstantiationException {
        if (handler == null) {
            throw new InstantiationException("command receiver cannot be null!");
        }

        ToggleIconCommand command = new ToggleIconCommand(handler);

        return command;
    }

    @Override
    public void execute() throws NoSuchFieldException {
        if (handler == null) {
            throw new NoSuchFieldException("command receiver is null!");
        }

        ((ButtonStateHandler)handler).toggleIcon();
    }

}
