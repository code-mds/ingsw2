package ch.supsi.guiframework.state;

import javafx.scene.image.Image;


public class IconVisibleState implements IconViewState {

    @Override
    public void setIcon(Iconable iconable, Image image) {
        iconable.setIcon(image);
    }

}
