package Commons;

import Objects.Product;
import Objects.Users;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetUp {
    private static WebDriver driver = null;
    private static String url = "http://103.95.199.151/mobilevn/";
    private static String username = "123@gmail.com";
    private static String password = "abcdef";
    private static String keyword = "htc";
    private static Users user = null;
    private static Product product= null;

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
        user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setKeyword(keyword);
        product = new Product();
    }

    @AfterMethod
    public static void downCrash() {
        driver.quit();
    }

}
