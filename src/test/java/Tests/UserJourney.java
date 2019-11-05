package Tests;

import Pages.CheckoutPage;
import Pages.DressesPage;
import Pages.HomePage;
import Pages.SignInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Create by Ewan.Hardingham on the 5th Nov 2019
 */

public class UserJourney {

    private WebDriver driver = new ChromeDriver();
    private HomePage homePage = new HomePage(driver);
    private SignInPage signInPage = new SignInPage(driver);
    private DressesPage dressesPage = new DressesPage(driver);
    private CheckoutPage checkoutPage = new CheckoutPage(driver);
    private String userEmailAddress = "18101118417310519@testemail.com";
    private String userPassword = "54994Qddd$$2_1";

    @Before
    public void setUp() {
        homePage.goTo();
    }

    @Test
    public void addMostExpensiveDressToCart() {
        //Arrange
        homePage.navigateToSignIn();
        signInPage.submitLogInDetails(userEmailAddress, userPassword);
        homePage.goTo();
        //Act
        homePage.selectNavButton(2);
        dressesPage.filterDressesByHighestToLowest();
        dressesPage.addMostExpensiveProductToCart();
        dressesPage.proceedToCheckOutPage();
        //Assert
        Assert.assertEquals("http://automationpractice.com/index.php?controller=order", driver.getCurrentUrl());
    }

    @Test
    public void checkProductAlwaysRemainsInUserCart() {
        //Arrange
        //Act
        homePage.navigateToSignIn();
        signInPage.submitLogInDetails(userEmailAddress, userPassword);
        checkoutPage.goToViaCartButton();
        //Assert
        checkoutPage.checkCartIsNotEmpty();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
