package ch.supsi.e2etestsdemo;

import ch.supsi.e2etestsdemo.command.ResetCommand;
import ch.supsi.e2etestsdemo.command.ToggleIconCommand;
import ch.supsi.e2etestsdemo.command.ToggleTextCommand;
import ch.supsi.e2etestsdemo.command.ToggleTooltipCommand;
import ch.supsi.e2etestsdemo.component.MyButton;
import ch.supsi.e2etestsdemo.controller.ExitDialogMediator;
import ch.supsi.e2etestsdemo.controller.StateMediator;
import ch.supsi.e2etestsdemo.model.ButtonStateHandler;
import ch.supsi.e2etestsdemo.model.Model;
import ch.supsi.e2etestsdemo.view.ConsoleView;
import ch.supsi.guiframework.command.CancelCommand;
import ch.supsi.guiframework.command.MaybeExitCommand;
import ch.supsi.guiframework.command.OkCommand;
import ch.supsi.guiframework.component.MyMenu;
import ch.supsi.guiframework.component.MyMenuBar;
import ch.supsi.guiframework.component.MyMenuItem;
import ch.supsi.guiframework.component.MyToolBar;
import ch.supsi.guiframework.factory.MenuItemsFactory;
import ch.supsi.guiframework.factory.MenusFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;


public class MainGUI extends Application {

    Properties resources;

    private MyMenuBar menuBar;
    private MyToolBar toolBar;

    private Model model;
    private ConsoleView consoleView;
    private ExitDialogMediator exitDialogMediator;
    private StateMediator stateMediator;

    public MainGUI() throws InstantiationException, IOException {
        resources = new Properties();
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("defaults.properties");
        resources.load(in);
        in.close();

        // model(s)
        model = Model.instance();

        // view(s)
        consoleView = ConsoleView.create(model);

        // controller(s)
        MyButton cameraButton = MyButton.create(resources.getProperty("button.camera.id"));
        cameraButton.setText(resources.getProperty("button.camera.text"));
        cameraButton.setTooltip(resources.getProperty("button.camera.tooltip"));
        cameraButton.setIcon(
            new Image(ClassLoader.getSystemClassLoader().getResourceAsStream(resources.getProperty("button.camera.iconPath")))
        );
        cameraButton.setTextViewState(StateMediator.textVisibleState);
        cameraButton.setTooltipTextViewState(StateMediator.tooltipVisibleState);
        cameraButton.setIconViewState(StateMediator.iconVisibleState);

        MyButton infoButton = MyButton.create(resources.getProperty("button.info.id"));
        infoButton.setText(resources.getProperty("button.info.text"));
        infoButton.setTooltip(resources.getProperty("button.info.tooltip"));
        infoButton.setIcon(
                new Image(ClassLoader.getSystemClassLoader().getResourceAsStream(resources.getProperty("button.info.iconPath")))
        );
        infoButton.setTextViewState(StateMediator.textVisibleState);
        infoButton.setTooltipTextViewState(StateMediator.tooltipVisibleState);
        infoButton.setIconViewState(StateMediator.iconVisibleState);

        MyButton pencilButton = MyButton.create(resources.getProperty("button.pencil.id"));
        pencilButton.setText(resources.getProperty("button.pencil.text"));
        pencilButton.setTooltip(resources.getProperty("button.pencil.tooltip"));
        pencilButton.setIcon(
                new Image(ClassLoader.getSystemClassLoader().getResourceAsStream(resources.getProperty("button.pencil.iconPath")))
        );
        pencilButton.setTextViewState(StateMediator.textVisibleState);
        pencilButton.setTooltipTextViewState(StateMediator.tooltipVisibleState);
        pencilButton.setIconViewState(StateMediator.iconVisibleState);

        MyButton resetButton = MyButton.create(resources.getProperty("button.reset.id"));
        resetButton.setText(resources.getProperty("button.reset.text"));
        resetButton.setTooltip(resources.getProperty("button.reset.tooltip"));
        resetButton.setIcon(
                new Image(ClassLoader.getSystemClassLoader().getResourceAsStream(resources.getProperty("button.reset.iconPath")))
        );
        resetButton.setTextViewState(StateMediator.textVisibleState);
        resetButton.setTooltipTextViewState(StateMediator.tooltipVisibleState);
        resetButton.setIconViewState(StateMediator.iconVisibleState);

        ArrayList<MyButton> buttons = new ArrayList<>();
        buttons.add(cameraButton);
        buttons.add(infoButton);
        buttons.add(pencilButton);
//        buttons.add(resetButton);

        stateMediator = StateMediator.create(model, buttons);

        exitDialogMediator = ExitDialogMediator.create(model);
        exitDialogMediator.setCancelCommand(CancelCommand.create(exitDialogMediator));
        exitDialogMediator.setOkCommand(OkCommand.create(exitDialogMediator));

        // factories
        MenusFactory menusFactory = MenusFactory.instance();
        MenuItemsFactory menuItemsFactory = MenuItemsFactory.instance();

        // FILE MENU
        MyMenuItem exitMenuItem = menuItemsFactory.createExitMenuItem(MaybeExitCommand.create(exitDialogMediator));

        MyMenu fileMenu = menusFactory.createFileMenu();
        fileMenu.addMenuItem(exitMenuItem);

        // EDIT MENU
        MyMenu editMenu = menusFactory.createEditMenu();

        // HELP MENU
        MyMenuItem aboutMenuItem = menuItemsFactory.createAboutMenuItem(null);

        MyMenu helpMenu = menusFactory.createHelpMenu();
        helpMenu.addMenuItem(aboutMenuItem);

        // MENU BAR
        menuBar = MyMenuBar.create();
        menuBar.addMenus(
                fileMenu,
                editMenu,
                helpMenu
        );

        // TOOL BAR
        ToggleTextCommand<ButtonStateHandler> toggleTextCommand = ToggleTextCommand.create(stateMediator);
        ToggleTooltipCommand<ButtonStateHandler> toggleTooltipCommand = ToggleTooltipCommand.create(stateMediator);
        ToggleIconCommand<ButtonStateHandler> toggleIconCommand = ToggleIconCommand.create(stateMediator);
        ResetCommand<ButtonStateHandler> resetCommand = ResetCommand.create(stateMediator);

        cameraButton.setCommand(toggleTextCommand);
        infoButton.setCommand(toggleTooltipCommand);
        pencilButton.setCommand(toggleIconCommand);
        resetButton.setCommand(resetCommand);

        toolBar = MyToolBar.createHorizontal();
        toolBar.addButtons(
                cameraButton,
                infoButton,
                pencilButton,
                resetButton
        );

        // observer(s)
        model.addPropertyChangeListener(consoleView);
    }

    @Override
    public void start(Stage primaryStage) {
        // make sure JavaFX will shutdown when the last window (i.e. stage) is closed
        // Platform.setImplicitExit(true);

        // handle the main window close request

            // first we set the exit mediator's owner stage (i.e. this primary stage)
            exitDialogMediator.setOwner(primaryStage);

            primaryStage.setOnCloseRequest(
                    windowEvent -> {
                        try {
                            // then we consume the window event (the main window would be closed otherwise no matter what)
                            windowEvent.consume();

                            // finally we delegate the request to the exit mediator
                            exitDialogMediator.controlExit();

                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }
                    }
            );

        // root pane
        VBox mainVBox = new VBox();
        mainVBox.getChildren().add(menuBar.getActualComponent());
        mainVBox.getChildren().add(toolBar.getActualComponent());

        BorderPane rootPane = new BorderPane();
        rootPane.setTop(mainVBox);
        rootPane.setCenter(consoleView.getActualComponent());

        // root scene
        Scene scene = new Scene(rootPane, 640, 240);

        // show
        primaryStage.setTitle("gui mvc :: state demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }

}
