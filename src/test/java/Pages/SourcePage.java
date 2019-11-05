package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Create by Ewan.Hardingham on the 5th Nov 2019
 */

abstract class SourcePage {

    WebDriver driver;
    WebDriverWait wait;

    //Each page will need a driver to run automation tasks
    SourcePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }


    //Common driver tasks that will be used on each page
    void waitThenClick(By selector) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
    }

    void findThenType(By selector, String input) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.sendKeys(input);
    }

    void makeDropdownSelection(Select dropdown, int index) {
        dropdown.selectByIndex(index);
    }

}
