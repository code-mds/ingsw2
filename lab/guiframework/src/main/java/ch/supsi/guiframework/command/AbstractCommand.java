package ch.supsi.guiframework.command;


import ch.supsi.guiframework.model.Handler;

abstract public class AbstractCommand<T extends Handler> {

    protected T handler;

    protected AbstractCommand(T handler) {
        this.handler = handler;
    }

}
