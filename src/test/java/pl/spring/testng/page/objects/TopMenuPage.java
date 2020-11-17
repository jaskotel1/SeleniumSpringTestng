package pl.spring.testng.page.objects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.testng.PageObject;
import pl.spring.testng.waits.WaitForElement;

@Log4j2
@PageObject
public class TopMenuPage {

    @Autowired
    private WaitForElement wait;

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signOnLink;

    public void clickOnSignInLink() {
        wait.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
        log.info("Clicked on Sign on Link");
    }
}
