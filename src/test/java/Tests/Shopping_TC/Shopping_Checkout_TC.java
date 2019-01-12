package Tests.Shopping_TC;

import Actions.Manage_Login_Action;
import Actions.Shopping_Checkout_Action;
import Commons.SetUp;
import Objects.Product;
import Objects.Users;
import Pages.Shopping_ManageBasket_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Shopping_Checkout_TC {

    public static WebDriver driver = null;
    public static String url = "http://103.95.199.151/mobilevn/";

    public void setUp() {
        SetUp.setUp();
    }

    @Test
    public void TC_Shopping_Checkout_01() throws InterruptedException {
        Manage_Login_Action.Login(SetUp.driver, SetUp.user.getUsername(), SetUp.user.getPassword());
        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(SetUp.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Shopping_ManageBasket_Page.txt_Homepage_NameProduct)));
        Shopping_Checkout_Action.checkProductsDisplayOnCheckoutPopup(SetUp.driver, SetUp.product);
    }

    public void downCrash() {
        SetUp.downCrash();
    }
}
