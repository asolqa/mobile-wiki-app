package driver;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigsHolder;
import config.LocalRunnerConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;

import java.io.File;
import java.io.InputStream;
import java.net.URL;


@SuppressWarnings("unused")
public class LocalDriver implements WebDriverProvider {

    private static final LocalRunnerConfig CONFIG = ConfigsHolder.INSTANCE.localRunnerConfig();

    @SneakyThrows
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAutomationName(CONFIG.automationName())
                .setPlatformName(CONFIG.platformName())
                .setPlatformVersion(CONFIG.platformVersion())
                .setDeviceName(CONFIG.deviceName())
                .setApp(getAppPath())
                .setAppPackage(CONFIG.packageName())
                .setAppActivity(CONFIG.mainActivity());

        return new AndroidDriver(CONFIG.driverUrl(), options);
    }

    @SneakyThrows
    private String getAppPath() {
        URL appUrl = CONFIG.downloadUrl();
        String appPath = "src/test/resources/apps/" + CONFIG.appVersion();

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = appUrl.openStream()) {
                FileUtils.copyInputStreamToFile(in, app);
            }
        }
        return app.getAbsolutePath();
    }
}
