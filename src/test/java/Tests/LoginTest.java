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

    @Test
    public void userCanLogIn() {
        String validUsername = "student";
        String validPassword = "Password123";
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
    }


}
