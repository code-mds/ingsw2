package ch.supsi.e2etestsdemo;

import javafx.stage.Stage;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

public class MainGUI03Test extends ApplicationTest {

    private static int SLEEP_INTERVAL = 666;


    private static final Logger LOGGER = LoggerFactory.getLogger(MainGUI03Test.class);

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
        testExit();
    }

    public void testExit() {
        step("exit", () -> {
            sleep(SLEEP_INTERVAL);
            clickOn("#fileMenu");
            verifyThat("#exitMenuItem", isVisible());
            verifyThat("#exitMenuItem", isEnabled());

            sleep(SLEEP_INTERVAL);
            clickOn("#exitMenuItem");
        });
    }

}
