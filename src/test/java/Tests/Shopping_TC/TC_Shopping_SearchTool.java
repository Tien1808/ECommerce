package Tests.Shopping_TC;

import Actions.Manage_Login_Action;
<<<<<<< HEAD:src/test/java/Tests/Shopping_TC/Shopping_SearchTool_TC.java
import Actions.Shopping_Search_Action;
import Commons.SetUp;
=======
>>>>>>> d10a622c5f5b61c0df3aacd5373111a3064d6920:src/test/java/Tests/Shopping_TC/TC_Shopping_SearchTool.java
import Objects.Product;
import Objects.Users;
import Pages.Shopping_ManageBasket_Page;
import Pages.Shopping_SearchTool_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

<<<<<<< HEAD:src/test/java/Tests/Shopping_TC/Shopping_SearchTool_TC.java
import java.util.concurrent.TimeUnit;

public class Shopping_SearchTool_TC {
    public static WebDriver driver=null;
    public static String url = "http://103.95.199.151/mobilevn/";
    public static String username = "123@gmail.com";
    public static String password = "abcdef";
    public static Users user = null;
    public static Product product= null;
=======
public class TC_Shopping_SearchTool {
    private static WebDriver driver = null;
    private static String url = "http://103.95.199.151/mobilevn/";
    private static String username = "123@gmail.com";
    private static String password = "abcdef";
    private static Users user = null;
    private static Product product= null;
>>>>>>> d10a622c5f5b61c0df3aacd5373111a3064d6920:src/test/java/Tests/Shopping_TC/TC_Shopping_SearchTool.java

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
