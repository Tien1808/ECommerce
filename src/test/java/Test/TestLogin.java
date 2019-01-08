package Test;

import Actions.Demo_actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestLogin {

    WebDriver driver;
    @BeforeMethod
    public void init()
    {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\Resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://github.com/login");
    }


    @Test
    public void test1()
    {
        Demo_actions.enterUsername(driver,"thuthao94bkdn@gmail.com");
    }

    @Test
    public void test2()
    {
        Demo_actions.enterUsername(driver,"levietien1808@gmail.com");
    }

    @AfterMethod
    public void after()
    {
        driver.quit();
    }
}
