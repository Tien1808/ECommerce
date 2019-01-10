package Test;

import Actions.Action;
import Actions.Action_Shopping_Checkout;
import Objects.Product;
import Objects.Users;
import Pages.Page_Shopping_ManageBasket;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class TC_Shopping {

    WebDriver driver = null;
    private String url = "http://103.95.199.151/mobilevn/";
    private String username = "123@gmail.com";
    private String password = "abcdef";
    Users user = null;
    Product product= null;

    @Before
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
    }

    @Test
    public void TC_Shopping_SearchTool_01() {
        Action.Login(driver,username,password);
    }

    @Test
    public void TC_Shopping_Checkout_01() {
        Action.Login(driver, user.getUsername(), user.getPassword());
        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page_Shopping_ManageBasket.btn_Homepage_AddToBasket)));
        Action_Shopping_Checkout.checkProductsDisplayOnCheckoutPopup(driver, product);
    }
}
