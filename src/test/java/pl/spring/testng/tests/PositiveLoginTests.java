package pl.spring.testng.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pl.spring.testng.page.objects.*;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PositiveLoginTests extends BaseTest {

    @Autowired
    private Site site;
    @Autowired
    private LoginPage loginPage;
    @Autowired
    private FooterPage footerPage;

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        site
                .goToLandingPage()
                .clickOnEnterStoreLink()
                .clickOnSignInLink()
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton();

        assertTrue(footerPage.isBannerAfterLoginDisplayed());
    }

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        site
                .goToLandingPage()
                .clickOnEnterStoreLink()
                .clickOnSignInLink()
                .typeIntoUserNameField("NotExistingLogin")
                .typeIntoPasswordField("NotProperPassword")
                .clickOnLoginButton();

        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }
}
