package ch.supsi.guiframework.factory;


import ch.supsi.guiframework.command.Command;
import ch.supsi.guiframework.component.MyButton;
import javafx.scene.image.Image;

public interface ButtonsBuilder {

    String getId();

    ButtonsBuilder withId(String id);

    String getText();

    ButtonsBuilder withText(String text);

    String getTooltip();

    ButtonsBuilder withTooltip(String tooltip);

    Image getIcon();

    ButtonsBuilder withIcon(Image icon);

    Command getCommand();

    ButtonsBuilder withCommand(Command command);

    ButtonsBuilder withButton(MyButton button);

    MyButton build(ButtonsBuilder builder) throws InstantiationException;

}
