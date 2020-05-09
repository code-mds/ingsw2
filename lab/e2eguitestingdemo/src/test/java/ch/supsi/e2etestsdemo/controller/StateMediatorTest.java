package ch.supsi.e2etestsdemo.controller;


import ch.supsi.guiframework.controller.AbstractController;
import ch.supsi.guiframework.model.DataHandler;
import ch.supsi.guiframework.model.Observable;
import ch.supsi.guiframework.state.*;
import ch.supsi.e2etestsdemo.component.MyButton;
import ch.supsi.e2etestsdemo.model.ButtonStateHandler;
import ch.supsi.e2etestsdemo.model.Model;
import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.ArrayList;

public class StateMediatorTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void constructor0() {
        StateMediator mediator = new StateMediator(null);
        Assert.assertNotNull(mediator);
        Assert.assertTrue(mediator instanceof AbstractController);
    }

    @Test
    public void constructor1() {
        DataHandler mockModel = Mockito.mock(DataHandler.class);

        StateMediator mediator = new StateMediator(mockModel);
        Assert.assertNotNull(mediator);
        Assert.assertTrue(mediator instanceof AbstractController);
    }

    @Test
    public void create0() throws InstantiationException {
        // model is null

        exceptionRule.expect(InstantiationException.class);
        exceptionRule.expectMessage("controller model cannot be null!");

        ArrayList mockButtons = Mockito.mock(ArrayList.class);

        StateMediator.create(null, mockButtons);
    }

    @Test
    public void create1() throws InstantiationException {
        // buttons list is null

        exceptionRule.expect(InstantiationException.class);
        exceptionRule.expectMessage("buttons list cannot be null or empty!");

        DataHandler mockModel = Mockito.mock(DataHandler.class);

        StateMediator.create(mockModel, null);
    }

    @Test
    public void create2() throws InstantiationException {
        // buttons list is empty

        exceptionRule.expect(InstantiationException.class);
        exceptionRule.expectMessage("buttons list cannot be null or empty!");

        Model mockModel = Mockito.mock(Model.class);
        ArrayList<MyButton> mockButtons = (ArrayList<MyButton>)Mockito.mock(ArrayList.class);
        Mockito.when(mockButtons.isEmpty()).thenReturn(true);

        StateMediator.create(mockModel, mockButtons);
    }

    @Test
    public void create3() throws InstantiationException {
        // all ok

        Model mockModel = Mockito.mock(Model.class);
        ArrayList<MyButton> mockButtons = (ArrayList<MyButton>)Mockito.mock(ArrayList.class);
        Mockito.when(mockButtons.isEmpty()).thenReturn(false);

        StateMediator mediator = StateMediator.create(mockModel, mockButtons);
        Assert.assertNotNull(mediator);
        Assert.assertTrue(mediator instanceof AbstractController);
        Assert.assertTrue(mediator instanceof ButtonStateHandler);
        Assert.assertEquals(mockButtons, mediator.buttons);
    }

    @Test
    public void reset0() throws InstantiationException {
        Image mockIcon = Mockito.mock(Image.class);
        TextVisibleState mockTextState = Mockito.mock(TextVisibleState.class);
        TooltipTextVisibleState mockTooltipState = Mockito.mock(TooltipTextVisibleState.class);
        IconVisibleState mockIconState = Mockito.mock(IconVisibleState.class);

        MyButton mockButton1 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton1.getText()).thenReturn("text");
        Mockito.when(mockButton1.getTooltip()).thenReturn("tooltip");
        Mockito.when(mockButton1.getIcon()).thenReturn(mockIcon);
        Mockito.when(mockButton1.getTextViewState()).thenReturn(mockTextState);
        Mockito.when(mockButton1.getTooltipTextViewState()).thenReturn(mockTooltipState);
        Mockito.when(mockButton1.getIconViewState()).thenReturn(mockIconState);

        MyButton mockButton2 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton2.getText()).thenReturn("text");
        Mockito.when(mockButton2.getTooltip()).thenReturn("tooltip");
        Mockito.when(mockButton2.getIcon()).thenReturn(mockIcon);
        Mockito.when(mockButton2.getTextViewState()).thenReturn(mockTextState);
        Mockito.when(mockButton2.getTooltipTextViewState()).thenReturn(mockTooltipState);
        Mockito.when(mockButton2.getIconViewState()).thenReturn(mockIconState);

        MyButton mockButton3 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton3.getText()).thenReturn("text");
        Mockito.when(mockButton3.getTooltip()).thenReturn("tooltip");
        Mockito.when(mockButton3.getIcon()).thenReturn(mockIcon);
        Mockito.when(mockButton3.getTextViewState()).thenReturn(mockTextState);
        Mockito.when(mockButton3.getTooltipTextViewState()).thenReturn(mockTooltipState);
        Mockito.when(mockButton3.getIconViewState()).thenReturn(mockIconState);

        Model mockModel = Mockito.mock(Model.class);
        ArrayList<MyButton> mockButtons = new ArrayList<>();
        mockButtons.add(mockButton1);
        mockButtons.add(mockButton2);
        mockButtons.add(mockButton3);

        StateMediator mediator = StateMediator.create(mockModel, mockButtons);
        Assert.assertNotNull(mediator);

        mediator.reset();

        for(MyButton button : mockButtons) {
            Mockito.verify(button, Mockito.times(1)).setTextViewState(Mockito.any(TextVisibleState.class));
            Mockito.verify(button, Mockito.times(1)).setTooltipTextViewState(Mockito.any(TooltipTextVisibleState.class));
            Mockito.verify(button, Mockito.times(1)).setIconViewState(Mockito.any(IconVisibleState.class));

            Mockito.verify(mockTextState, Mockito.times(1)).setText(button, "text");
            Mockito.verify(mockTooltipState, Mockito.times(1)).setTooltipText(button, "tooltip");
            Mockito.verify(mockIconState, Mockito.times(1)).setIcon(button, mockIcon);
        }
    }

    @Test
    public void toggleText0() throws InstantiationException {
        // visible to invisible

        TextVisibleState state = Mockito.mock(TextVisibleState.class);

        MyButton mockButton1 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton1.getText()).thenReturn("text");
        Mockito.when(mockButton1.getTextViewState()).thenReturn(state);

        MyButton mockButton2 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton2.getText()).thenReturn("text");
        Mockito.when(mockButton2.getTextViewState()).thenReturn(state);

        MyButton mockButton3 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton3.getText()).thenReturn("text");
        Mockito.when(mockButton3.getTextViewState()).thenReturn(state);

        Model mockModel = Mockito.mock(Model.class);
        ArrayList<MyButton> mockButtons = new ArrayList<>();
        mockButtons.add(mockButton1);
        mockButtons.add(mockButton2);
        mockButtons.add(mockButton3);

        StateMediator mediator = StateMediator.create(mockModel, mockButtons);
        Assert.assertNotNull(mediator);

        mediator.toggleText();

        for(MyButton button : mockButtons) {
            Mockito.verify(button, Mockito.times(1)).setTextViewState(Mockito.any(TextInvisibleState.class));
            Mockito.verify(state, Mockito.times(1)).setText(button, "text");
        }
    }

    @Test
    public void toggleText1() throws InstantiationException {
        // invisible to visible

        TextInvisibleState state = Mockito.mock(TextInvisibleState.class);

        MyButton mockButton1 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton1.getText()).thenReturn("text");
        Mockito.when(mockButton1.getTextViewState()).thenReturn(state);

        MyButton mockButton2 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton2.getText()).thenReturn("text");
        Mockito.when(mockButton2.getTextViewState()).thenReturn(state);

        MyButton mockButton3 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton3.getText()).thenReturn("text");
        Mockito.when(mockButton3.getTextViewState()).thenReturn(state);

        Model mockModel = Mockito.mock(Model.class);
        ArrayList<MyButton> mockButtons = new ArrayList<>();
        mockButtons.add(mockButton1);
        mockButtons.add(mockButton2);
        mockButtons.add(mockButton3);

        StateMediator mediator = StateMediator.create(mockModel, mockButtons);
        Assert.assertNotNull(mediator);

        mediator.toggleText();

        for(MyButton button : mockButtons) {
            Mockito.verify(button, Mockito.times(1)).setTextViewState(Mockito.any(TextVisibleState.class));
            Mockito.verify(state, Mockito.times(1)).setText(button, "text");
        }
    }

    @Test
    public void toggleTooltip0() throws InstantiationException {
        // visible to invisible

        TooltipTextVisibleState state = Mockito.mock(TooltipTextVisibleState.class);

        MyButton mockButton1 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton1.getTooltip()).thenReturn("tooltip");
        Mockito.when(mockButton1.getTooltipTextViewState()).thenReturn(state);

        MyButton mockButton2 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton2.getTooltip()).thenReturn("tooltip");
        Mockito.when(mockButton2.getTooltipTextViewState()).thenReturn(state);

        MyButton mockButton3 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton3.getTooltip()).thenReturn("tooltip");
        Mockito.when(mockButton3.getTooltipTextViewState()).thenReturn(state);

        Model mockModel = Mockito.mock(Model.class);
        ArrayList<MyButton> mockButtons = new ArrayList<>();
        mockButtons.add(mockButton1);
        mockButtons.add(mockButton2);
        mockButtons.add(mockButton3);

        StateMediator mediator = StateMediator.create(mockModel, mockButtons);
        Assert.assertNotNull(mediator);

        mediator.toggleTooltip();

        for(MyButton button : mockButtons) {
            Mockito.verify(button, Mockito.times(1)).setTooltipTextViewState(Mockito.any(TooltipTextInvisibleState.class));
            Mockito.verify(state, Mockito.times(1)).setTooltipText(button, "tooltip");
        }
    }

    @Test
    public void toggleTooltip1() throws InstantiationException {
        // invisible to visible

        TooltipTextInvisibleState state = Mockito.mock(TooltipTextInvisibleState.class);

        MyButton mockButton1 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton1.getTooltip()).thenReturn("tooltip");
        Mockito.when(mockButton1.getTooltipTextViewState()).thenReturn(state);

        MyButton mockButton2 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton2.getTooltip()).thenReturn("tooltip");
        Mockito.when(mockButton2.getTooltipTextViewState()).thenReturn(state);

        MyButton mockButton3 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton3.getTooltip()).thenReturn("tooltip");
        Mockito.when(mockButton3.getTooltipTextViewState()).thenReturn(state);

        Model mockModel = Mockito.mock(Model.class);
        ArrayList<MyButton> mockButtons = new ArrayList<>();
        mockButtons.add(mockButton1);
        mockButtons.add(mockButton2);
        mockButtons.add(mockButton3);

        StateMediator mediator = StateMediator.create(mockModel, mockButtons);
        Assert.assertNotNull(mediator);

        mediator.toggleTooltip();

        for(MyButton button : mockButtons) {
            Mockito.verify(button, Mockito.times(1)).setTooltipTextViewState(Mockito.any(TooltipTextVisibleState.class));
            Mockito.verify(state, Mockito.times(1)).setTooltipText(button, "tooltip");
        }
    }

    @Test
    public void toggleIcon0() throws InstantiationException {
        // visible to invisible

        Image mockIcon = Mockito.mock(Image.class);
        IconVisibleState state = Mockito.mock(IconVisibleState.class);

        MyButton mockButton1 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton1.getIcon()).thenReturn(mockIcon);
        Mockito.when(mockButton1.getIconViewState()).thenReturn(state);

        MyButton mockButton2 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton2.getIcon()).thenReturn(mockIcon);
        Mockito.when(mockButton2.getIconViewState()).thenReturn(state);

        MyButton mockButton3 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton3.getIcon()).thenReturn(mockIcon);
        Mockito.when(mockButton3.getIconViewState()).thenReturn(state);

        Model mockModel = Mockito.mock(Model.class);
        ArrayList<MyButton> mockButtons = new ArrayList<>();
        mockButtons.add(mockButton1);
        mockButtons.add(mockButton2);
        mockButtons.add(mockButton3);

        StateMediator mediator = StateMediator.create(mockModel, mockButtons);
        Assert.assertNotNull(mediator);

        mediator.toggleIcon();

        for(MyButton button : mockButtons) {
            Mockito.verify(button, Mockito.times(1)).setIconViewState(Mockito.any(IconInvisibleState.class));
            Mockito.verify(state, Mockito.times(1)).setIcon(button, mockIcon);
        }
    }

    @Test
    public void toggleIcon1() throws InstantiationException {
        // invisible to visible

        Image mockIcon = Mockito.mock(Image.class);
        IconInvisibleState state = Mockito.mock(IconInvisibleState.class);

        MyButton mockButton1 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton1.getIcon()).thenReturn(mockIcon);
        Mockito.when(mockButton1.getIconViewState()).thenReturn(state);

        MyButton mockButton2 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton2.getIcon()).thenReturn(mockIcon);
        Mockito.when(mockButton2.getIconViewState()).thenReturn(state);

        MyButton mockButton3 = Mockito.mock(MyButton.class);
        Mockito.when(mockButton3.getIcon()).thenReturn(mockIcon);
        Mockito.when(mockButton3.getIconViewState()).thenReturn(state);

        Model mockModel = Mockito.mock(Model.class);
        ArrayList<MyButton> mockButtons = new ArrayList<>();
        mockButtons.add(mockButton1);
        mockButtons.add(mockButton2);
        mockButtons.add(mockButton3);

        StateMediator mediator = StateMediator.create(mockModel, mockButtons);
        Assert.assertNotNull(mediator);

        mediator.toggleIcon();

        for(MyButton button : mockButtons) {
            Mockito.verify(button, Mockito.times(1)).setIconViewState(Mockito.any(IconVisibleState.class));
            Mockito.verify(state, Mockito.times(1)).setIcon(button, mockIcon);
        }
    }

}
