package Tests;

import Pages.HomePage;
import Pages.RegistrationPage;
import Pages.SignInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration{

    private WebDriver driver = new ChromeDriver();
    private HomePage homePage = new HomePage(driver);
    private SignInPage signInPage = new SignInPage(driver);
    private RegistrationPage registrationPage = new RegistrationPage(driver);

    @Before
    public void setUp() {
        homePage.goTo();
    }

    @Test
    public void registerANewUser() {
        //Arrange
        //Act
        homePage.navigateToSignIn();
        String emailAddress = signInPage.generateTestEmail();
        signInPage.startUserRegistration(emailAddress);
        registrationPage.fillInUserDetails();
        registrationPage.submitRegistrationDetails();
        //Assert
        Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
