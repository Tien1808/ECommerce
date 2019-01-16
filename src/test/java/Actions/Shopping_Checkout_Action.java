package Actions;

import Pages.Home_Page;
import Pages.Shopping_Checkout_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Shopping_Checkout_Action {
    public static String getNameProductOnCheckoutPopup(WebDriver driver, String nameProduct) {
        return driver.findElement(By.xpath(Shopping_Checkout_Page.txt_CheckoutPopup_NameProduct(nameProduct))).getText();
    }

    /**
     * So sánh tên sản phẩm trên Basket popup với tên sản phẩm ở trên
     * Checkout popup có giống nhau không?
     * @param driver driver
     * @param nameProduct Name of product.
     */
    public static void checkProductsDisplayOnCheckoutPopup(WebDriver driver, String nameProduct) {
        Shopping_ManageBasket_Action.clickAddToBasketButton(driver, nameProduct);
        // Lấy tên sản phẩm ở Basket popup.
        // expected = name product on Basket popup
        // String expected = Shopping_ManageBasket_Actio.getNameProductOnBasketPopup(driver);
        String expected = Shopping_ManageBasket_Action.getNameProductOnHomepage(driver);
        System.out.println("Expected: " + expected);
        // Gán cái tên sản phẩm mới lấy được ở Basket popup vào đối tượng product.
//        product.setName(expected);
        // Chuyển qua Checkout popup
        Shopping_ManageBasket_Action.clickOderNowButton(driver);
        // actual = name product on Checkout popup
        //String actual = getNameProductOnCheckoutPopup(driver, product);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Home_Page.txt_Homepage_NameProduct)));
        String actual = getNameProductOnCheckoutPopup(driver, nameProduct);
        System.out.println("Actual: " + actual);
        try {
            assertEquals("List of selected products are incorrect", expected, actual);
            System.out.println("There selected products display on Checkout popup!!!");
        } catch (AssertionError assertionError) {
            assertionError.printStackTrace();
        }
    }

    public static void enterPassword(WebDriver driver, String password) {
        driver.findElement(By.xpath(Shopping_Checkout_Page.txt_CheckoutPopup_Password)).sendKeys(password);
    }

    public static void clickCancelButton(WebDriver driver) {
        driver.findElement(By.xpath(Shopping_Checkout_Page.btn_CheckoutPopup_Cancel)).click();
    }

    public static void clickCheckoutButton(WebDriver driver) {
        //Actions actions = new Actions(driver);
        //actions.moveToElement(driver.findElement(By.xpath(Shopping_Checkout_Page.btn_CheckoutPopup_Checkout))).click().perform();
        driver.findElement(By.xpath(Shopping_Checkout_Page.btn_CheckoutPopup_Checkout)).click();
        driver.findElement(By.xpath(Shopping_Checkout_Page.btn_CheckoutPopup_Checkout)).click();
    }
}
