package Tests.Shopping_TC;

import Actions.*;
import Commons.SetUp_AlphaVersion;
import Pages.Home_Page;
import Pages.Shopping_Checkout_Page;
import Pages.Shopping_ManageBasket_Page;
import Tests.TC_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC_Shopping_Checkout extends SetUp_AlphaVersion {
    private TC_Login login = new TC_Login();

    @Test
    public void TC_Shopping_Checkout_01() {
        login.TC_Manage_Login_06();

        // Must wait least 3 or 4 time to load expected condition.
        WebDriverWait wait = new WebDriverWait(driver, 4);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Home_Page.getXPathOfAProductOnHomepage(prop.getProperty("txt_ShoppingCheckout_FeaturedProduct"), initializeProduct().getName()))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Home_Page.getXPathOfAProductOnHomepage("Sản phẩm nỗi bật", initializeProduct().getName()))));

        // Home_Action.clickAnItemOnHomepage(SetUp_AlphaVersion.driver, prop.getProperty("txt_ShoppingCheckout_FeaturedProduct"), initializeProduct().getName());
        Home_Action.clickAnItemOnHomepage(SetUp_AlphaVersion.driver, "Sản phẩm nỗi bật", initializeProduct().getName());
        Shopping_ProductDetail_Action.clickAddToBasketButtonOnProductDetailPopup(SetUp_AlphaVersion.driver);

        // Wait for Order Now button displays, because if wait for title
        // then show 'Expected condition failed'.
        wait.until(ExpectedConditions.visibilityOf(SetUp_AlphaVersion.driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_OrderNow))));
        String expected = Shopping_ManageBasket_Action.getNameProductOnBasketPopup(SetUp_AlphaVersion.driver, initializeProduct().getName());

        Shopping_ManageBasket_Action.clickOderNowButton(SetUp_AlphaVersion.driver);

        wait.until(ExpectedConditions.visibilityOf(SetUp_AlphaVersion.driver.findElement(By.xpath(Shopping_Checkout_Page.btn_Checkout_Cancel))));
        //String actual = Shopping_Checkout_Action.getNameProductOnCheckoutPopup(SetUp_AlphaVersion.driver, initializeProduct().getName());

        // Verification point.
       // verificationPoint(actual, expected, prop.getProperty("txt_Popular_TheTwoValueAreDifference"));
    }

    @Test
    public void TC_Shopping_Checkout_09() {
        login.TC_Manage_Login_06();

        // Must wait least 3 or 4 time to load expected condition.
        WebDriverWait wait = new WebDriverWait(driver, 4);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Home_Page.getXPathOfAProductOnHomepage(prop.getProperty("txt_ShoppingCheckout_BestSeller"), initializeProduct().getName()))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Home_Page.getXPathOfAProductOnHomepage("Top bán chạy nhất", initializeProduct().getName()))));

        Home_Action.clickAnItemOnHomepage(driver, "Top bán chạy nhất", initializeProduct().getName());
        Shopping_ProductDetail_Action.clickAddToBasketButtonOnProductDetailPopup(driver);
        Shopping_ManageBasket_Action.clickOderNowButton(driver);

        WebElement abc1 = driver.findElement(By.xpath(Shopping_Checkout_Page.btn_Checkout_Cancel));
        wait.until(ExpectedConditions.visibilityOf(abc1));

        Shopping_Checkout_Action.clickCancelButtonOnCheckoutPopup(driver);

        WebElement waitForElementDisplay = driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_OrderNow));
        wait.until(ExpectedConditions.visibilityOf(waitForElementDisplay));

        // Basket popup verification point.
        String expected = prop.getProperty("txt_TCShoppingCheckout09_PassedExpectation");
        String actual = Shopping_ManageBasket_Action.getTitleOnBasketPopup(driver);
        verificationPoint(actual, expected, prop.getProperty("txt_Popular_TheTwoValueAreDifference"));
    }
}
