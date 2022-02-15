package usertests;

import base.TestBase;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPageObject;
import pages.LogInPage;
import utils.UserFactory;

public class LogInTest extends TestBase {
    @BeforeMethod
    public void initPages() {
        logInPage = new LogInPage(driver);
        header = new HeaderPageObject(driver);
    }

    @Test
    public void shouldLogInUser() {
        header.enterSignIn();
        User user = UserFactory.getAlreadyRegisteredUser();
        logInPage.logIn(user);
        Assert.assertEquals(header.getMyAccountName(), user.getFirstName() + " " + user.getLastName());
        header.signOut();
    }
}