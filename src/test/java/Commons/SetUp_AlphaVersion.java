package Commons;

import Objects.Product;
import Objects.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetUp_AlphaVersion extends LoadConfigFile {
    public static WebDriver driver = null;

    @BeforeMethod
    public static void initializeTheHomepage() {
        LoadConfigFile.loadPropertiesFile();

        // getProperty() method to retrieve the value from the configuration file.
        System.setProperty(prop.getProperty("chromeDriver"),
                prop.getProperty("chromeDriver_Path"));
        driver = new ChromeDriver();
        driver.get(prop.getProperty("AppUrl"));

        // Enlarge screen to the system can focus on better element.
        driver.manage().window().maximize();
        System.out.println("Page title: " + driver.getTitle());
    }

    protected static User initializeUser() {
        return new User(prop.getProperty("Username_01"), prop.getProperty("Password_01"));
    }

    protected static Product initializeProduct() {
        return new Product(prop.getProperty("name_01"));
    }

    /**
     * End the activity and auto close the website.
     */
    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}
