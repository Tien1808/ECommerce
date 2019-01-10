package Actions;

import Pages.Page_Shopping_Login;
import Pages.Page_Shopping_SearchTool;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class Action {


    public static void Login(WebDriver driver, String username, String password) throws InterruptedException {
        driver.findElement(By.xpath(Page_Shopping_Login.btn_Homepage_Login)).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Page_Shopping_Login.txt_LoginPopup_Username)).sendKeys(username);
        driver.findElement(By.xpath(Page_Shopping_Login.txt_LoginPopup_Password)).sendKeys(password);
        driver.findElement(By.xpath(Page_Shopping_Login.btn_LoginPopup_Login)).click();
        driver.findElement(By.xpath(Page_Shopping_Login.btn_LoginPopup_Login)).click();
    }

    public static void CheckDisplaySearchTool(WebDriver driver){
        String SearchBarResult ;
        String GoBtnResult ;

        driver.findElement(By.xpath(Page_Shopping_SearchTool.Homepage_Searchbar)).click();
        boolean CheckSearchBar = driver.findElement(By.xpath(Page_Shopping_SearchTool.SearchTool_GoBtn)).isDisplayed();
        if (CheckSearchBar == true){
            SearchBarResult = "Search bar is display";
        }else {
            SearchBarResult = "Search bar isn't display";
        }

        boolean CheckGoBtn = driver.findElement(By.xpath(Page_Shopping_SearchTool.SearchTool_SearchBar)).isEnabled();
        if (CheckGoBtn == true){
            GoBtnResult = "Go button is display";
        }else {
            GoBtnResult = "Go button isn't display";
        }

        if (CheckGoBtn == true && CheckSearchBar == true){
            System.out.println("Testcase TC_Shopping_SearchTool_01: Passe. "+SearchBarResult+" and "+GoBtnResult);
        }
    }


}
