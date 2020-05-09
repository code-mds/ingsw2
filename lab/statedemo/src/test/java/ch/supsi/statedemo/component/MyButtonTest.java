package ch.supsi.statedemo.component;


import ch.supsi.guiframework.state.*;
import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class MyButtonTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @BeforeClass
    public static void beforeClass() {
        // WORKAROUND !!!
        // initialize javafx toolkit
        JFXPanel fxPanel = new JFXPanel();
    }

    @Test
    public void constructor0() {
        MyButton button = new MyButton();
        Assert.assertNotNull(button);
        Assert.assertTrue(button instanceof MyButton);
        Assert.assertTrue(button instanceof ch.supsi.guiframework.component.MyButton);
        Assert.assertTrue(button instanceof Textable);
        Assert.assertTrue(button instanceof TooltipTextable);
        Assert.assertTrue(button instanceof Iconable);
        Assert.assertNull(button.getTextViewState());
        Assert.assertNull(button.getTooltipTextViewState());
        Assert.assertNull(button.getIconViewState());
    }

    @Test
    public void create0() throws IllegalArgumentException {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("id cannot be null or empty!");

        MyButton.create(null);
    }

    @Test
    public void create1() throws IllegalArgumentException {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("id cannot be null or empty!");

        MyButton.create("");
    }

    @Test
    public void create2() throws IllegalArgumentException {
        MyButton button = MyButton.create("id");

        Assert.assertNotNull(button);
        Assert.assertEquals("id", button.getId());
    }

    @Test
    public void setTextViewState0() {
        MyButton button = new MyButton();
        Assert.assertNotNull(button);

        button.setTextViewState(null);
        Assert.assertNull(button.textViewState);

    }

    @Test
    public void setTextViewState1() {
        MyButton button = new MyButton();
        Assert.assertNotNull(button);

        TextVisibleState mockState = Mockito.mock(TextVisibleState.class);

        button.setTextViewState(mockState);
        Assert.assertNotNull(button.textViewState);
        Assert.assertEquals(mockState, button.textViewState);
    }

    @Test
    public void setTextViewState2() {
        MyButton button = new MyButton();
        Assert.assertNotNull(button);

        TextInvisibleState mockState = Mockito.mock(TextInvisibleState.class);

        button.setTextViewState(mockState);
        Assert.assertNotNull(button.textViewState);
        Assert.assertEquals(mockState, button.textViewState);
    }

    @Test
    public void setTooltipTextViewState0() {
        MyButton button = new MyButton();
        Assert.assertNotNull(button);

        button.setTooltipTextViewState(null);
        Assert.assertNull(button.tooltipTextViewState);

    }

    @Test
    public void setTooltipTextViewState1() {
        MyButton button = new MyButton();
        Assert.assertNotNull(button);

        TooltipTextVisibleState mockState = Mockito.mock(TooltipTextVisibleState.class);

        button.setTooltipTextViewState(mockState);
        Assert.assertNotNull(button.tooltipTextViewState);
        Assert.assertEquals(mockState, button.tooltipTextViewState);
    }

    @Test
    public void setTooltipTextViewState2() {
        MyButton button = new MyButton();
        Assert.assertNotNull(button);

        TooltipTextInvisibleState mockState = Mockito.mock(TooltipTextInvisibleState.class);

        button.setTooltipTextViewState(mockState);
        Assert.assertNotNull(button.tooltipTextViewState);
        Assert.assertEquals(mockState, button.tooltipTextViewState);
    }

    @Test
    public void setIconViewState0() {
        MyButton button = new MyButton();
        Assert.assertNotNull(button);

        button.setIconViewState(null);
        Assert.assertNull(button.iconViewState);

    }

    @Test
    public void setIconViewState1() {
        MyButton button = new MyButton();
        Assert.assertNotNull(button);

        IconVisibleState mockState = Mockito.mock(IconVisibleState.class);

        button.setIconViewState(mockState);
        Assert.assertNotNull(button.iconViewState);
        Assert.assertEquals(mockState, button.iconViewState);
    }

    @Test
    public void setIconViewState2() {
        MyButton button = new MyButton();
        Assert.assertNotNull(button);

        IconInvisibleState mockState = Mockito.mock(IconInvisibleState.class);

        button.setIconViewState(mockState);
        Assert.assertNotNull(button.iconViewState);
        Assert.assertEquals(mockState, button.iconViewState);
    }

    @Test
    public void getsetText() {
        MyButton button = new MyButton();
        Assert.assertNotNull(button);

        button.setText(null);
        Assert.assertNull(button.getText());

        button.setText("");
        Assert.assertEquals("", button.getText());

        button.setText("text");
        Assert.assertEquals("text", button.getText());
    }

    @Test
    public void getsetTooltip() {
        MyButton button = new MyButton();
        Assert.assertNotNull(button);

        button.setTooltip(null);
        Assert.assertNull(button.getTooltip());

        button.setTooltip("");
        Assert.assertEquals("", button.getTooltip());

        button.setTooltip("text");
        Assert.assertEquals("text", button.getTooltip());
    }

    @Test
    public void getsetIcon() {
        Image mockIcon = Mockito.mock(Image.class);

        MyButton button = new MyButton();
        Assert.assertNotNull(button);

        button.setIcon(null);
        Assert.assertNull(button.getIcon());

        button.setIcon(mockIcon);
        Assert.assertEquals(mockIcon, button.getIcon());
    }

}
