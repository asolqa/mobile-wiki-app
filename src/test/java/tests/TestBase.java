package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigsHolder;
import config.RunnerConfig;
import driver.BrowserstackDriver;
import helpers.AttachmentHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    private static final RunnerConfig RUNNER_CONFIG = ConfigsHolder.INSTANCE.runnerConfig();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = RUNNER_CONFIG.driverClassname();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        System.out.println(sessionId);

        runCodeSafely(() -> AttachmentHelper.screenshotAs("Last screenshot"));
        runCodeSafely(AttachmentHelper::pageSource);

        closeWebDriver();
        if(BrowserstackDriver.class.getName().equals(RUNNER_CONFIG.driverClassname())) {
            runCodeSafely(() -> AttachmentHelper.addVideo(sessionId));
        }
    }

    private static void runCodeSafely(Runnable code) {
        try {
            code.run();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
            throwable.printStackTrace();
        }
    }
}
