package Actions;

import Pages.Shopping_OderSuccess_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Shopping_OrderSuccess_Action {
    public static String getTitle(WebDriver driver) {
        return driver.findElement(By.xpath(Shopping_OderSuccess_Page.txt_OderSuccessPopup_Title)).getText();
    }
}
