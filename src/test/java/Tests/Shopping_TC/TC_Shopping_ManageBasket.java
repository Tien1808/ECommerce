package Tests.Shopping_TC;

import Actions.Shopping_ManageBasket_Action;
import Objects.Product;
import Objects.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Shopping_ManageBasket {

    private WebDriver driver = null;
    private String url = "http://103.95.199.151/mobilevn/";
    private String username = "123@gmail.com";
    private String password = "abcdef";
    private Users user = null;
    private Product product= null;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\Resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        System.out.println(driver.getTitle());
        user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        product = new Product();
    }

    @Test
    public void TC_Shopping_ManageBasket_01() {
        // Call to method 'clickAddShoppingCartButton'.
        Shopping_ManageBasket_Action.clickAddShoppingCartButton(driver);
        // Basket popup is displayed Verification point.
    }

    /*public void downCrash() {
        SetUp.downCrash(driver);
    }*/
}
