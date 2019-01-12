package Actions;

import Pages.Manage_Login_Page;
import Pages.Shopping_SearchTool_Page;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class Manage_Login_Action {

    public static void Login(WebDriver driver, String username, String password) {
        driver.findElement(By.xpath(Manage_Login_Page.btn_Homepage_Login)).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Manage_Login_Page.txt_LoginPopup_Username)).sendKeys(username);
        driver.findElement(By.xpath(Manage_Login_Page.txt_LoginPopup_Password)).sendKeys(password);
        driver.findElement(By.xpath(Manage_Login_Page.btn_LoginPopup_Login)).click();
        driver.findElement(By.xpath(Manage_Login_Page.btn_LoginPopup_Login)).click();
    }

    public static void CheckKeyWord(WebElement driver, String text){
        driver.findElement(By.xpath(Shopping_SearchTool_Page.Homepage_Searchbar)).click();
        driver.findElement(By.xpath(Shopping_SearchTool_Page.SearchTool_SearchBar)).sendKeys(text);

    }


}
