package config;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/browser_stack_runner.properties"
})
public interface BrowserStackConfig extends Config {

    @Key("browserstack.run.app.url")
    String appUrl();

    @Key("browserstack.run.device.name")
    String deviceName();

    @Key("browserstack.run.mobile.os.version")
    String osVersion();

    @Key("browserstack.run.project")
    String project();

    @Key("browserstack.run.build")
    String build();

    @Key("browserstack.run.name")
    String name();

    @Key("browserstack.run.remote.web.driver.url")
    String remoteWebDriverUrl();
}
