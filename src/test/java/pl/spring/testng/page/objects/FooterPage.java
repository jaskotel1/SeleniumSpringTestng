package pl.spring.testng.page.objects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.testng.PageObject;
import pl.spring.testng.waits.WaitForElement;

@Log4j2
@PageObject
public class FooterPage {

    @Autowired
    private WaitForElement wait;

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLoginLogo;

    public boolean isBannerAfterLoginDisplayed() {
        wait.waitUntilElementIsVisible(bannerAfterLoginLogo);
        boolean isDisplayed = bannerAfterLoginLogo.isDisplayed();
        log.info("Returning status of banner after login: {}", isDisplayed);
        return isDisplayed;
    }
}
