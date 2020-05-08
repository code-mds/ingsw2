package ch.supsi.guiframework.factory;

import ch.supsi.guiframework.command.Command;
import ch.supsi.guiframework.component.MyButton;

public class ButtonsFactory {

    private static ButtonsFactory factory;

    protected ButtonsFactory() {}

    // singleton
    public static ButtonsFactory instance() {
        if (factory == null) {
            factory = new ButtonsFactory();
        }

        return factory;
    }

    public MyButton createAboutButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("About");
        myButton.setId("aboutButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createApplyButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Apply");
        myButton.setId("applyButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createCancelButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Cancel");
        myButton.setId("cancelButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createCopyButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Copy");
        myButton.setId("copyButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createCutButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Cut");
        myButton.setId("cutButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createExitButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Exit");
        myButton.setId("exitButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createFetchButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Fetch");
        myButton.setId("fetchButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createHelpButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Help");
        myButton.setId("helpButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createNextButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Next");
        myButton.setId("nextButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createOkButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("OK");
        myButton.setId("okButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createOpenButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Open");
        myButton.setId("openButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createPasteButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Paste");
        myButton.setId("pasteButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createPauseButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Paused");
        myButton.setId("pauseButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createPlayButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Play");
        myButton.setId("playButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createPreferencesMenuItem(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Preferences");
        myButton.setId("preferencesButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createPreviousButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Previous");
        myButton.setId("previousButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createSendButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Send");
        myButton.setId("sendButton");
        myButton.setCommand(command);
        return myButton;
    }

    public MyButton createStopButton(Command command) {
        MyButton myButton = new MyButton();
        myButton.setText("Stop");
        myButton.setId("stopButton");
        myButton.setCommand(command);
        return myButton;
    }

}
