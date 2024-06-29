package driver;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigsHolder;
import config.Credentials;
import config.BrowserStackConfig;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.URL;

@SuppressWarnings("unused")
public class BrowserstackDriver implements WebDriverProvider {

    private static final Credentials USER_CREDENTIALS = ConfigsHolder.INSTANCE.credentials();

    private static final BrowserStackConfig BROWSER_STACK_CONFIG = ConfigsHolder.INSTANCE.browserStackConfig();

    @SneakyThrows
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        check();

        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", USER_CREDENTIALS.username());
        caps.setCapability("browserstack.key", USER_CREDENTIALS.userKey());

        // Set URL of the application under test
        caps.setCapability("app", BROWSER_STACK_CONFIG.appUrl());

        // Specify device and os_version for testing
        caps.setCapability("device", BROWSER_STACK_CONFIG.deviceName());
        caps.setCapability("os_version", BROWSER_STACK_CONFIG.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", BROWSER_STACK_CONFIG.project());
        caps.setCapability("build", BROWSER_STACK_CONFIG.build());
        caps.setCapability("name", BROWSER_STACK_CONFIG.name());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new RemoteWebDriver(new URL(BROWSER_STACK_CONFIG.remoteWebDriverUrl()), caps);
    }

    private void check() {
        if(BROWSER_STACK_CONFIG.deviceName() == null) {
            throw new IllegalArgumentException("Configuration is not set");
        }
    }
}