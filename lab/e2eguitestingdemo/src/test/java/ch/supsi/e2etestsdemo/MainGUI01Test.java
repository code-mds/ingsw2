package ch.supsi.e2etestsdemo;

import javafx.stage.Stage;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.control.TextInputControlMatchers;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

public class MainGUI01Test extends ApplicationTest {

    private static int SLEEP_INTERVAL = 666;

    private static final Logger LOGGER = LoggerFactory.getLogger(MainGUI01Test.class);

    private int stepNo;

    MainGUI main;

    private void step(final String step, final Runnable runnable) {
        ++stepNo;
        LOGGER.info("STEP {}: {}", stepNo, step);
        runnable.run();
        LOGGER.info("STEP {}: End", stepNo);
    }

    @Override
    public void start(Stage stage) throws Exception {
        main = new MainGUI();
        main.start(stage);
    }

    @Test
    public void walkThrough() {
        testConsole();
        testExitCancel();
        testExitConfirm();
    }

    public void testConsole() {
        step("console", () -> {
            sleep(SLEEP_INTERVAL);
            clickOn("#cameraButton");

            verifyThat("#console",TextInputControlMatchers.hasText("model has changed since last time we asked!\n"));
        });
    }

    public void testExitCancel() {
        step("exit cancel", () -> {
            sleep(SLEEP_INTERVAL);
            clickOn("#fileMenu");
            verifyThat("#exitMenuItem", isVisible());
            verifyThat("#exitMenuItem", isEnabled());

            sleep(SLEEP_INTERVAL);
            clickOn("#exitMenuItem");
            verifyThat("#cancelButton", isVisible());
            verifyThat("#cancelButton", isEnabled());
            verifyThat("#okButton", isVisible());
            verifyThat("#okButton", isEnabled());

            sleep(SLEEP_INTERVAL);
            clickOn("#cancelButton");
        });
    }

    public void testExitConfirm() {
        step("exit confirm", () -> {
            sleep(SLEEP_INTERVAL);
            clickOn("#fileMenu");
            verifyThat("#exitMenuItem", isVisible());
            verifyThat("#exitMenuItem", isEnabled());

            sleep(SLEEP_INTERVAL);
            clickOn("#exitMenuItem");
        });
    }

}
