package ch.supsi.e2etestsdemo.command;


import ch.supsi.guiframework.command.AbstractCommand;
import ch.supsi.guiframework.command.Command;
import ch.supsi.e2etestsdemo.model.ButtonStateHandler;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ToggleTooltipCommandTest {

    @Test
    public void constructor0() {
        ToggleTooltipCommand<ButtonStateHandler> command = new ToggleTooltipCommand(null);
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof AbstractCommand);
        Assert.assertTrue(command instanceof Command);
    }

    @Test
    public void constructor1() {
        ButtonStateHandler modelMock = Mockito.mock(ButtonStateHandler.class);

        ToggleTooltipCommand<ButtonStateHandler> command = new ToggleTooltipCommand(modelMock);
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof AbstractCommand);
        Assert.assertTrue(command instanceof Command);
    }

    @Test(expected = InstantiationException.class)
    public void create0() throws InstantiationException {
        ToggleTooltipCommand.create(null);
    }

    @Test
    public void create1() throws InstantiationException {
        ButtonStateHandler mockHandler = Mockito.mock(ButtonStateHandler.class);

        ToggleTooltipCommand<ButtonStateHandler> command = ToggleTooltipCommand.create(mockHandler);
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof AbstractCommand);
        Assert.assertTrue(command instanceof Command);
    }

    @Test(expected = NoSuchFieldException.class)
    public void execute0() throws NoSuchFieldException {
        ToggleTooltipCommand<ButtonStateHandler> command = new ToggleTooltipCommand(null);
        command.execute();
    }

    @Test
    public void execute1() throws InstantiationException, NoSuchFieldException {
        ButtonStateHandler mockHandler = Mockito.mock(ButtonStateHandler.class);

        ToggleTooltipCommand<ButtonStateHandler> command = ToggleTooltipCommand.create(mockHandler);
        command.execute();
        Mockito.verify(mockHandler, Mockito.times(1)).toggleTooltip();
    }

}
