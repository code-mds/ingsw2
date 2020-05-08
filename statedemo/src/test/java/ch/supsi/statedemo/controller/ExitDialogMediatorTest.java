package ch.supsi.statedemo.controller;

import ch.supsi.guiframework.command.CancelCommand;
import ch.supsi.guiframework.command.OkCommand;
import ch.supsi.guiframework.component.MyMessageDialog;
import ch.supsi.guiframework.controller.AbstractController;
import ch.supsi.guiframework.model.CancelHandler;
import ch.supsi.guiframework.model.DataHandler;
import ch.supsi.guiframework.model.ExitHandler;
import ch.supsi.guiframework.model.OkHandler;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class ExitDialogMediatorTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void constructor0() {
        ExitDialogMediator mediator = new ExitDialogMediator(null);
        Assert.assertNotNull(mediator);
        Assert.assertTrue(mediator instanceof AbstractController);
        Assert.assertTrue(mediator instanceof ExitHandler);
        Assert.assertTrue(mediator instanceof CancelHandler);
        Assert.assertTrue(mediator instanceof OkHandler);
        Assert.assertNull(mediator.getModel());
        Assert.assertNull(ExitDialogMediator.confirmationDialog);
        Assert.assertNull(mediator.owner);
        Assert.assertNull(mediator.cancelCommand);
        Assert.assertNull(mediator.okCommand);
    }

    @Test
    public void constructor1() {
        DataHandler modelMock = Mockito.mock(DataHandler.class);

        ExitDialogMediator mediator = new ExitDialogMediator(modelMock);
        Assert.assertNotNull(mediator);
        Assert.assertTrue(mediator instanceof AbstractController);
        Assert.assertTrue(mediator instanceof ExitHandler);
        Assert.assertTrue(mediator instanceof CancelHandler);
        Assert.assertTrue(mediator instanceof OkHandler);
        Assert.assertNotNull(mediator.getModel());
        Assert.assertNull(ExitDialogMediator.confirmationDialog);
        Assert.assertNull(mediator.owner);
        Assert.assertNull(mediator.cancelCommand);
        Assert.assertNull(mediator.okCommand);
    }

    @Test
    public void create0() throws IllegalArgumentException {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("controller model cannot be null!");

        ExitDialogMediator.create(null);
    }

    @Test
    public void create1() {
        DataHandler modelMock = Mockito.mock(DataHandler.class);

        ExitDialogMediator mediator = ExitDialogMediator.create(modelMock);
        Assert.assertNotNull(mediator);
        Assert.assertTrue(mediator instanceof AbstractController);
        Assert.assertTrue(mediator instanceof ExitHandler);
        Assert.assertTrue(mediator instanceof CancelHandler);
        Assert.assertTrue(mediator instanceof OkHandler);
        Assert.assertNotNull(mediator.getModel());
        Assert.assertNull(ExitDialogMediator.confirmationDialog);
        Assert.assertNull(mediator.owner);
        Assert.assertNull(mediator.cancelCommand);
        Assert.assertNull(mediator.okCommand);
    }

    @Test
    public void setCancelCommand0() {
        CancelCommand cancelCommandMock = Mockito.mock(CancelCommand.class);
        DataHandler modelMock = Mockito.mock(DataHandler.class);

        ExitDialogMediator mediator = new ExitDialogMediator(modelMock);
        mediator.setCancelCommand(cancelCommandMock);

        Assert.assertNotNull(mediator.cancelCommand);
        Assert.assertEquals(cancelCommandMock, mediator.cancelCommand);
    }

    @Test
    public void setOkCommand0() {
        OkCommand okCommandMock = Mockito.mock(OkCommand.class);
        DataHandler modelMock = Mockito.mock(DataHandler.class);

        ExitDialogMediator mediator = new ExitDialogMediator(modelMock);
        mediator.setOkCommand(okCommandMock);

        Assert.assertNotNull(mediator.okCommand);
        Assert.assertEquals(okCommandMock, mediator.okCommand);
    }

    @Test
    public void setOwner0() {
        Stage ownerStageMock = Mockito.mock(Stage.class);
        DataHandler modelMock = Mockito.mock(DataHandler.class);

        ExitDialogMediator mediator = new ExitDialogMediator(modelMock);
        mediator.setOwner(ownerStageMock);

        Assert.assertNotNull(mediator.owner);
        Assert.assertEquals(ownerStageMock, mediator.owner);
    }

    @Test
    public void maybeExit0() throws NoSuchFieldException {
        exceptionRule.expect(NoSuchFieldException.class);
        exceptionRule.expectMessage("cancel command is null!");

        OkCommand okCommandMock = Mockito.mock(OkCommand.class);
        DataHandler modelMock = Mockito.mock(DataHandler.class);

        ExitDialogMediator mediator = new ExitDialogMediator(modelMock);
        mediator.setCancelCommand(null);
        mediator.setOkCommand(okCommandMock);

        mediator.controlExit();
    }

    @Test
    public void maybeExit1() throws NoSuchFieldException {
        exceptionRule.expect(NoSuchFieldException.class);
        exceptionRule.expectMessage("ok command is null!");

        CancelCommand cancelCommandMock = Mockito.mock(CancelCommand.class);
        DataHandler modelMock = Mockito.mock(DataHandler.class);

        ExitDialogMediator mediator = new ExitDialogMediator(modelMock);
        mediator.setCancelCommand(cancelCommandMock);
        mediator.setOkCommand(null);

        mediator.controlExit();
    }

    @Test
    public void maybeExit2() throws NoSuchFieldException {
        // model isChanged() returns false
        // verify we call our exit method once

        CancelCommand cancelCommandMock = Mockito.mock(CancelCommand.class);
        OkCommand okCommandMock = Mockito.mock(OkCommand.class);
        DataHandler modelMock = Mockito.mock(DataHandler.class);
        Stage ownerStageMock = Mockito.mock(Stage.class);

        ExitDialogMediator mediator = new ExitDialogMediator(modelMock);
        mediator.setCancelCommand(cancelCommandMock);
        mediator.setOkCommand(okCommandMock);
        mediator.setOwner(ownerStageMock);

        ExitDialogMediator mediatorSpy = Mockito.spy(mediator);
        Mockito.when(modelMock.isChanged()).thenReturn(false);

        mediatorSpy.controlExit();
        Mockito.verify(mediatorSpy, Mockito.times(1)).exit();
    }

    @Test
    public void maybeExit3() throws NoSuchFieldException {
        // model isChanged() returns true
        // verify we call our the confirmation dialog's show method once

        CancelCommand cancelCommandMock = Mockito.mock(CancelCommand.class);
        OkCommand okCommandMock = Mockito.mock(OkCommand.class);
        DataHandler modelMock = Mockito.mock(DataHandler.class);
        Stage ownerStageMock = Mockito.mock(Stage.class);
        ExitDialogMediator.confirmationDialog = Mockito.mock(MyMessageDialog.class);

        ExitDialogMediator mediator = new ExitDialogMediator(modelMock);
        mediator.setCancelCommand(cancelCommandMock);
        mediator.setOkCommand(okCommandMock);
        mediator.setOwner(ownerStageMock);

        ExitDialogMediator mediatorSpy = Mockito.spy(mediator);
        Mockito.when(modelMock.isChanged()).thenReturn(true);

        mediatorSpy.controlExit();
        Mockito.verify(ExitDialogMediator.confirmationDialog, Mockito.times(1)).show();

        // unmock static property
        ExitDialogMediator.confirmationDialog = null;
    }

    @Test
    public void exit0() throws NoSuchFieldException {
        DataHandler modelMock = Mockito.mock(DataHandler.class);

        ExitDialogMediator mediator = new ExitDialogMediator(modelMock);
        mediator.owner = Mockito.mock(Stage.class);

        mediator.exit();
        Mockito.verify(mediator.owner, Mockito.times(1)).close();
    }

    @Test
    public void cancel0() throws NoSuchFieldException {
        DataHandler modelMock = Mockito.mock(DataHandler.class);

        ExitDialogMediator mediator = new ExitDialogMediator(modelMock);
        ExitDialogMediator.confirmationDialog = Mockito.mock(MyMessageDialog.class);

        mediator.cancel();
        Mockito.verify(ExitDialogMediator.confirmationDialog, Mockito.times(1)).close();

        // unmock static property
        ExitDialogMediator.confirmationDialog = null;
    }

    @Test
    public void ok0() throws NoSuchFieldException {
        DataHandler modelMock = Mockito.mock(DataHandler.class);

        ExitDialogMediator mediator = new ExitDialogMediator(modelMock);
        mediator.owner = Mockito.mock(Stage.class);
        ExitDialogMediator.confirmationDialog = Mockito.mock(MyMessageDialog.class);

        mediator.ok();
        Mockito.verify(ExitDialogMediator.confirmationDialog, Mockito.times(1)).close();
        Mockito.verify(mediator.owner, Mockito.times(1)).close();

        // unmock static property
        ExitDialogMediator.confirmationDialog = null;
    }

}
