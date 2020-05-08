package ch.supsi.guiframework.component;

import javafx.scene.control.TextField;
import org.w3c.dom.Text;


public class MyTextField {

    private TextField textField;

    protected MyTextField() {
        // set actual framework textfield component
        this.setActualComponent(new TextField());
    }

    // factory method
    public static MyTextField create(String text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("text cannot be null or empty!");
        }

        MyTextField textfield = new MyTextField();
        textfield.setText(text);

        return textfield;
    }


    public TextField getActualComponent() {
        return textField;
    }

    protected void setActualComponent(TextField textField) {
        this.textField = textField;
    }

    // TODO
    public TextField getActualComponentById(String id) {
        return null;
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        textField.setText(text);
    }

}
