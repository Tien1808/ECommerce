package Actions;

import Objects.Product;
import Pages.Shopping_ManageBasket_Page;
import Pages.Shopping_Checkout_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Shopping_Checkout_Action {
    //public static String getNameProductOnCheckoutPopup(WebDriver driver, Product product) {
    //    return driver.findElement(By.xpath(Shopping_Checkout_Page.txt_CheckoutPopup_NameProduct(product.getName()))).getText();
    //}

    public static String getNameProductOnCheckoutPopup(WebDriver driver) {
        return driver.findElement(By.xpath(Shopping_Checkout_Page.txt_CheckoutPopup_NameProduct)).getText();
    }

    /**
     * So sánh tên sản phẩm trên Basket popup với tên sản phẩm ở trên
     * Checkout popup có giống nhau không?
     * @param driver driver
     * @param product dùng để lấy tên sản phẩm
     */
    public static void checkProductsDisplayOnCheckoutPopup(WebDriver driver, Product product) {
        Shopping_ManageBasket_Action.clickAddToBasketButton(driver);
        // Lấy tên sản phẩm ở Basket popup.
        // expected = name product on Basket popup
        // String expected = Shopping_ManageBasket_Actio.getNameProductOnBasketPopup(driver);
        String expected = Shopping_ManageBasket_Action.getNameProductOnHomepage(driver);
        System.out.println("Expected: " + expected);
        // Gán cái tên sản phẩm mới lấy được ở Basket popup vào đối tượng product.
        product.setName(expected);
        // Chuyển qua Checkout popup
        Shopping_ManageBasket_Action.clickOderNowButton(driver);
        // actual = name product on Checkout popup
        //String actual = getNameProductOnCheckoutPopup(driver, product);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Shopping_ManageBasket_Page.txt_Homepage_NameProduct)));
        //Thread.sleep(2000);
        String actual = getNameProductOnCheckoutPopup(driver);
        System.out.println("Actual: " + actual);
        try {
            assertEquals("List of selected products are incorrect", expected, actual);
            System.out.println("There selected products display on Checkout popup!!!");
        } catch (AssertionError assertionError) {
            assertionError.printStackTrace();
        }
    }

    public static void clickCancelButtonOnCheckoutPopup(WebDriver driver) {
        driver.findElement(By.xpath(Shopping_Checkout_Page.btn_Checkout_Cancel)).click();
    }
}
