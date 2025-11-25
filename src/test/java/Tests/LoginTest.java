package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://practicetestautomation.com/");
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
    }

    @Test(priority = 1)
    public void userCanLogIn() {
        String validUsername = "student";
        String validPassword = "Password123";
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test(priority = 2)
    public void userCannotLogInWithInvalidUsername() {
        String invalidUsername = "non student";
        String validPassword = "Password123";
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        String expectedErrorMessage = "Your username is invalid!";
        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(loginPage.getError().getText(), expectedErrorMessage);
    }

    @Test(priority = 3)
    public void userCannotLogInWithInvalidPassword() {
        String validUsername = "student";
        String invalidPassword = "assword123";
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        String expectedErrorMessage = "Your password is invalid!";
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(loginPage.getError().getText(), expectedErrorMessage);
    }


}
