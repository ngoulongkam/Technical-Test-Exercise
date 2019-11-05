package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

/**
 * Create by Ewan.Hardingham on the 5th Nov 2019
 */

public class SignInPage extends SourcePage {

    private static final StringBuilder BUILDER = new StringBuilder();
    private static final Random RANDOM = new Random();
    private static final By EMAIL_INPUT_REGBOX = By.cssSelector("#email_create");
    private static final By REGISTER_BUTTON = By.cssSelector("#SubmitCreate");
    private static final By EMAIL_INPUT_BOX = By.cssSelector("#email");
    private static final By PASSWORD_INPUT_BOX = By.cssSelector("#passwd");
    private static final By SIGN_IN_BUTTON = By.cssSelector("#SubmitLogin");


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    //A new email is required each time the registration method is ran else test will fail
    public String generateTestEmail() {
        BUILDER.append("@testemail.com");
        for (int i = 0; i < 10; i++) {
            String x = Integer.toString(RANDOM.nextInt(20));
            BUILDER.insert(0, x);
        }
        return BUILDER.toString();
    }

    public void startUserRegistration(String userEmailAddress) {
        findThenType(EMAIL_INPUT_REGBOX, userEmailAddress);
        waitThenClick(REGISTER_BUTTON);
    }

    public void submitLogInDetails(String userEmailAddress, String userPassword) {
        findThenType(EMAIL_INPUT_BOX, userEmailAddress);
        findThenType(PASSWORD_INPUT_BOX, userPassword);
        waitThenClick(SIGN_IN_BUTTON);
    }
}
