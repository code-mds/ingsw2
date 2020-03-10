package ch.supsi.basicmvc.controller;

import ch.supsi.basicmvc.model.AbstractModel;


abstract public class AbstractController {

    protected AbstractModel model;

    public AbstractController(AbstractModel model) {
        this.model = model;
    }

}
