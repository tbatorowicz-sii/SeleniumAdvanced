package user;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.Header;
import pages.user.SignInPage;
import pages.user.SignUpPage;
import pages.user.YourAccountPage;
import pages.user.YourPersonalInformationPage;
import utils.UserFactory;

public class RegistrationTest extends TestBase {
    @BeforeMethod
    public void initialize() {
        signInPage = new SignInPage(driver);
        header = new Header(driver);
        signUpPage = new SignUpPage(driver);
        yourAccountPage = new YourAccountPage(driver);
        yourPersonalInformationPage = new YourPersonalInformationPage(driver);
        user = UserFactory.getRandomUser();
    }

    @Test
    public void shouldRegisterUser() {
        header.enterSignInPage();
        signInPage.enterSignUpPage();
        signUpPage.registerUser(user);
        header.enterYourAccountPage();
        yourAccountPage.enterYourPersonalInformationPage();
        yourPersonalInformationPage.dataAssertion(user);
        header.signOut();
        signInPage.signIn(user);
    }
}