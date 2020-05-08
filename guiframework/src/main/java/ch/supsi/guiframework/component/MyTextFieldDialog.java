package ch.supsi.guiframework.component;

import ch.supsi.guiframework.command.CancelCommand;
import ch.supsi.guiframework.command.OkCommand;
import ch.supsi.guiframework.factory.ButtonsFactory;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class MyTextFieldDialog extends MyAbstractDialog {

    private MyLabel label;
    private MyTextField textField;
    private MyButton cancelButton;
    private MyButton okButton;

    protected MyTextFieldDialog() {
        super();
    }

    // factory method
    public static MyTextFieldDialog create(String title, String text, CancelCommand cancelCommand, OkCommand okCommand, Boolean modal) throws InstantiationException {
        if (title == null || title.isEmpty()) {
            throw new InstantiationException("title cannot be null or empty!");
        }

        if (text == null || text.isEmpty()) {
            throw new InstantiationException("text cannot be null or empty!");
        }

        MyTextFieldDialog dialog = new MyTextFieldDialog();
        dialog.setTitle(title);

        VBox dialogBox = new VBox(3);

        // textfield pane
        GridPane textPane = new GridPane();
        dialog.label = MyLabel.create(title);
        dialog.textField = MyTextField.create(text);
        textPane.add(dialog.label.getActualComponent(), 0, 1);
        textPane.add(dialog.textField.getActualComponent(), 1, 1);
        dialogBox.getChildren().add(textPane);

        // buttons pane
        dialog.cancelButton = ButtonsFactory.instance().createCancelButton(cancelCommand);
        dialog.okButton = ButtonsFactory.instance().createOkButton(okCommand);
        MyButtonsPane buttonsPane = MyButtonsPane.create();
        buttonsPane.addButton(dialog.cancelButton);
        buttonsPane.addButton(dialog.okButton);
        dialogBox.getChildren().add(buttonsPane.getActualComponent());

        Scene dialogScene = new Scene(dialogBox);
        dialog.dialog.setScene(dialogScene);

        return dialog;
    }

    public MyTextField getTextField() {
        return textField;
    }

    public MyButton getCancelButton() {
        return cancelButton;
    }

    public MyButton getOkButton() {
        return okButton;
    }

}
