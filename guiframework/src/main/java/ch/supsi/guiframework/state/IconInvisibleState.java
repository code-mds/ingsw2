package ch.supsi.guiframework.state;

import javafx.scene.image.Image;


public class IconInvisibleState implements IconViewState {

    @Override
    public void setIcon(Iconable iconable, Image icon) {
        iconable.setIcon(null);
    }

}
