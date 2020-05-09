package ch.supsi.statedemo.model;


import ch.supsi.guiframework.model.Handler;

public interface ButtonStateHandler extends Handler {

    void reset();

    void toggleText();

    void toggleTooltip();

    void toggleIcon();

}
