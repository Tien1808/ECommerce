package Commons;

import Objects.Product;
import Objects.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class SetUp_AlphaVersion {
    public static WebDriver driver = null;
    protected static Properties prop;
    private static StringBuffer stringBuffer = new StringBuffer();

    public static String convertStringIntoNumbers(String price) {
        char[] c = price.toCharArray();
        for (char c1 : c) {
            // Check c1 in c array is a number?
            if(Character.isDigit(c1)) {
                // String concatenation.
                stringBuffer.append(c1);
            }
        }
        if(stringBuffer.toString().equals("")) {
            return stringBuffer.toString();
        }
        return "Price value is invalid!!!";
    }

    @BeforeMethod
    public static void initializeHomepage() {
        loadPropertiesFile();

        // getProperty() method to retrieve the value from the configuration file.
        System.setProperty(prop.getProperty("txt_SetUp_ChromeDriver"),
                prop.getProperty("txt_SetUp_ChromeDriverPath"));
        driver = new ChromeDriver();
        driver.get(prop.getProperty("AppUrl"));

        // Enlarge screen to the system can focus on better element.
        driver.manage().window().maximize();
        System.out.println("Page title: " + driver.getTitle());
    }

    protected static Product initializeProduct() {
        return new Product(prop.getProperty("product_SetUp_Name01"));
    }

    protected static User initializeUser() {
        return new User(prop.getProperty("user_SetUp_Username01"), prop.getProperty("user_SetUp_Password01"));
    }

    /**
     * Support method.
     */
    private static void loadPropertiesFile() {
        // Use to store key/value pairs.
        prop = new Properties();
        try {
            // Use to get key/value pairs in Properties object
            // following propertyFilePath stream.
            prop.load(new FileInputStream("./src/test/Resources/Configs/Config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * End the activity and auto close the website.
     */
    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }

    /**
     * Verify that current testcase is passed or failed.
     * Type of actual and expected value must be the same.
     * Recommend: should not be left blank this field.
     * @param actual actual result.
     * @param expected expected result.
     * @param errorMessage error message will be show if testcase is failed.
     */
    protected static void verificationPoint(Object actual, Object expected, String errorMessage) {
        try {
            assertEquals(actual, expected, errorMessage);
            System.out.println("PASSED!!!");
        } catch (AssertionError assertionError) {
            assertionError.printStackTrace();
        }
    }
}
