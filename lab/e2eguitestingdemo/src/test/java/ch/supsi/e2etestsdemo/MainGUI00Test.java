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

public class MainGUI00Test extends ApplicationTest {

    private static int SLEEP_INTERVAL = 666;

    private static final Logger LOGGER = LoggerFactory.getLogger(MainGUI00Test.class);

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
        testMainScene();
        testFileMenu();
        testHelpMenu();
    }

    public void testMainScene() {
        step("main scene", () -> {
            verifyThat("#fileMenu", isVisible());
            verifyThat("#editMenu", isVisible());
            verifyThat("#helpMenu", isVisible());
            verifyThat("#cameraButton", isVisible());
            verifyThat("#infoButton", isVisible());
            verifyThat("#pencilButton", isVisible());
            verifyThat("#resetButton", isVisible());
            verifyThat("#console", TextInputControlMatchers.hasText(""));
        });
    }

    public void testFileMenu() {
        step("file menu", () -> {
            sleep(SLEEP_INTERVAL);
            clickOn("#fileMenu");
            verifyThat("#exitMenuItem", isVisible());
            verifyThat("#exitMenuItem", isEnabled());

            sleep(SLEEP_INTERVAL);
            clickOn("#fileMenu");
        });
    }

    public void testHelpMenu() {
        step("help menu", () -> {
            sleep(SLEEP_INTERVAL);
            clickOn("#helpMenu");
            verifyThat("#aboutMenuItem", isVisible());
            verifyThat("#aboutMenuItem", isEnabled());

            sleep(SLEEP_INTERVAL);
            clickOn("#helpMenu");
        });
    }

}
