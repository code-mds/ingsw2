package ch.supsi.guiframework.state;


public class TextInvisibleState implements TextViewState {

    @Override
    public void setText(Textable textable, String text) {
        textable.setText(null);
    }

}
