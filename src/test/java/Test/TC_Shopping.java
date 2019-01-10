package Test;

import Actions.Action;
import Objects.Users;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TC_Shopping {

    WebDriver driver = null;
    private String url = "http://103.95.199.151/mobilevn/";
    private String username = "123@gmail.com";
    private String password = "abcdef";
    Users user = null;

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
    }

    @Test
    public void TC_Shopping_SearchTool_01() throws InterruptedException {

        Action.Login(driver,username,password);

        Action.CheckDisplaySearchTool(driver);
    }
}
