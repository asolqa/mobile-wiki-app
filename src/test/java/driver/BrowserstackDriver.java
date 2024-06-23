package driver;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigHolder;
import config.Credentials;
import config.PlatformConfig;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    private final Credentials credentials = ConfigHolder.INSTANCE.credentials();

    private final PlatformConfig platformConfig = ConfigHolder.INSTANCE.platformConfig();

    @SneakyThrows
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        check();

        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", credentials.username());
        caps.setCapability("browserstack.key", credentials.userKey());

        // Set URL of the application under test
        caps.setCapability("app", platformConfig.appUrl());

        // Specify device and os_version for testing
        caps.setCapability("device", platformConfig.deviceName());
        caps.setCapability("os_version", platformConfig.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", platformConfig.project());
        caps.setCapability("build", platformConfig.build());
        caps.setCapability("name", platformConfig.name());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new RemoteWebDriver(new URL(platformConfig.remoteWebDriverUrl()), caps);
    }

    private void check() {
        if(platformConfig.deviceName() == null) {
            throw new IllegalArgumentException("Configuration is not set");
        }
    }
}