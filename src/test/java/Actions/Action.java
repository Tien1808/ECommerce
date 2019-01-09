package Actions;

import Pages.Page_Shopping_Login;
import Pages.Page_Shopping_SearchTool;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Action {


    public static void Login(WebDriver driver, String username, String password) {
        driver.findElement(By.xpath(Page_Shopping_Login.btn_Homepage_Login)).click();
        driver.manage().timeouts().implicitlyWait(1, SECONDS);
        driver.findElement(By.xpath(Page_Shopping_Login.txt_LoginPopup_Username)).sendKeys(username);
        driver.findElement(By.xpath(Page_Shopping_Login.txt_LoginPopup_Password)).sendKeys(password);
        driver.findElement(By.xpath(Page_Shopping_Login.btn_LoginPopup_Login)).click();
        driver.findElement(By.xpath(Page_Shopping_Login.btn_LoginPopup_Login)).click();
    }

    public static void checkDisplayedControls(WebDriver driver) {
        driver.findElement(By.xpath(Page_Shopping_SearchTool.Homepage_Searchbar)).click();

        boolean checkSearBar = driver.findElement(By.xpath(Page_Shopping_SearchTool.SearchTool_SearchBar)).isEnabled();

        if (checkSearBar == true){
            System.out.println("Search bar is display");
        } else {
            System.out.println("Search bar isn't display");
        }

        boolean checkGoBtn = driver.findElement(By.xpath(Page_Shopping_SearchTool.SearchTool_GoBtn)).isDisplayed();

        if (checkGoBtn == true){
            System.out.println("Go button is display");
        } else {
            System.out.println("Go button isn't display");
        }

        if (checkSearBar == true && checkGoBtn == true){
            System.out.println("TC_Shopping_SearchTool_01: Passed. Search bar and Go button is dislay!!!");
        }
        else {
            System.out.println("TC_Shopping_SearchTool_01: Failed. Search bar and Go button isn't dislay!!!!!!");
        }
    }

}
