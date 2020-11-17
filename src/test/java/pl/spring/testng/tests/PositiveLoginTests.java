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
    private LandingPage landingPage;
    @Autowired
    private TopMenuPage topMenuPage;
    @Autowired
    private LoginPage loginPage;
    @Autowired
    private FooterPage footerPage;

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        site.goToLandingPage();

        landingPage.clickOnEnterStoreLink();

        topMenuPage.clickOnSignInLink();

        loginPage.typeIntoUserNameField("j2ee");
        loginPage.typeIntoPasswordField("j2ee");
        loginPage.clickOnLoginButton();

        assertTrue(footerPage.isBannerAfterLoginDisplayed());
    }

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        site.goToLandingPage();

        landingPage.clickOnEnterStoreLink();

        topMenuPage.clickOnSignInLink();

        loginPage.typeIntoUserNameField("NotExistingLogin");
        loginPage.typeIntoPasswordField("NotProperPassword");
        loginPage.clickOnLoginButton();
        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }
}
