package ch.supsi.guiframework.model;

public interface DataHandler extends Handler {

    boolean isChanged();

    void setChanged(boolean changed);

}