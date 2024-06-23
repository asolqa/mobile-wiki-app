package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/credentials.properties"
})
public interface Credentials extends Config {

    @Key("username")
    String username();

    @Key("user.key")
    String userKey();
}
