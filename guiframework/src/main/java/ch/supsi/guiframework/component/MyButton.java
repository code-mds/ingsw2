package ch.supsi.guiframework.component;

import ch.supsi.guiframework.command.Command;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MyButton {

    protected Button button;

    protected String text;

    protected String tooltip;

    protected Image icon;

    protected Command command;

    public MyButton() {
        // set actual framework button component
        this.setActualComponent(new Button());

        // add action handler to execute command when component is pressed
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    if (command != null) {
                        command.execute();
                    }

                } catch (NoSuchFieldException noSuchFieldException) {
                    noSuchFieldException.printStackTrace();
                }
            }
        });
    }

    public Button getActualComponent() {
        return button;
    }

    protected void setActualComponent(Button button) {
        this.button = button;
    }

    // TODO
    public Button getActualComponentById(String id) {
        return null;
    }
    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public String getId() {
        return button.getId();
    }

    public void setId(String id) {
        button.setId(id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;

        button.setText(text);
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;

        if (button.getTooltip() == null) {
            button.setTooltip(new Tooltip(tooltip));
        } else {
            button.getTooltip().setText(tooltip);
        }
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;

        if (button.getGraphic() == null) {
            button.setGraphic(new ImageView(icon));
        } else {
            ((ImageView)button.getGraphic()).setImage(icon);
        }
    }

    public void enable() {
        button.setDisable(false);
    }

    public void disable() {
        button.setDisable(true);
    }

}
