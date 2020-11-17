package pl.spring.testng.page.objects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.testng.PageObject;
import pl.spring.testng.waits.WaitForElement;

@Log4j2
@PageObject
public class LoginPage {

    @Autowired
    private WaitForElement wait;

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement signOnButton;

    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement messageLabel;

    public void typeIntoUserNameField(String username) {
        wait.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        log.info("Typed into User Name Field {}", username);
    }

    public void typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        log.info("Typed into Password Field {}", password);
    }

    public void clickOnLoginButton() {
        signOnButton.click();
        log.info("Clicked on Login Button");
    }

    public String getWarningMessage() {
        wait.waitUntilElementIsVisible(messageLabel);
        String warningText = messageLabel.getText();
        log.info("Returned warning message was: {}", warningText);
        return warningText;
    }
}
