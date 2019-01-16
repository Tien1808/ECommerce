package Tests.Shopping_TC;

import Actions.Manage_Login_Action;
import Actions.Shopping_ManageBasket_Action;
import Commons.SetUp;
import Commons.SetUp_AlphaVersion;
import Objects.Product;
import Objects.User;
import Pages.Home_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;

public class TC_Shopping_ManageBasket extends SetUp_AlphaVersion {

    @Test
    public void TC_Shopping_ManageBasket_01() {
       // Manage_Login_Action.Login(driver, user.getUsername(),user.getPassword());

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Home_Page.txt_Homepage_NameProduct)));
        Shopping_ManageBasket_Action.clickAddShoppingCartButton(driver);
        // Basket popup is displayed Verification point.
        Shopping_ManageBasket_Action.CheckBasketPopupDisplay(driver);
    }

    @Test
    public void TC_Shopping_ManageBasket_02_03(){
        Manage_Login_Action.Login(SetUp.driver, SetUp.user.getUsername(), SetUp.user.getPassword());

        WebDriverWait wait = new WebDriverWait(SetUp.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Home_Page.txt_Homepage_NameProduct)));
        Shopping_ManageBasket_Action.clickAddShoppingCartButton(SetUp.driver);
        Shopping_ManageBasket_Action.CheckEmptyBasket(SetUp.driver);
    }

    @Test
    public void TC_Shopping_ManageBasket_06() throws ParseException {

        Shopping_ManageBasket_Action.clickAddToBasketButton(driver,"Nokia Lumia 670");
        Shopping_ManageBasket_Action.clickBuyAnotherButton(driver);
        Shopping_ManageBasket_Action.clickAddToBasketButton(driver,"Zend fone 4");
        Shopping_ManageBasket_Action.clickBuyAnotherButton(driver);
        Shopping_ManageBasket_Action.CheckTotalPrice(driver);
    }


    public void downCrash() {
        SetUp.downCrash();
    }
}
