package Test;

import Actions.Action;
import Actions.Action_Shopping_Checkout;
import Actions.Action_Shopping_ManageBasket;
import Objects.Product;
import Objects.Users;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TC_Shopping {

    WebDriver driver = null;
    private String url = "http://103.95.199.151/mobilevn/";
    private String username = "123@gmail.com";
    private String password = "abcdef";
    Users user = null;
    Product product = null;

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
        Action_Shopping_ManageBasket.addItemToBasket(driver);
        Action_Shopping_ManageBasket.clickOderButton(driver);
        //Action_Shopping_ManageBasket.clickLoginLink(driver);
        //Action.Login(driver,username,password);
        //driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        //Action_Shopping_Checkout.checkProductsDisplayOnCheckoutPopup(driver,product);
    }
}
