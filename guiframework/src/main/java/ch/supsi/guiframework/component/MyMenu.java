package ch.supsi.guiframework.component;

import javafx.scene.control.Menu;
import javafx.scene.control.SeparatorMenuItem;

public class MyMenu {

    private Menu menu;

    public MyMenu() {
        // set actual framework menu component
        this.setActualComponent(new Menu());
    }

    public Menu getActualComponent() {
        return menu;
    }

    protected void setActualComponent(Menu menu) {
        this.menu = menu;
    }

    // TODO
    public MyMenu getActualComponentById(String id) {
        return null;
    }

    public String getId() {
        return menu.getId();
    }

    public void setId(String id) {
        menu.setId(id);
    }

    public String getText() {
        return menu.getText();
    }

    public void setText(String text) {
        menu.setText(text);
    }

    public void addMenuItem(MyMenuItem myMenuItem) {
        menu.getItems().add(myMenuItem.getActualComponent());
    }

    public void addMenuItems(MyMenuItem... myMenuItems) {
        for (MyMenuItem myMenuItem : myMenuItems) {
            this.addMenuItem(myMenuItem);
        }
    }

    public void addSeparator() {
        menu.getItems().add(new SeparatorMenuItem());
    }

    public void enable() {
        menu.setDisable(false);
    }

    public void disable() {
        menu.setDisable(true);
    }

}
