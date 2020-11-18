package pl.spring.testng.page.objects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.testng.PageObject;
import pl.spring.testng.configuration.YamlConfigurationProperties;

@PageObject
@Log4j2
public class Site {

    @Autowired
    private WebDriver driver;

    @Autowired
    private YamlConfigurationProperties yamlConfigurationProperties;

    @Autowired
    private  LandingPage landingPage;

    public LandingPage goToLandingPage() {
        driver.get(yamlConfigurationProperties.getDomain());
        log.info("Went to landing page");

        return landingPage;
    }
}
