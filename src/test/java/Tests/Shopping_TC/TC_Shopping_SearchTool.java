package Tests.Shopping_TC;

import Actions.Manage_Login_Action;
import Actions.Shopping_Search_Action;
import Commons.SetUp_AlphaVersion;
import Objects.Product;
import Objects.User;
import Pages.Shopping_SearchTool_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Shopping_SearchTool extends SetUp_AlphaVersion {

    @Test
    public void TC_Shopping_SearchTool_01() {
        Manage_Login_Action.Login(SetUp_AlphaVersion.driver, initializeUser().getUsername(), initializeUser().getPassword());

        Shopping_Search_Action.clickSearchBar(SetUp_AlphaVersion.driver);
        Shopping_Search_Action.CheckDisplaySearchTool(SetUp_AlphaVersion.driver);
    }

    @Test
    public void TC_Shopping_SearchTool_02() {
        WebDriverWait wait = new WebDriverWait(SetUp_AlphaVersion.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Shopping_SearchTool_Page.txt_Homepage_Searchbar)));
        Shopping_Search_Action.clickSearchBar(SetUp_AlphaVersion.driver);
        Shopping_Search_Action.CheckKeyWord(SetUp_AlphaVersion.driver, initializeUser().getKeyword());
    }

    @Test
    public void TC_Shopping_SearchTool_04() {
        WebDriverWait wait = new WebDriverWait(SetUp_AlphaVersion.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Shopping_SearchTool_Page.txt_Homepage_Searchbar)));
        Shopping_Search_Action.clickSearchBar(SetUp_AlphaVersion.driver);
        Shopping_Search_Action.SearchProductDetail(SetUp_AlphaVersion.driver, initializeUser().getKeyword());
    }

    /*public void downCrash() {
        SetUp.downCrash(driver);
    }*/
}
