package Tests.Shopping_TC;

import Actions.Shopping_Search_Action;
import Commons.SetUp;

import Objects.Product;
import Objects.User;
import Pages.Shopping_SearchTool_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Shopping_SearchTool {
    private static WebDriver driver = null;
    private static String url = "http://103.95.199.151/mobilevn/";
    private static String username = "123@gmail.com";
    private static String password = "abcdef";
    private static User user = null;
    private static Product product= null;

    @BeforeMethod

    public void setUp() {
        SetUp.setUp();
    }

    @Test
    public void TC_Shopping_SearchTool_01() {
        //Manage_Login_Action.Login(SetUp.driver, SetUp.user.getUsername(), SetUp.user.getPassword());

        Shopping_Search_Action.clickSearchBar(SetUp.driver);
        Shopping_Search_Action.CheckDisplaySearchTool(SetUp.driver);
    }

    @Test
    public void TC_Shopping_SearchTool_02() {
        WebDriverWait wait = new WebDriverWait(SetUp.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Shopping_SearchTool_Page.txt_Homepage_Searchbar)));
        Shopping_Search_Action.clickSearchBar(SetUp.driver);
        Shopping_Search_Action.CheckKeyWord(SetUp.driver, SetUp.user.getKeyword());
    }

    @Test
    public void TC_Shopping_SearchTool_04() {
        WebDriverWait wait = new WebDriverWait(SetUp.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Shopping_SearchTool_Page.txt_Homepage_Searchbar)));
        Shopping_Search_Action.clickSearchBar(SetUp.driver);
        Shopping_Search_Action.SearchProductDetail(SetUp.driver, SetUp.user.getKeyword());
    }

    /*public void downCrash() {
        SetUp.downCrash(driver);
    }*/
}
