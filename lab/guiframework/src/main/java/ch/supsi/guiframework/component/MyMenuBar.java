package ch.supsi.guiframework.component;

import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


public class MyMenuBar {

    private MenuBar menuBar;

    protected MyMenuBar() {
        // set actual framework menu bar component
        this.setActualComponent(new MenuBar());
    }

    // factory method
    public static MyMenuBar create() {
        MyMenuBar menuBar = new MyMenuBar();

        return menuBar;
    }

    public MenuBar getActualComponent() {
        return menuBar;
    }

    protected void setActualComponent(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public void addMenu(MyMenu myMenu) {
        if (myMenu == null) {
            return;
        }

        menuBar.getMenus().add(myMenu.getActualComponent());
    }

    public void addMenus(MyMenu... myMenus) {
        for (MyMenu myMenu : myMenus) {
            this.addMenu(myMenu);
        }
    }

}
