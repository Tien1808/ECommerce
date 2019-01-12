package Actions;

import Pages.Shopping_ManageBasket_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Shopping_ManageBasket_Action {

    public static void clickAddShoppingCartButton(WebDriver driver) {
        driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_Homepage_ShoppingCart)).click();
    }

    public static String getNameProductOnHomepage(WebDriver driver) {
        return driver.findElement(By.xpath(Shopping_ManageBasket_Page.txt_Homepage_NameProduct)).getText();
    }

    // Nút này hiển thị ở phía dưới của mỗi cardview.
    public static void clickAddToBasketButton(WebDriver driver) {
        driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_Homepage_AddToBasket)).click();
    }

    /**
     * Chuyển tới Checkout popup để xác nhận thông tin.
     * @param driver
     */
    public static void clickOderButton(WebDriver driver) {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_Order)).click();
        WebElement element = driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_Order));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public static void clickLoginLink(WebDriver driver) {
        driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_LoginLink)).click();
    }
}
