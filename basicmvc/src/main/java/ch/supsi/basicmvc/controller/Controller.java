package ch.supsi.basicmvc.controller;

import ch.supsi.basicmvc.model.AbstractModel;


public class Controller extends AbstractController {

    public Controller(AbstractModel model) {
        super(model);
    }

    public boolean controlDo() {
        // control the flow of execution
        model.doSomething();
        model.doSomethingElse();

        return true;
    }

    public boolean controlHandleError() {
        // control error handling
        model.handleError();

        return true;
    }

}
