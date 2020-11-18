package pl.spring.testng.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pl.spring.testng.page.objects.LoginPage;
import pl.spring.testng.page.objects.Site;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests extends BaseTest {

    @Autowired
    private Site site;

    @Autowired
    private LoginPage loginPage;

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
