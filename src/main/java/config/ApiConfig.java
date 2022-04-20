package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ApiConfig extends Config {
    String env();

    @Key("service_${env}_url")
    String baseUrl();

}
