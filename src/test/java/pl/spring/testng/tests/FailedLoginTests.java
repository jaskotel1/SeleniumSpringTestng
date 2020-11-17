package pl.spring.testng.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pl.spring.testng.page.objects.LandingPage;
import pl.spring.testng.page.objects.LoginPage;
import pl.spring.testng.page.objects.Site;
import pl.spring.testng.page.objects.TopMenuPage;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests extends BaseTest {

    @Autowired
    private LandingPage landingPage;
    @Autowired
    private TopMenuPage topMenuPage;
    @Autowired
    private LoginPage loginPage;
    @Autowired
    private Site site;

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
