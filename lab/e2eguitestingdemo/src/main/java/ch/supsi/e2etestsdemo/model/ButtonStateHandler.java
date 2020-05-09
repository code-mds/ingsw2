package ch.supsi.e2etestsdemo.model;


import ch.supsi.guiframework.model.Handler;

public interface ButtonStateHandler extends Handler {

    void reset();

    void toggleText();

    void toggleTooltip();

    void toggleIcon();

}
