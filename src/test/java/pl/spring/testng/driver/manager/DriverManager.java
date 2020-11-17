package pl.spring.testng.driver.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pl.spring.testng.configuration.YamlConfigurationProperties;
import pl.spring.testng.driver.BrowserType;

@Getter
@Configuration
@ComponentScan(basePackageClasses = DriverManager.class)
public class DriverManager {

    @Autowired
    private YamlConfigurationProperties yamlConfigurationProperties;

    public WebDriver getBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case IE:
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }
    }

    @Bean
    @Scope("test")
    public WebDriver webDriver() {
        return getBrowser(BrowserType.valueOf(yamlConfigurationProperties.getBrowser()));
    }
}
