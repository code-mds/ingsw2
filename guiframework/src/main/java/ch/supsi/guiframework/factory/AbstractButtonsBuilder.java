package ch.supsi.guiframework.factory;

import ch.supsi.guiframework.command.Command;
import ch.supsi.guiframework.component.MyButton;
import javafx.scene.image.Image;

abstract public class AbstractButtonsBuilder implements ButtonsBuilder {

    protected String id;

    protected String text;

    protected String tooltip;

    protected Image icon;

    protected Command command;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public ButtonsBuilder withId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public ButtonsBuilder withText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public String getTooltip() {
        return tooltip;
    }

    @Override
    public ButtonsBuilder withTooltip(String tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    @Override
    public Image getIcon() {
        return icon;
    }

    @Override
    public ButtonsBuilder withIcon(Image icon) {
        this.icon = icon;
        return this;
    }

    @Override
    public Command getCommand() {
        return command;
    }

    @Override
    public ButtonsBuilder withCommand(Command command) {
        this.command = command;
        return this;
    }

    @Override
    public ButtonsBuilder withButton(MyButton button) {
        if (button != null) {
            this.id = button.getId();
            this.text = button.getText();
            this.tooltip = button.getTooltip();
            this.icon = button.getIcon();
            this.command = button.getCommand();
        }

        return this;
    }

}
