package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Create by Ewan.Hardingham on the 5th Nov 2019
 */

public class HomePage extends SourcePage {

    private static final String HOME_PAGE = "http://automationpractice.com/index.php";
    private static final By SIGN_IN_BUTTON = By.cssSelector("a.login");
    private static final By LOG_OUT_BUTTON = By.cssSelector("#logout");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get(HOME_PAGE);
    }

    public void navigateToSignIn() {
        waitThenClick(SIGN_IN_BUTTON);
    }

    public void signUserOut() {
        waitThenClick(LOG_OUT_BUTTON);
    }

    public void selectNavButton(int navButtonIndex) {
        waitThenClick(By.cssSelector("#block_top_menu > ul > li:nth-child("+navButtonIndex+") > a"));
    }
}
