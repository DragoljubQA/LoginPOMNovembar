package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://practicetestautomation.com/");
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
    }

    @Test
    public void userCanLogOut() {
        String validUsername = "student";
        String validPassword = "Password123";
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        profilePage.clickOnLogOutButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

}
