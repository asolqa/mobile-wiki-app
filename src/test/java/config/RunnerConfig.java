package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/runner.properties"
})
public interface RunnerConfig extends Config {

    @Key("driver.class.name")
    String driverClassname();
}
