package config;

import org.aeonbits.owner.ConfigFactory;
import config.ApiConfig;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private Config() {
        throw new IllegalStateException("Utility class");
    }

    public static ApiConfig getApiConfig() {
        String environment = System.getProperty("env");

        if (environment == null) {
            environment = "test";
        }

        Map<String, String> apiEnv = new HashMap<>();
        apiEnv.put("env", environment);

        return ConfigFactory.create(ApiConfig.class, apiEnv);
    }
}
