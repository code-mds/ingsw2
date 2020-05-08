package ch.supsi.guiframework.component;

import ch.supsi.guiframework.command.Command;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class MyMenuItem {

    protected MenuItem menuItem;

    protected Command command;

    public MyMenuItem() {
        // set actual framework menu item component
        this.setActualComponent(new MenuItem());

        // add action handler to execute command when component is pressed
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (command != null) {
                    try {
                        if (command != null) {
                            command.execute();
                        }

                    } catch (NoSuchFieldException noSuchFieldException) {
                        noSuchFieldException.printStackTrace();
                    }
                }
            }
        });
    }

    public MenuItem getActualComponent() {
        return menuItem;
    }

    protected void setActualComponent(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    // TODO
    public MenuItem getActualComponentById(String id) {
        return null;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public String getId() {
        return menuItem.getId();
    }

    public void setId(String id) {
        menuItem.setId(id);
    }

    public String getText() {
        return menuItem.getText();
    }

    public void setText(String text) {
        menuItem.setText(text);
    }

    public void enable() {
        menuItem.setDisable(false);
    }

    public void disable() {
        menuItem.setDisable(true);
    }

}
