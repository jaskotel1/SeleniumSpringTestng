package pl.spring.testng.page.objects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.testng.PageObject;
import pl.spring.testng.waits.WaitForElement;

@Log4j2
@PageObject
public class LandingPage {

    @Autowired
    private WaitForElement wait;

    @Autowired
    private TopMenuPage topMenuPage;

    @FindBy(css = "#Content a")
    private WebElement enterStoreLink;

    public TopMenuPage clickOnEnterStoreLink() {
        wait.waitUntilElementIsClickable(enterStoreLink);
        enterStoreLink.click();
        log.info("Clicked on Enter Store link");

        return topMenuPage;
    }
}
