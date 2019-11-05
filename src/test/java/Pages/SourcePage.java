package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class SourcePage {

    WebDriver driver;
    WebDriverWait wait;

    SourcePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

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
