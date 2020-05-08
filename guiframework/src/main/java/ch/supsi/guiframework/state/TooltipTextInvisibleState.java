package ch.supsi.guiframework.state;


public class TooltipTextInvisibleState implements TooltipTextViewState {

    @Override
    public void setTooltipText(TooltipTextable toolTipTextable, String text) {
        toolTipTextable.setTooltip(null);
    }

}
