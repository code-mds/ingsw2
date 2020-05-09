package ch.supsi.guiframework.component;

import ch.supsi.guiframework.model.Observable;
import javafx.scene.control.TextArea;

abstract  public class MyConsoleView<T extends Observable> extends MyAbstractView {

    protected TextArea console;

    protected MyConsoleView(T model) {
        super(model);
        console = new TextArea();
    }

    public Observable getModel() {
        return (Observable) model;
    }

    public TextArea getActualComponent() {
        return console;
    }

    public String getId() {
        return console.getId();
    }

    public void setId(String id) {
        console.setId(id);
    }

    public boolean isEditable() {
        return console.isEditable();
    }

    public void setEditable(boolean editable) {
        console.setEditable(editable);
    }

    public int getPrefRowCount() {
        return console.getPrefRowCount();
    }

    public void setPrefRowCount(int rowCount) {
        console.setPrefRowCount(rowCount);
    }

}