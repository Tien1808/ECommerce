package Actions;

import Pages.DEMOPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Demo_actions {
    public static void enterUsername(WebDriver driver, String username)
    {
        driver.findElement(By.xpath(DEMOPage.txt_username)).sendKeys(username);
    }

}

