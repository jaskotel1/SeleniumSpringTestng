package pl.spring.testng.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value = "classpath:configuration.yml", factory = YamlPropertySourceFactory.class)
@Data
public class YamlConfigurationProperties {
    private String domain;
    private String browser;


}
