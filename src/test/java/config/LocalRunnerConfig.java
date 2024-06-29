package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/local_runner.properties"
})
public interface LocalRunnerConfig extends Config {

    @Key("local.run.automation.name")
    String automationName();

    @Key("local.run.platform.name")
    String platformName();

    @Key("local.run.device.name")
    String deviceName();

    @Key("local.run.platform.version")
    String platformVersion();

    @Key("local.run.app.package.name")
    String packageName();

    @Key("local.run.app.main.activity")
    String mainActivity();

    @Key("local.run.app.version")
    String appVersion();

    @Key("local.run.app.download.url")
    URL downloadUrl();

    @Key("local.run.driver.url")
    URL driverUrl();

}
