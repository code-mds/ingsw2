package ch.supsi.guiframework.component;

import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MySeparator {

    private SeparatorMenuItem separator;

    protected MySeparator() {
        // set actual framework separator component
        this.setActualComponent(new SeparatorMenuItem());
    }

    // factory method
    public static MySeparator create() {
        MySeparator mySeparator = new MySeparator();
        return mySeparator;
    }

    public SeparatorMenuItem getActualComponent() {
        return separator;
    }

    protected void setActualComponent(SeparatorMenuItem separator) {
        this.separator = separator;
    }

    // TODO
    public MenuItem getActualComponentById(String id) {
        return null;
    }

}
