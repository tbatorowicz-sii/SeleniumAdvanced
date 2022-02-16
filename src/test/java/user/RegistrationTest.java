package user;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.Header;
import pages.user.LogInPage;
import pages.user.RegistrationPage;
import pages.user.YourAccountPage;
import pages.user.YourPersonalInformationPage;
import utils.UserFactory;

public class RegistrationTest extends TestBase {
    @BeforeMethod
    public void initialize() {
        logInPage = new LogInPage(driver);
        header = new Header(driver);
        registrationPage = new RegistrationPage(driver);
        yourAccountPage = new YourAccountPage(driver);
        yourPersonalInformationPage = new YourPersonalInformationPage(driver);
        user = UserFactory.getRandomUser();
    }

    @Test
    public void shouldRegisterUser() {
        header.enterSignInPage();
        logInPage.enterCreateAccountPage();
        registrationPage.registerRandomUser(user);
        header.enterMyAccountPage();
        yourAccountPage.enterPersonalInformationPage();
        yourPersonalInformationPage.isDataDisplayedCorrectly(user);
        header.signOut();
        logInPage.logIn(user);
    }
}