package ch.supsi.guiframework.component;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class MyButtonsPane {

    private HBox buttonsPane;

    protected MyButtonsPane() {
        this.setActualComponent(new HBox());
    }

    // factory method
    public static MyButtonsPane create() {
        MyButtonsPane myButtonsPane = new MyButtonsPane();
        myButtonsPane.buttonsPane.setAlignment(Pos.CENTER_RIGHT);

        return myButtonsPane;
    }

    public HBox getActualComponent() {
        return buttonsPane;
    }

    protected void setActualComponent(HBox hbox) {
        this.buttonsPane = hbox;
    }

    public String getId() {
        return buttonsPane.getId();
    }

    public void setId(String id) {
        buttonsPane.setId(id);
    }

    public void addButton(MyButton button) {
        buttonsPane.getChildren().add(button.getActualComponent());
    }

}
