package Tests.Shopping_TC;

import Actions.Manage_Login_Action;
import Actions.Shopping_ManageBasket_Action;
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
        Manage_Login_Action.Login(SetUp_AlphaVersion.driver, initializeUser().getUsername(), initializeUser().getPassword());

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
    public void TC_Shopping_ManageBasket_04(){

        Shopping_ManageBasket_Action.clickAddToBasketButton(SetUp_AlphaVersion.driver,"Zend fone 5C");
        Shopping_ManageBasket_Action.clickBuyAnotherButton(SetUp_AlphaVersion.driver);

        Shopping_ManageBasket_Action.clickAddToBasketButton(SetUp_AlphaVersion.driver,"Zend fone 4");
        Shopping_ManageBasket_Action.clickBuyAnotherButton(SetUp_AlphaVersion.driver);

        Shopping_ManageBasket_Action.clickAddToBasketButton(SetUp_AlphaVersion.driver,"HTC Desire 825A");

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        String TotalProductWillDelete = SetUp_AlphaVersion.prop.getProperty("txt_BasketPopup_TotalProductWillDelete");
        int totalProductWillDelete = Integer.parseInt(TotalProductWillDelete);
        System.out.println("Số sản phẩm sẽ bị xóa đi khỏi giỏ hàng là "+totalProductWillDelete+" sản phẩm");

        for (int b=1; b<= totalProductWillDelete; b++){
            if (b==1){
                System.out.println("Xóa sản phẩm lần: "+b);
                String NoProductDelete = SetUp_AlphaVersion.prop.getProperty("txt_BasketPopup_NoOfProductDelete_"+b);
                Shopping_ManageBasket_Action.CheckDeleteFunction(SetUp_AlphaVersion.driver,TotalProductWillDelete,NoProductDelete,b);
            }else if (b >1){
                String NoProductDelete = SetUp_AlphaVersion.prop.getProperty("txt_BasketPopup_NoOfProductDelete_"+b);
                int noProductDelete = Integer.parseInt(NoProductDelete);
                if ( noProductDelete >1){
                    int noProductDeleteCurrent = noProductDelete -1;
                    String NoProductDeleteCurrent = String.valueOf(noProductDeleteCurrent);
                    System.out.println("Xóa sản phẩm lần: "+b);
                    Shopping_ManageBasket_Action.CheckDeleteFunction(SetUp_AlphaVersion.driver,TotalProductWillDelete,NoProductDeleteCurrent,b);
                }else if (b ==1){
                    System.out.println("Xóa sản phẩm lần: "+b);
                    Shopping_ManageBasket_Action.CheckDeleteFunction(SetUp_AlphaVersion.driver,TotalProductWillDelete,NoProductDelete,b);
                }
            }

        }
    }

    @Test
    public void TC_Shopping_ManageBasket_06() throws ParseException, InterruptedException {

        Shopping_ManageBasket_Action.clickAddToBasketButton(SetUp_AlphaVersion.driver,"Zend fone 5C");
        Shopping_ManageBasket_Action.clickBuyAnotherButton(SetUp_AlphaVersion.driver);

        Shopping_ManageBasket_Action.clickAddToBasketButton(SetUp_AlphaVersion.driver,"Zend fone 4");

        Shopping_ManageBasket_Action.CheckTotalPrice(SetUp_AlphaVersion.driver);
    }

    @Test
    public void TC_Shopping_ManageBasket_07 (){

    }

    @Test
    public void TC_Shopping_ManageBasket_09(){
        Shopping_ManageBasket_Action.clickAddToBasketButton(SetUp_AlphaVersion.driver,"Zend fone 5C");
        Shopping_ManageBasket_Action.clickBuyAnotherButton(SetUp_AlphaVersion.driver);

        Shopping_ManageBasket_Action.clickAddToBasketButton(SetUp_AlphaVersion.driver,"Zend fone 4");

        Shopping_ManageBasket_Action.CheckAmountProduct(SetUp_AlphaVersion.driver);
    }


   // public void downCrash() {
     //   SetUp.downCrash();
  //  }
}
