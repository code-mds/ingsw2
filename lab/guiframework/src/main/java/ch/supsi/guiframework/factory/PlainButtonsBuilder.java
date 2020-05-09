package ch.supsi.guiframework.factory;


import ch.supsi.guiframework.component.MyButton;

public class PlainButtonsBuilder extends AbstractButtonsBuilder {

    @Override
    public MyButton build(ButtonsBuilder builder) throws InstantiationException {
        if (builder == null) {
            throw new InstantiationException("builder cannot be null!");
        }

        MyButton button = new MyButton();
        button.setId(builder.getId());
        button.setText(builder.getText());
        button.setTooltip(builder.getTooltip());
        button.setIcon(builder.getIcon());
        button.setCommand(builder.getCommand());

        return button;
    }

}
