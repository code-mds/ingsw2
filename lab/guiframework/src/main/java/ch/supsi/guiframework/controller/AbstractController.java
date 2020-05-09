package ch.supsi.guiframework.controller;

import ch.supsi.guiframework.model.Handler;


abstract public class AbstractController<T extends Handler> {

    protected T model;

    protected AbstractController(T model) {
        this.model = model;
    }

}
