package Commons;

import Objects.Product;
import Objects.Users;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetUp {
    public static WebDriver driver = null;
    public static String url = "http://103.95.199.151/mobilevn/";
    public static String username = "123@gmail.com";
    public static String password = "abcdef";
    public static String keyword = "htc";
    public static String productName = "iphone 6";
    public static Users user = null;
    public static Product product= null;

    @BeforeMethod
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\Resources\\drivers\\chromedriver.exe");
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setKeyword(keyword);
        product.setName(productName);
        product = new Product();
    }

    @AfterMethod
    public static void downCrash() {
        driver.quit();
    }

}
