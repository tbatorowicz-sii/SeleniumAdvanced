package user;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.Header;
import pages.user.SignInPage;
import utils.UserFactory;

public class LogInTest extends TestBase {
    @BeforeMethod
    public void initialize() {
        signInPage = new SignInPage(driver);
        header = new Header(driver);
        user = UserFactory.getAlreadyRegisteredUser();
    }

    @Test
    public void shouldLogInUser() {
        header.enterSignInPage();
        signInPage.signIn(user);
        header.assertIfLoggedIn(user);
        header.signOut();
    }
}