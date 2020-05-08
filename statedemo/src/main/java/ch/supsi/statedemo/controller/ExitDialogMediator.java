package ch.supsi.statedemo.controller;


import ch.supsi.guiframework.command.CancelCommand;
import ch.supsi.guiframework.command.OkCommand;
import ch.supsi.guiframework.component.MyMessageDialog;
import ch.supsi.guiframework.controller.AbstractController;
import ch.supsi.guiframework.model.CancelHandler;
import ch.supsi.guiframework.model.DataHandler;
import ch.supsi.guiframework.model.ExitHandler;
import ch.supsi.guiframework.model.OkHandler;
import javafx.stage.Stage;

import java.util.Random;

public class ExitDialogMediator extends AbstractController implements ExitHandler, CancelHandler, OkHandler {

    private Random random = new Random(System.currentTimeMillis());

    protected static MyMessageDialog confirmationDialog;

    protected CancelCommand cancelCommand;

    protected OkCommand okCommand;

    protected Stage owner;

    protected ExitDialogMediator(DataHandler model) {
        super(model);
    }

    // factory method
    public static ExitDialogMediator create(DataHandler model) throws IllegalArgumentException {
        if (model == null) {
            throw new IllegalArgumentException("controller model cannot be null!");
        }

        ExitDialogMediator mediator = new ExitDialogMediator(model);
        return mediator;
    }

    public DataHandler getModel() {
        return (DataHandler)model;
    }

    public void setCancelCommand(CancelCommand command) {
        this.cancelCommand = command;
    }

    public void setOkCommand(OkCommand command) {
        this.okCommand = command;
    }

    public void setOwner(Stage owner) {
        this.owner = owner;
    }

    @Override
    public void controlExit() throws NoSuchFieldException {
        if (cancelCommand == null) {
            throw new NoSuchFieldException("cancel command is null!");
        }

        if (okCommand == null) {
            throw new NoSuchFieldException("ok command is null!");
        }

        // set model random change status (demo only!!!)
        this.getModel().setChanged(random.nextBoolean());

        // check data model change status
        if (! this.getModel().isChanged()) {
            // we can exit safely
            // call actual exit method
            this.exit();

        } else {
            // we must ask confirmation
            // show confirmation dialog
            this.getConfirmationDialog(cancelCommand, okCommand).show();
        }
    }

    @Override
    public void cancel() {
        confirmationDialog.close();
    }

    @Override
    public void exit() {
        owner.close();
    }

    @Override
    public void ok() {
        cancel();
        exit();
    }

    /////

    protected MyMessageDialog getConfirmationDialog(CancelCommand cancelCommand, OkCommand okCommand) {
        // we keep one single instance of our confirmation dialog
        // create confirmation dialog if necessary
        if (confirmationDialog == null) {
            confirmationDialog = MyMessageDialog.createExitConfirmationDialog(cancelCommand, okCommand);
        }

        return confirmationDialog;
    }

}
