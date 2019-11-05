package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Create by Ewan.Hardingham on the 5th Nov 2019
 */

public class RegistrationPage extends SourcePage {

    private static final By MR_RADIO_BUTTON = By.cssSelector("#id_gender1");
    private static final By FIRST_NAME_BOX = By.cssSelector("#customer_firstname");
    private static final By SECOND_NAME_BOX = By.cssSelector("#customer_lastname");
    private static final By PASSWORD_BOX = By.cssSelector("#passwd");
    private static final By DOB_DAY = By.cssSelector("#days");
    private static final By DOB_MONTH = By.cssSelector("#months");
    private static final By DOB_YEAR = By.cssSelector("#years");
    private static final By FIRST_NAME_ADDRESS_BOX = By.cssSelector("#firstname");
    private static final By SECOND_NAME_ADDRESS_BOX = By.cssSelector("#lastname");
    private static final By ADDRESS_BOX1 = By.cssSelector("#address1");
    private static final By CITY_BOX = By.cssSelector("#city");
    private static final By STATE_DROPDOWN = By.cssSelector("#id_state");
    private static final By POST_CODE_BOX = By.cssSelector("#postcode");
    private static final By MOBILE_NUMBER_BOX = By.cssSelector("#phone_mobile");
    private static final By SUBMIT_BUTTON = By.cssSelector("#submitAccount");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    public void fillInUserDetails() {

        waitThenClick(MR_RADIO_BUTTON);
        findThenType(FIRST_NAME_BOX, "John");
        findThenType(SECOND_NAME_BOX, "Doe");
        findThenType(PASSWORD_BOX, "54994Qddd$$2_1");
        Select dateOfBirthDay = new Select(driver.findElement(DOB_DAY));
        Select dateOfBirthMonth = new Select(driver.findElement(DOB_MONTH));
        Select dateOfBirthYear = new Select(driver.findElement(DOB_YEAR));
        makeDropdownSelection(dateOfBirthDay, 5);
        makeDropdownSelection(dateOfBirthMonth, 5);
        makeDropdownSelection(dateOfBirthYear, 5);
        findThenType(FIRST_NAME_ADDRESS_BOX, "John");
        findThenType(SECOND_NAME_ADDRESS_BOX, "Doe");
        findThenType(ADDRESS_BOX1, "50 Testing Lane");
        findThenType(CITY_BOX, "Testing City");
        Select state = new Select(driver.findElement(STATE_DROPDOWN));
        makeDropdownSelection(state, 5);
        findThenType(POST_CODE_BOX, "44646");
        findThenType(MOBILE_NUMBER_BOX, "070000000000");
    }

    public void submitRegistrationDetails() {
        waitThenClick(SUBMIT_BUTTON);
    }
}
