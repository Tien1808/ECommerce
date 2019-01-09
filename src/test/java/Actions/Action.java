package Actions;

import Pages.Page_Shopping_Login;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class Action {


    public static void Login(WebDriver driver, String username, String password) {
        driver.findElement(By.xpath(Page_Shopping_Login.btn_Homepage_Login)).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Page.txt_LoginPopup_Username)).sendKeys(username);
        driver.findElement(By.xpath(Page.txt_LoginPopup_Password)).sendKeys(password);
        driver.findElement(By.xpath(Page.btn_LoginPopup_Login)).click();
        driver.findElement(By.xpath(Page.btn_LoginPopup_Login)).click();
    }


}
