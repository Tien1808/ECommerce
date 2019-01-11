package Actions;

import Pages.Page_Shopping_ManageBasket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action_Shopping_ManageBasket {

    public static String getNameProductOnHomepage(WebDriver driver) {
        return driver.findElement(By.xpath(Page_Shopping_ManageBasket.txt_Homepage_NameProduct)).getText();
    }
    public static void addItemToBasket(WebDriver driver) {
        driver.findElement(By.xpath(Page_Shopping_ManageBasket.btn_Homepage_AddToBasket)).click();
    }

    /**
     * Chuyển tới Checkout popup để xác nhận thông tin.
     * @param driver
     */
    public static void clickOderButton(WebDriver driver) {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.xpath(Page_Shopping_ManageBasket.btn_BasketPopup_Order)).click();
        WebElement element = driver.findElement(By.xpath(Page_Shopping_ManageBasket.btn_BasketPopup_Order));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public static void clickLoginLink(WebDriver driver) {
        driver.findElement(By.xpath(Page_Shopping_ManageBasket.btn_BasketPopup_LoginLink)).click();
    }
}
