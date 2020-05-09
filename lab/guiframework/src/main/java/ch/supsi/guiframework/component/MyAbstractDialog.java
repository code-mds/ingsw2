package ch.supsi.guiframework.component;

import javafx.stage.Modality;
import javafx.stage.Stage;


abstract public class MyAbstractDialog {

    protected String title;

    protected Stage dialog;

    protected MyAbstractDialog() {
        super();
        this.setActualComponent(new Stage());
    }

    public Stage getActualComponent() {
        return dialog;
    }

    protected void setActualComponent(Stage stage) {
        this.dialog = stage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        dialog.setTitle(title);
    }

    public Stage getDialog() {
        return dialog;
    }

    public void setApplicationModal() {
        dialog.initModality(Modality.APPLICATION_MODAL);
    }

    public void setNonModal() {
        dialog.initModality(Modality.NONE);
    }

    public void show() {
        this.getActualComponent().show();
    }

    public void close() {
        this.getActualComponent().close();
    }
}
