package ch.supsi.guiframework.state;


public class TooltipTextVisibleState implements TooltipTextViewState {

    @Override
    public void setTooltipText(TooltipTextable tooltipTextable, String text) {
        tooltipTextable.setTooltip(text);
    }

}
