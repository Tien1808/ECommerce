package Commons;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Wait {
    private final static int TIMEOUT = 10;

    public static void waitUntilElementDisplayed(final WebElement webElement, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        ExpectedCondition elementIsDisplayed = (ExpectedCondition<Boolean>) arg0 -> {
            try {
                webElement.isDisplayed();
                return true;
            }
            catch (NoSuchElementException e ) {
                return false;
            }
            catch (StaleElementReferenceException f) {
                return false;
            }
        };
        wait.until(elementIsDisplayed);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
