package ch.supsi.guiframework.factory;

import ch.supsi.guiframework.component.MyMenu;

public class MenusFactory {

    private static MenusFactory factory;

    protected MenusFactory() {}

    // singleton
    public static MenusFactory instance() {
        if (factory == null) {
            factory = new MenusFactory();
        }

        return factory;
    }

    public MyMenu createDataMenu() {
        MyMenu menu = new MyMenu();
        menu.setText("Data");
        menu.setId("dataMenu");
        return menu;
    }

    public MyMenu createEditMenu() {
        MyMenu menu = new MyMenu();
        menu.setText("Edit");
        menu.setId("editMenu");
        return menu;
    }

    public MyMenu createFileMenu() {
        MyMenu menu = new MyMenu();
        menu.setText("File");
        menu.setId("fileMenu");
        return menu;
    }

    public MyMenu createHelpMenu() {
        MyMenu menu = new MyMenu();
        menu.setText("Help");
        menu.setId("helpMenu");
        return menu;
    }

    public MyMenu createToolsMenu() {
        MyMenu menu = new MyMenu();
        menu.setText("Tools");
        menu.setId("toolsMenu");
        return menu;
    }

}
