package ch.supsi.guiframework.component;

import javafx.geometry.Orientation;
import javafx.scene.control.ToolBar;


public class MyToolBar {

    private ToolBar toolBar;

    protected MyToolBar() {
        // set actual framework tool bar component
        this.setActualComponent(new ToolBar());
    }

    public static MyToolBar createHorizontal() {
        MyToolBar myToolBar = new MyToolBar();
        myToolBar.setHorizontalOrientation();
        return myToolBar;
    }

    public static MyToolBar createVertical() {
        MyToolBar myToolBar = new MyToolBar();
        myToolBar.setVerticalOrientation();
        return myToolBar;
    }

    public ToolBar getActualComponent() {
        return toolBar;
    }

    // TODO
    public ToolBar getActualComponentById(String id) {
        return null;
    }

    protected void setActualComponent(ToolBar toolBar) {
        this.toolBar = toolBar;
    }

    public void setVerticalOrientation() {
        toolBar.setOrientation(Orientation.VERTICAL);
    }

    public void setHorizontalOrientation() {
        toolBar.setOrientation(Orientation.HORIZONTAL);
    }

    public void addButton(MyButton button) {
        if (button == null) {
            return;
        }

        toolBar.getItems().add(button.getActualComponent());
    }

    public void addButtons(MyButton... myButtons) {
        for (MyButton myButton : myButtons) {
            addButton(myButton);
        }
    }

}
