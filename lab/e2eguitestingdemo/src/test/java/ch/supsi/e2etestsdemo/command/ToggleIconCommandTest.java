package ch.supsi.e2etestsdemo.command;


import ch.supsi.guiframework.command.AbstractCommand;
import ch.supsi.guiframework.command.Command;
import ch.supsi.e2etestsdemo.model.ButtonStateHandler;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ToggleIconCommandTest {

    @Test
    public void constructor0() {
        ToggleIconCommand<ButtonStateHandler> command = new ToggleIconCommand(null);
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof AbstractCommand);
        Assert.assertTrue(command instanceof Command);
    }

    @Test
    public void constructor1() {
        ButtonStateHandler modelMock = Mockito.mock(ButtonStateHandler.class);

        ToggleIconCommand<ButtonStateHandler> command = new ToggleIconCommand(modelMock);
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof AbstractCommand);
        Assert.assertTrue(command instanceof Command);
    }

    @Test(expected = InstantiationException.class)
    public void create0() throws InstantiationException {
        ToggleIconCommand.create(null);
    }

    @Test
    public void create1() throws InstantiationException {
        ButtonStateHandler mockHandler = Mockito.mock(ButtonStateHandler.class);

        ToggleIconCommand<ButtonStateHandler> command = ToggleIconCommand.create(mockHandler);
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof AbstractCommand);
        Assert.assertTrue(command instanceof Command);
    }

    @Test(expected = NoSuchFieldException.class)
    public void execute0() throws NoSuchFieldException {
        ToggleIconCommand<ButtonStateHandler> command = new ToggleIconCommand(null);
        command.execute();
    }

    @Test
    public void execute1() throws InstantiationException, NoSuchFieldException {
        ButtonStateHandler mockHandler = Mockito.mock(ButtonStateHandler.class);

        ToggleIconCommand<ButtonStateHandler> command = ToggleIconCommand.create(mockHandler);
        command.execute();
        Mockito.verify(mockHandler, Mockito.times(1)).toggleIcon();
    }

}
