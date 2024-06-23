package config;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/common.properties",
        "classpath:config/android..properties"
})
public interface PlatformConfig extends Config {

    @Key("app.url")
    String appUrl();

    @Key("device.name")
    String deviceName();

    @Key("mobile.os.version")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();

    @Key("remote.web.driver.url")
    String remoteWebDriverUrl();
}
