package Actions;

import Pages.Shopping_ProductDetail_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Shopping_ProductDetail_Action {
    public static void clickAddToBasketButtonOnProductDetailPopup(WebDriver driver) {
        driver.findElement(By.xpath(Shopping_ProductDetail_Page.btn_ProductDetail_AddToBasket)).click();
    }
}
