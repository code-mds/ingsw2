package ch.supsi.e2etestsdemo.controller;

import ch.supsi.e2etestsdemo.component.MyButton;
import ch.supsi.e2etestsdemo.model.ButtonStateHandler;
import ch.supsi.guiframework.controller.AbstractController;
import ch.supsi.guiframework.event.ModelHasChangedEvent;
import ch.supsi.guiframework.model.DataHandler;
import ch.supsi.guiframework.state.*;

import java.util.ArrayList;


public class StateMediator<T extends DataHandler> extends AbstractController implements ButtonStateHandler {

    protected ArrayList<MyButton> buttons;

    final public static TextVisibleState textVisibleState = new TextVisibleState();
    final public static TextInvisibleState textInvisibleState = new TextInvisibleState();

    final public static TooltipTextVisibleState tooltipVisibleState = new TooltipTextVisibleState();
    final public static TooltipTextInvisibleState tooltipInvisibleState = new TooltipTextInvisibleState();

    final public static IconVisibleState iconVisibleState = new IconVisibleState();
    final public static IconInvisibleState iconInvisibleState = new IconInvisibleState();

    protected StateMediator(T model) {
        super(model);
    }

    // factory method
    public static StateMediator create(DataHandler model, ArrayList<MyButton> buttons) throws InstantiationException {
        if (model == null) {
            throw new InstantiationException("controller model cannot be null!");
        }

        if (buttons == null || buttons.isEmpty()) {
            throw new InstantiationException("buttons list cannot be null or empty!");
        }

        StateMediator controller = new StateMediator(model);
        controller.buttons = buttons;

        return controller;
    }

    public DataHandler getModel() {
        return (DataHandler)model;
    }

    @Override
    public void reset() {
        for(MyButton button : buttons) {
            button.setTextViewState(this.textVisibleState);
            button.setTooltipTextViewState(this.tooltipVisibleState);
            button.setIconViewState(this.iconVisibleState);

            button.getTextViewState().setText(button, button.getText());
            button.getTooltipTextViewState().setTooltipText(button, button.getTooltip());
            button.getIconViewState().setIcon(button, button.getIcon());
        }

        this.getModel().setChanged(false);
    }

    @Override
    public void toggleText() {
        for(MyButton button : buttons) {
            // toggle text viewable state
            if (button.getTextViewState() instanceof TextVisibleState) {
                button.setTextViewState(this.textInvisibleState);
            } else {
                button.setTextViewState(this.textVisibleState);
            }

            button.getTextViewState().setText(button, button.getText());
        }

        this.getModel().setChanged(true);
    }

    @Override
    public void toggleTooltip() {
        for(MyButton button : buttons) {
            // toggle text viewable state
            if (button.getTooltipTextViewState() instanceof TooltipTextVisibleState) {
                button.setTooltipTextViewState(this.tooltipInvisibleState);
            } else {
                button.setTooltipTextViewState(this.tooltipVisibleState);
            }

            button.getTooltipTextViewState().setTooltipText(button, button.getTooltip());
        }

        this.getModel().setChanged(true);
    }

    @Override
    public void toggleIcon() {
        for(MyButton button : buttons) {
            // toggle text viewable state
            if (button.getIconViewState() instanceof IconVisibleState) {
                button.setIconViewState(this.iconInvisibleState);
            } else {
                button.setIconViewState(this.iconVisibleState);
            }

            button.getIconViewState().setIcon(button, button.getIcon());
        }

        this.getModel().setChanged(true);
    }

}
