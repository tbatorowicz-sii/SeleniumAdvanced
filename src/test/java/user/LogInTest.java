package user;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.Header;
import pages.user.LogInPage;
import utils.UserFactory;

public class LogInTest extends TestBase {
    @BeforeMethod
    public void initialize() {
        logInPage = new LogInPage(driver);
        header = new Header(driver);
        user = UserFactory.getAlreadyRegisteredUser();
    }

    @Test
    public void shouldLogInUser() {
        header.enterSignInPage();
        logInPage.logIn(user);
        Assert.assertEquals(header.getMyAccountName(), user.getFirstName() + " " + user.getLastName());
        header.signOut();
    }
}