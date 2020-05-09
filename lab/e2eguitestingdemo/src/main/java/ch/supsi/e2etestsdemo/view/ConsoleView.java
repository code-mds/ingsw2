package ch.supsi.e2etestsdemo.view;

import ch.supsi.guiframework.component.MyConsoleView;
import ch.supsi.guiframework.event.ModelHasChangedEvent;
import ch.supsi.guiframework.model.Observable;

import java.beans.PropertyChangeEvent;

public class ConsoleView<T extends Observable> extends MyConsoleView {

    protected static final int DEFAULT_TEXT_ROWS = 11;

    protected ConsoleView(T model) {
        super(model);
    }

    // factory method
    public static ConsoleView create(Observable model) throws InstantiationException {
        if (model == null) {
            throw new InstantiationException("view model cannot be null!");
        }

        ConsoleView consoleView = new ConsoleView(model);
        consoleView.setId("console");
        consoleView.setEditable(false);
        consoleView.setPrefRowCount(DEFAULT_TEXT_ROWS);

        return consoleView;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event instanceof ModelHasChangedEvent) {
            getActualComponent().appendText("model has changed since last time we asked!\n");

        } else {
            // any other event is not for me ... so I discard it and do nothing.
            getActualComponent().appendText("this event is not for me!\n");

        }
    }

}
