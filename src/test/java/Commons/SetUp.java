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
    public static User user = null;
    public static String productName = "iphone 6";
    public static Users user = null;
    public static Product product= null;

    // Em có ý định sẽ dời những biến có liên quan ở phía trên
    // vô các hàm ở phía dưới. Ví dụ: setUp() thành setUp(Webdriver...)
    // Em sẽ làm sau, sau khi em nắm rõ phần Config.properties trong mục
    // Resources!!! Mục đích em làm vậy là vì như vậy nó đúng chuẩn như
    // thầy nói và để xóa mấy cái vạch vàng ở bên cạnh!!!

    @BeforeMethod
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\Resources\\drivers\\chromedriver.exe");
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        user = new User();
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
