package usertests;

import base.TestBase;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.UserFactory;

public class RegistrationTest extends TestBase {
    @BeforeMethod
    public void initPages() {
        logInPage = new LogInPage(driver);
        header = new HeaderPageObject(driver);
        registrationPage = new RegistrationPage(driver);
        yourAccountPage = new YourAccountPage(driver);
        yourPersonalInformationPage = new YourPersonalInformationPage(driver);
    }

    @Test
    public void shouldRegisterUser() {
        header.enterSignInPage();
        logInPage.enterCreateAccountPage();
        User user = UserFactory.getRandomUser();
        registrationPage.registerRandomUser(user);
        header.enterMyAccountPage();
        yourAccountPage.enterPersonalInformationPage();
        yourPersonalInformationPage.isDataDisplayedCorrectly(user);
        header.signOut();
        logInPage.logIn(user);
    }
}