package pl.spring.testng.page.objects;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.testng.PageObject;
import pl.spring.testng.configuration.YamlConfigurationProperties;

@PageObject
public class Site {

    @Autowired
    private WebDriver driver;

    @Autowired
    private YamlConfigurationProperties yamlConfigurationProperties;

    @Autowired
    private  LandingPage landingPage;

    public LandingPage goToLandingPage() {
        driver.get(yamlConfigurationProperties.getDomain());
        return landingPage;
    }
}
