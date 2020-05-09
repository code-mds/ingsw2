package ch.supsi.guiframework.component;

import ch.supsi.guiframework.command.CancelCommand;
import ch.supsi.guiframework.command.OkCommand;
import ch.supsi.guiframework.factory.ButtonsFactory;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MyMessageDialog extends MyAbstractDialog {

    private MyLabel message;
    private MyButton cancelButton;
    private MyButton okButton;

    protected MyMessageDialog() {
        super();
    }

    // factory method
    public static MyMessageDialog create(String title, String message, CancelCommand cancelCommand, OkCommand okCommand, Boolean modal) throws InstantiationException {
        if (title == null || title.isEmpty()) {
            throw new InstantiationException("title cannot be null or empty!");
        }

        if (message == null || message.isEmpty()) {
            throw new InstantiationException("message cannot be null or empty!");
        }

        MyMessageDialog dialog = new MyMessageDialog();
        dialog.setTitle(title);

        VBox dialogBox = new VBox(3);

        // message pane
        GridPane messagePane = new GridPane();
        dialog.message = MyLabel.create(message);
        messagePane.add(dialog.message.getActualComponent(), 0, 1);
        dialogBox.getChildren().add(messagePane);

        // buttons pane
        dialog.setCancelButton(ButtonsFactory.instance().createCancelButton(cancelCommand));
        dialog.setOkButton(ButtonsFactory.instance().createOkButton(okCommand));

        dialog.getCancelButton().enable();
        dialog.getOkButton().enable();

        MyButtonsPane buttonsPane = MyButtonsPane.create();
        buttonsPane.addButton(dialog.getCancelButton());
        buttonsPane.addButton(dialog.getOkButton());

        dialogBox.getChildren().add(buttonsPane.getActualComponent());

        // scene
        Scene dialogScene = new Scene(dialogBox);
        dialog.getActualComponent().setScene(dialogScene);

        return dialog;
    }

    // confirmation dialog factory method
    public static MyMessageDialog createExitConfirmationDialog(CancelCommand cancelCommand, OkCommand okCommand) {
        MyMessageDialog dialog = null;

        try {
            dialog = create("Exiting...", "Are you sure?", cancelCommand, okCommand, true);
            dialog.setApplicationModal();

        } catch (InstantiationException e) {
            ;
        }

        return dialog;
    }

    public MyButton getCancelButton() {
        return this.cancelButton;
    }

    protected void setCancelButton(MyButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public MyButton getOkButton() {
        return this.okButton;
    }

    protected void setOkButton(MyButton okButton) {
        this.okButton = okButton;
    }

}
