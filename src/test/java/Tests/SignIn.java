package Tests;

import Pages.HomePage;
import Pages.SignInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignIn {

    private WebDriver driver = new ChromeDriver();
    private HomePage homePage = new HomePage(driver);
    private SignInPage signInPage = new SignInPage(driver);

    @Before
    public void setUp() {
        homePage.goTo();
    }

    @Test
    public void signInAsRegisteredUser() {
        //Arrange
        String userEmailAddress = "18101118417310519@testemail.com";
        String userPassword = "54994Qddd$$2_1";
        //Act
        homePage.navigateToSignIn();
        signInPage.submitLogInDetails(userEmailAddress, userPassword);
        //Assert
        Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
