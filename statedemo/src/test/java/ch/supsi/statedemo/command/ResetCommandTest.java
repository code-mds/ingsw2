package ch.supsi.statedemo.command;


import ch.supsi.guiframework.command.AbstractCommand;
import ch.supsi.guiframework.command.Command;
import ch.supsi.statedemo.model.ButtonStateHandler;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ResetCommandTest {

    @Test
    public void constructor0() {
        ResetCommand<ButtonStateHandler> command = new ResetCommand(null);
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof AbstractCommand);
        Assert.assertTrue(command instanceof Command);
    }

    @Test
    public void constructor1() {
        ButtonStateHandler modelMock = Mockito.mock(ButtonStateHandler.class);

        ResetCommand<ButtonStateHandler> command = new ResetCommand(modelMock);
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof AbstractCommand);
        Assert.assertTrue(command instanceof Command);
    }

    @Test(expected = InstantiationException.class)
    public void create0() throws InstantiationException {
        ResetCommand.create(null);
    }

    @Test
    public void create1() throws InstantiationException {
        ButtonStateHandler mockHandler = Mockito.mock(ButtonStateHandler.class);

        ResetCommand<ButtonStateHandler> command = ResetCommand.create(mockHandler);
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof AbstractCommand);
        Assert.assertTrue(command instanceof Command);
    }

    @Test(expected = NoSuchFieldException.class)
    public void execute0() throws NoSuchFieldException {
        ResetCommand<ButtonStateHandler> command = new ResetCommand(null);
        command.execute();
    }

    @Test
    public void execute1() throws InstantiationException, NoSuchFieldException {
        ButtonStateHandler mockHandler = Mockito.mock(ButtonStateHandler.class);

        ResetCommand<ButtonStateHandler> command = ResetCommand.create(mockHandler);
        command.execute();
        Mockito.verify(mockHandler, Mockito.times(1)).reset();
    }

}
