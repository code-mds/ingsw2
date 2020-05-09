package ch.supsi.guiframework.factory;

import ch.supsi.guiframework.command.Command;
import ch.supsi.guiframework.component.MyButton;
import ch.supsi.guiframework.component.MyMenuItem;
import ch.supsi.guiframework.component.MySeparator;

public class MenuItemsFactory {

    private static MenuItemsFactory factory;

    protected MenuItemsFactory() {}

    // singleton
    public static MenuItemsFactory instance() {
        if (factory == null) {
            factory = new MenuItemsFactory();
        }

        return factory;
    }

    public MySeparator createSeparator() {
        MySeparator separator = MySeparator.create();
        return separator;
    }

    public MyMenuItem createAboutMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("About");
        menuItem.setId("aboutMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

    public MyMenuItem createCopyMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("Copy");
        menuItem.setId("copyMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

    public MyMenuItem createCutMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("Cut");
        menuItem.setId("cutMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

    public MyMenuItem createExitMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("Exit");
        menuItem.setId("exitMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

    public MyMenuItem createHelpMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("Help");
        menuItem.setId("helpMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

    public MyMenuItem createNextMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("Next");
        menuItem.setId("nextMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

    public MyMenuItem createOpenMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("Open");
        menuItem.setId("openMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

    public MyMenuItem createPasteMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("Paste");
        menuItem.setId("pasteMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

    public MyMenuItem createPauseMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("Pause");
        menuItem.setId("pauseMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

    public MyMenuItem createPlayMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("Play");
        menuItem.setId("playMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

    public MyMenuItem createPreferencesMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("Preferences");
        menuItem.setId("preferencesMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

    public MyMenuItem createPreviousMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("Previous");
        menuItem.setId("previousMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

    public MyMenuItem createSendMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("Send");
        menuItem.setId("sendMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

    public MyMenuItem createStopMenuItem(Command command) {
        MyMenuItem menuItem = new MyMenuItem();
        menuItem.setText("Stop");
        menuItem.setId("stopMenuItem");
        menuItem.setCommand(command);
        return menuItem;
    }

}
