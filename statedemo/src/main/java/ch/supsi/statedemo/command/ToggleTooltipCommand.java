package ch.supsi.statedemo.command;


import ch.supsi.guiframework.command.AbstractCommand;
import ch.supsi.guiframework.command.Command;
import ch.supsi.guiframework.component.MyButton;
import ch.supsi.statedemo.model.ButtonStateHandler;

import java.util.ArrayList;

public class ToggleTooltipCommand<T extends ButtonStateHandler> extends AbstractCommand implements Command {

    protected ToggleTooltipCommand(T handler) {
        super(handler);
    }

    public static ToggleTooltipCommand create(ButtonStateHandler handler) throws InstantiationException {
        if (handler == null) {
            throw new InstantiationException("command receiver cannot be null!");
        }

        ToggleTooltipCommand command = new ToggleTooltipCommand(handler);

        return command;
    }

    @Override
    public void execute() throws NoSuchFieldException {
        if (handler == null) {
            throw new NoSuchFieldException("command receiver is null!");
        }

        ((ButtonStateHandler)handler).toggleTooltip();
    }

}
