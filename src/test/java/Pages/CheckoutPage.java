package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Create by Ewan.Hardingham on the 5th Nov 2019
 */

public class CheckoutPage extends SourcePage {

    private static final By PROCEED_TO_CART_BUTTON = By.cssSelector("div.shopping_cart > a");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void goToViaCartButton() {
        waitThenClick(PROCEED_TO_CART_BUTTON);
    }

    public void checkCartIsNotEmpty() {
        if (driver.getPageSource().contains("Your shopping cart is empty.")) {
            Assert.fail("Test failed: no products in the users checkout cart.");
        } else {
            Assert.assertTrue(true);
        }
    }
}
