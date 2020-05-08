package ch.supsi.statedemo.component;

import ch.supsi.guiframework.state.*;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MyButton extends ch.supsi.guiframework.component.MyButton implements Textable, TooltipTextable, Iconable {

    protected TextViewState textViewState;

    protected TooltipTextViewState tooltipTextViewState;

    protected IconViewState iconViewState;

    public MyButton() {
        super();
    }

    // factory method
    public static MyButton create(String id) throws IllegalArgumentException {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id cannot be null or empty!");
        }

        MyButton myButton = new MyButton();
        myButton.setId(id);

        return myButton;
    }

    public void setText(String text) {
        if (this.text == null || this.text.isEmpty()) {
            this.text = text;
        }

        // set the button's text to the given text
        // if the given text is null or empty the text will basically be unset
        // otherwise the new text will be set

        this.button.setText(text);
    }

    public TextViewState getTextViewState() {
        return textViewState;
    }

    public void setTextViewState(TextViewState textViewState) {
        this.textViewState = textViewState;
    }

    public void setTooltip(String tooltip) {
        if (this.tooltip == null || this.tooltip.isEmpty()) {
            this.tooltip = tooltip;
        }

        // set the button's tooltip to the given tooltip text
        // if the given tooltip text is null or empty the tooltip will basically be unset
        // otherwise the new tooltip text will be set

        if (tooltip == null || tooltip.isEmpty()) {
            button.setTooltip(null);
            return;
        }

        if (this.button.getTooltip() == null) {
            this.button.setTooltip(new Tooltip(tooltip));
        } else {
            this.button.getTooltip().setText(tooltip);
        }
    }

    public TooltipTextViewState getTooltipTextViewState() {
        return tooltipTextViewState;
    }

    public void setTooltipTextViewState(TooltipTextViewState tooltipTextViewState) {
        this.tooltipTextViewState = tooltipTextViewState;
    }

    public void setIcon(Image icon) {
        if (this.icon == null) {
            this.icon = icon;
        }

        // set the button's icon to the given icon
        // if the given icon is null or empty the icon will basically be unset
        // otherwise the new icon will be set

        if (icon == null) {
            button.setGraphic(null);
            return;
        }

        if (button.getGraphic() == null) {
            button.setGraphic(new ImageView(icon));
        } else {
            ((ImageView)button.getGraphic()).setImage(icon);
        }
    }

    public IconViewState getIconViewState() {
        return iconViewState;
    }

    public void setIconViewState(IconViewState iconViewState) {
        this.iconViewState = iconViewState;
    }

}
