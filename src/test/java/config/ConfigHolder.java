package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigHolder {
    INSTANCE;

    private static final PlatformConfig WEB_CONFIG = ConfigFactory.create(PlatformConfig.class, System.getProperties());

    private static final Credentials USER_CONFIG = ConfigFactory.create(Credentials.class, System.getProperties());

    public PlatformConfig platformConfig() {
        return WEB_CONFIG;
    }

    public Credentials credentials() {
        return USER_CONFIG;
    }
}
