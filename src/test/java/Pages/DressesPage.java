package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Create by Ewan.Hardingham on the 5th Nov 2019
 */

public class DressesPage extends SourcePage{


    private static final By SORT_PRODUCT_DROPDOWN = By.cssSelector("#selectProductSort");
    private static final By FIRST_ITEM_PRODUCT_IMAGE = By.cssSelector("ul > li:first-child > div.product-container");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector("a.button.ajax_add_to_cart_button.btn.btn-default");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector(".layer_cart_cart.col-xs-12.col-md-6 > div > a");
    private final Actions action = new Actions(driver);

    public DressesPage(WebDriver driver) {
        super(driver);
    }

    public void filterDressesByHighestToLowest() {
        wait.until(ExpectedConditions.elementToBeClickable(FIRST_ITEM_PRODUCT_IMAGE));
        Select sortProduct = new Select(driver.findElement(SORT_PRODUCT_DROPDOWN));
        sortProduct.selectByVisibleText("Price: Highest first");
    }

    public void addMostExpensiveProductToCart() {
        try { wait.until(ExpectedConditions.elementToBeClickable(FIRST_ITEM_PRODUCT_IMAGE));
        } catch (TimeoutException e) {
            Assert.fail("Took too long to sort items");
        }
        WebElement firstProduct = driver.findElement(FIRST_ITEM_PRODUCT_IMAGE);
        action.moveToElement(firstProduct);
        action.click(driver.findElement(ADD_TO_CART_BUTTON)).perform();
    }

    public void proceedToCheckOutPage() {
        waitThenClick(PROCEED_TO_CHECKOUT_BUTTON);
    }

}
