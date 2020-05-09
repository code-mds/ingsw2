package ch.supsi.guiframework.state;


public class TextVisibleState implements TextViewState {

    @Override
    public void setText(Textable textable, String text) {
        textable.setText(text);
    }

}
