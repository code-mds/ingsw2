package ch.supsi.guiframework.component;

import javafx.scene.text.Text;


public class MyText {

    private Text text;

    protected MyText() {
        // set actual framework text component
        this.setActualComponent(new Text());
    }

    // factory method
    public static MyText create(String content) throws InstantiationException {
        if (content == null || content.isEmpty()) {
            throw new InstantiationException("content cannot be null or empty!");
        }

        MyText text = new MyText();
        text.setText(content);
        return text;
    }

    public Text getActualComponent() {
        return text;
    }

    protected void setActualComponent(Text text) {
        this.text = text;
    }

    public String getText() {
        return text.getText();
    }

    public void setText(String text) {
        this.text.setText(text);
    }

}
