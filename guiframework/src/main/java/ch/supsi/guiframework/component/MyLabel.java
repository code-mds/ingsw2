package ch.supsi.guiframework.component;

import javafx.scene.control.Label;

public class MyLabel {

    private Label label;

    protected MyLabel() {
        // set actual framework label component
        this.setActualComponent(new Label());
    }

    // factory method
    public static MyLabel create(String text) throws InstantiationException {
        if (text == null || text.isEmpty()) {
            throw new InstantiationException();
        }

        MyLabel myLabel = new MyLabel();
        myLabel.setText(text);

        return myLabel;
    }


    public Label getActualComponent() {
        return label;
    }

    protected void setActualComponent(Label label) {
        this.label = label;
    }

    // TODO
    public Label getActualComponentById(String id) {
        return null;
    }

    public String getText() {
        return label.getText();
    }

    public void setText(String value) {
        label.setText(value);
    }

}
