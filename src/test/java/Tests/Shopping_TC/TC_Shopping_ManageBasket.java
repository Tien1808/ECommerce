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
import java.util.concurrent.TimeUnit;

public class TC_Shopping_ManageBasket extends SetUp_AlphaVersion {

    @Test
    public void TC_Shopping_ManageBasket_01() {
       // Manage_Login_Action.Login(driver, user.getUsername(),user.getPassword());

        WebDriverWait wait = new WebDriverWait(SetUp_AlphaVersion.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Home_Page.txt_Homepage_NameProduct)));
        Shopping_ManageBasket_Action.clickAddShoppingCartButton(SetUp_AlphaVersion.driver);
        // Basket popup is displayed Verification point.
        Shopping_ManageBasket_Action.CheckBasketPopupDisplay(SetUp_AlphaVersion.driver);
    }

    @Test
    public void TC_Shopping_ManageBasket_02_03(){
        Manage_Login_Action.Login(SetUp_AlphaVersion.driver, initializeUser().getUsername(), initializeUser().getPassword());

        WebDriverWait wait = new WebDriverWait(SetUp_AlphaVersion.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Home_Page.txt_Homepage_NameProduct)));
        Shopping_ManageBasket_Action.clickAddShoppingCartButton(SetUp_AlphaVersion.driver);
        Shopping_ManageBasket_Action.CheckEmptyBasket(SetUp_AlphaVersion.driver);
    }

    @Test
    public void TC_Shopping_ManageBasket_06() throws ParseException, InterruptedException {

        Shopping_ManageBasket_Action.clickAddToBasketButton(SetUp_AlphaVersion.driver,"Zend fone 5C");
        Shopping_ManageBasket_Action.clickBuyAnotherButton(SetUp_AlphaVersion.driver);

        Shopping_ManageBasket_Action.clickAddToBasketButton(SetUp_AlphaVersion.driver,"Zend fone 4");
        //Shopping_ManageBasket_Action.clickBuyAnotherButton(SetUp_AlphaVersion.driver);
        Shopping_ManageBasket_Action.CheckTotalPrice(SetUp_AlphaVersion.driver);
    }


   // public void downCrash() {
     //   SetUp.downCrash();
  //  }
}
