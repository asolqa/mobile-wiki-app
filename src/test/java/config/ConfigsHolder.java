package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigsHolder {
    INSTANCE;

    private static final BrowserStackConfig WEB_CONFIG = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

    private static final Credentials USER_CONFIG = ConfigFactory.create(Credentials.class, System.getProperties());

    private static final RunnerConfig RUNNER_CONFIG = ConfigFactory.create(RunnerConfig.class, System.getProperties());

    private static final LocalRunnerConfig LOCAL_RUNNER_CONFIG = ConfigFactory.create(LocalRunnerConfig.class, System.getProperties());


    public BrowserStackConfig browserStackConfig() {
        return WEB_CONFIG;
    }

    public Credentials credentials() {
        return USER_CONFIG;
    }

    public RunnerConfig runnerConfig() {
        return RUNNER_CONFIG;
    }

    public LocalRunnerConfig localRunnerConfig() {
        return LOCAL_RUNNER_CONFIG;
    }
}
