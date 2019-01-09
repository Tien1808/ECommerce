package Actions;

import Pages.Page;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Action {
    public static void Login(WebDriver driver, String username, String password) {
        driver.findElement(By.xpath(Page.btn_Homepage_Login)).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Page.txt_LoginPopup_Username)).sendKeys(username);
        driver.findElement(By.xpath(Page.txt_LoginPopup_Password)).sendKeys(password);
        driver.findElement(By.xpath(Page.btn_LoginPopup_Login)).click();
        driver.findElement(By.xpath(Page.btn_LoginPopup_Login)).click();
    }
}
