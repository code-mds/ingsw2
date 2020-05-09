package ch.supsi.e2etestsdemo.command;


import ch.supsi.guiframework.command.AbstractCommand;
import ch.supsi.guiframework.command.Command;
import ch.supsi.e2etestsdemo.model.ButtonStateHandler;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ToggleTextCommandTest {

    @Test
    public void constructor0() {
        ToggleTextCommand<ButtonStateHandler> command = new ToggleTextCommand(null);
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof AbstractCommand);
        Assert.assertTrue(command instanceof Command);
    }

    @Test
    public void constructor1() {
        ButtonStateHandler modelMock = Mockito.mock(ButtonStateHandler.class);

        ToggleTextCommand<ButtonStateHandler> command = new ToggleTextCommand(modelMock);
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof AbstractCommand);
        Assert.assertTrue(command instanceof Command);
    }

    @Test(expected = InstantiationException.class)
    public void create0() throws InstantiationException {
        ToggleTextCommand.create(null);
    }

    @Test
    public void create1() throws InstantiationException {
        ButtonStateHandler mockHandler = Mockito.mock(ButtonStateHandler.class);

        ToggleTextCommand<ButtonStateHandler> command = ToggleTextCommand.create(mockHandler);
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof AbstractCommand);
        Assert.assertTrue(command instanceof Command);
    }

    @Test(expected = NoSuchFieldException.class)
    public void execute0() throws NoSuchFieldException {
        ToggleTextCommand<ButtonStateHandler> command = new ToggleTextCommand(null);
        command.execute();
    }

    @Test
    public void execute1() throws InstantiationException, NoSuchFieldException {
        ButtonStateHandler mockHandler = Mockito.mock(ButtonStateHandler.class);

        ToggleTextCommand<ButtonStateHandler> command = ToggleTextCommand.create(mockHandler);
        command.execute();
        Mockito.verify(mockHandler, Mockito.times(1)).toggleText();
    }

}
