package Tests.Shopping_TC;

import Actions.*;
import Commons.Wait;
import Objects.Product;
import Objects.Users;
import Pages.Home_Page;
import Pages.Shopping_Checkout_Page;
import Pages.Shopping_ManageBasket_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class TC_Shopping_Checkout {

    private WebDriver driver = null;
    private String url = "http://103.95.199.151/mobilevn/";
    private String username = "123@gmail.com";
    private String password = "abcdef";
    private String nameProduct = "iphone 6";
    private Users user = null;
    private Product product= null;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\Resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        product = new Product();
        product.setName(nameProduct);
    }

    @Test
    public void TC_Shopping_Checkout_01() {
        Manage_Login_Action.Login(driver, user.getUsername(), user.getPassword());
        // Must wait least 3 or 4 time to load expected condition.
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Home_Page.getXPathOfAProductOnHomepage("Sản phẩm nỗi bật", product.getName()))));
        Home_Action.clickAnItemOnHomepage(driver, "Sản phẩm nỗi bật", product.getName());
        Shopping_ProductDetail_Action.clickAddToBasketButtonOnProductDetailPopup(driver);
        //System.out.println(product.getName());
        String expected = Shopping_ManageBasket_Action.getNameProductOnBasketPopup(driver, product.getName());
        System.out.println("Kết quả: " + expected);
        // Chưa lấy được text trên basket popup.
    }

    @Test
    public void TC_Shopping_Checkout_09() throws InterruptedException {
        Manage_Login_Action.Login(driver, user.getUsername(), user.getPassword());
        // Must wait least 3 or 4 time to load expected condition.
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Home_Page.getXPathOfAProductOnHomepage("Top bán chạy nhất", product.getName()))));
        Home_Action.clickAnItemOnHomepage(driver, "Top bán chạy nhất", product.getName());

        Shopping_ProductDetail_Action.clickAddToBasketButtonOnProductDetailPopup(driver);

        Shopping_ManageBasket_Action.clickOderNowButton(driver);

        WebElement abc1 = driver.findElement(By.xpath(Shopping_Checkout_Page.btn_Checkout_Cancel));
        //Wait.waitUntilElementDisplayed(abc, driver);
        wait.until(ExpectedConditions.visibilityOf(abc1));

        Shopping_Checkout_Action.clickCancelButtonOnCheckoutPopup(driver);


        //Actions action = new Actions(driver);
        //action.moveToElement(driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_OrderNow))).build().perform();

        // waitForElementDisplay
        WebElement abc = driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_OrderNow));
        wait.until(ExpectedConditions.visibilityOf(abc));

        // Basket popup verification point.
        String expected = "Giỏ hàng của bạn ";
        String actual = Shopping_ManageBasket_Action.getTitleOnBasketPopup(driver);
        System.out.println("actual: " + actual);
        boolean result = expected.equalsIgnoreCase(actual);
        Assert.assertEquals(actual,expected);

        /*try {
            assertTrue(result, "Expected and actual are not the same!!!");
            System.out.println("TC_Shopping_Checkout_09 Passed");
        } catch (AssertionError assertionError) {
            assertionError.printStackTrace();
        }*/
    }

    /*public void downCrash() {
        SetUp.downCrash(driver);
    }*/
}
