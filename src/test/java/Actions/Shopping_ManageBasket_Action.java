package Actions;

import Commons.SetUp_AlphaVersion;
import Pages.Home_Page;
import Pages.Shopping_ManageBasket_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Shopping_ManageBasket_Action extends SetUp_AlphaVersion {

    public static void clickAddShoppingCartButton(WebDriver driver) {
        // driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Home_Page.btn_Homepage_ShoppingCart)).click();
    }

    public static void clickBuyAnotherButton(WebDriver driver){
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_BuyAnother)).click();
        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_BuyAnother)));
        element.click();

    }

    public static void CheckBasketPopupDisplay(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement BasketPopupTitle = driver.findElement(By.xpath(Shopping_ManageBasket_Page.txt_BasketPopup_Title));
        boolean Check = BasketPopupTitle.isEnabled();

        if (Check) {
            System.out.printf("TC_Shopping_ManageBasket_01: Pass. Basket pop up is displayed");
        } else {
            System.out.printf("TC_Shopping_ManageBasket_01: Failed. Basket pop up isn't displayed");
        }
    }


    public static String getTitleOnBasketPopup(WebDriver driver) {
        return driver.findElement(By.xpath(Shopping_ManageBasket_Page.txt_BasketPopup_Title)).getText();
    }

    public static String getNameProductOnBasketPopup(WebDriver driver, String nameProduct) {
        return driver.findElement(By.xpath(Shopping_ManageBasket_Page.getXPathOfNameProductOnBasketPopup(nameProduct))).getText();
    }

    // Nút này hiển thị ở phía dưới của mỗi cardview.
    public static void clickAddToBasketButton(WebDriver driver, String Productname) {
/**
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        WebElement ProductAddCartBtn = driver.findElement(By.xpath(".//div[@class='products-content-label' and contains(.,'"+Productname+"')]/button[@class='btn btn-danger cart_class']"));
        ProductAddCartBtn.click();
*/
        WebDriverWait wait= new WebDriverWait(driver, 20);
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='products-content-label' and contains(.,'"+Productname+"')]/button[@class='btn btn-danger cart_class']")));
        element.click();
    }

    /**
     * Chuyển tới Checkout popup để xác nhận thông tin.
     * @param driver Driver.
     */
    public static void clickOderNowButton(WebDriver driver) {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_OrderNow)).click();
//        WebElement element = driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_Order));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).click().build().perform();
    }

    public static void CheckEmptyBasket(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement Empty = driver.findElement(By.xpath(Shopping_ManageBasket_Page.txt_BasketPopup_Empty));
        String Text = Empty.getText();
        boolean CheckEmpty = Empty.isEnabled();
        if (CheckEmpty == true) {
            System.out.println("Empty message is display. TC_Shopping_ManageBasket_02: Passed");
        } else {
            System.out.println("Empty message isn't display. TC_Shopping_ManageBasket_02: Failed");
        }

        WebElement OrderEmptyBtn = driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_Order_Disable));
        boolean CheckBtn = OrderEmptyBtn.isEnabled();
        if (CheckBtn == true) {
            System.out.println("Order button is disable. TC_Shopping_ManageBasket_03: Passed");
        } else {
            System.out.println("Order button is enable. TC_Shopping_ManageBasket_03: Passed");
        }

        if (CheckEmpty == true && CheckBtn == true) {
            System.out.println("TC_Shopping_ManageBasket_02 and TC_Shopping_ManageBasket_03: Pass");
        } else {
            System.out.println("TC_Shopping_ManageBasket_02 and TC_Shopping_ManageBasket_03: Failed");
        }
    }

    public static void CheckTotalPrice(WebDriver driver) throws ParseException {
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);

            List ProductList = driver.findElements(By.xpath("//div[@id=\"view_cart\"]/table/tbody/tr/td/img"));

            for (int i = 1; i<= ProductList.size(); i++){

                if(driver.findElement(By.xpath(".//div[@id=\"view_cart\"]/table/tbody/tr[" + i + "]/td[2]")).isEnabled()){
                    NumberFormat format2 = NumberFormat.getNumberInstance();
                    Number Limit = format2.parse(String.valueOf(ProductList.size()));
                    int limit = Integer.parseInt(String.valueOf(Limit));
                    WebElement ProductName = driver.findElement(By.xpath(".//div[@id=\"view_cart\"]/table/tbody/tr["+i+"]/td[2]"));
                    WebElement discount = driver.findElement(By.xpath(".//div[@id='view_cart']/table/tbody/tr["+i+"]/td[3]/label"));
                    WebElement unitPrice = driver.findElement(By.xpath(".//div[@id='view_cart']/table/tbody/tr["+i+"]/td[5]/label"));
                    WebElement estimatedSubtotal = driver.findElement(By.xpath(".//div[@id='view_cart']/table/tbody/tr["+i+"]/td[6]/label"));

                    String productName = ProductName.getAttribute("textContent");
                    String Discoutn = discount.getAttribute("textContent") ;
                    NumberFormat format1 = NumberFormat.getPercentInstance();
                    Number a = format1.parse(Discoutn);
                    String UnitPrice = unitPrice.getAttribute("textContent");
                    Number b = format2.parse(UnitPrice);
                    String EstimatedSubtotal = estimatedSubtotal.getAttribute("textContent");
                    Number c = format2.parse(EstimatedSubtotal);

                    double A = Double.parseDouble(String.valueOf(a));

                    int B = Integer.parseInt(String.valueOf(b));
                    int C = Integer.parseInt(String.valueOf(c));

                    double Check = B-(A*(B*1.0));
                    int SubPriceWithDiscount = (int) Check;
                    if (A > 0 ){
                        if (C == SubPriceWithDiscount && i < limit){
                            System.out.println("Product name: "+productName+". Total Price = "+SubPriceWithDiscount+"đ");
                        } else if (C == SubPriceWithDiscount && i == limit) {
                            System.out.println("Product name: "+productName+". Total Price = "+SubPriceWithDiscount+"đ");
                            System.out.println("TC_Shopping_ManageBasket_06: Passed");
                        }else {
                            System.out.println("TC_Shopping_ManageBasket_06: Failed");
                        }
                    }else if (B == C && i < limit){
                        System.out.println("Product name: "+productName+". Total Price = "+C+"đ");
                    }else if (B == C && i == limit){
                        System.out.println("Product name: "+productName+". Total Price = "+C+"đ");
                        System.out.println("TC_Shopping_ManageBasket_06: Passed");
                    } else {
                        System.out.println("TC_Shopping_ManageBasket_06: Failed");
                    }
                }
            }
    }

    public static void CheckAmountProduct (WebDriver driver){

        List ProductList = driver.findElements(By.xpath("//div[@id=\"view_cart\"]/table/tbody/tr/td/img"));
        int AmountProductBasketPopup = ProductList.size();
        System.out.println("Số lượng sản phẩm hiển thị trong Basket pop-up là: "+AmountProductBasketPopup+" sản phẩm");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement Element = driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_BuyAnother));
        Element.click();

        String AmountProductInHomepage =  driver.findElement(By.xpath(Home_Page.txt_Homepage_ProductAmountInBasket)).getAttribute("textContent");
        int AmountProductHomepgae = Integer.parseInt(AmountProductInHomepage);
        System.out.println("Số lượng sản phẩm hiển thị ở Main Page là: "+AmountProductHomepgae+" sản phẩm" );

        if (AmountProductHomepgae== AmountProductBasketPopup){
            System.out.println("TC_Shopping_ManageBasket_09: Passed.");
        }else {
            System.out.printf("TC_Shopping_ManageBasket_09: Failed.");
        }
    }

    public static void CheckDeleteFunction (WebDriver driver, String TotalProductWillDelete, String NoProduct, int j) {

        List ProductList=driver.findElements(By.xpath("//div[@id=\"view_cart\"]/table/tbody/tr/td/img"));
        int List=ProductList.size();
        System.out.println("Số lượng sản phẩm có trong Basket trước khi xóa: " + List + " sản phẩm");
        int NewList=List;
        int totalProductWillDelete=Integer.parseInt(TotalProductWillDelete);
        int noProduct=Integer.parseInt(NoProduct);

        if (noProduct >=2 ) {
            WebElement element=driver.findElement(By.xpath(".//div[@id=\"view_cart\"]/table/tbody/tr[" + NoProduct + "]/td[7]/span"));
            element.click();
            NewList=NewList - 1;
            System.out.println("Số lượng sản phẩm sau khi xóa lần "+j+" là "+NewList+" sản phẩm");
            if (j == totalProductWillDelete)
            {
                if (NewList < List){
                    System.out.println("TC_Shopping_ManageBasket_04: Passed");
                    System.out.println("Số lượng sản phẩm còn lại trong Basket: " + NewList + " sản phẩm");
                }else {
                    System.out.println("TC_Shopping_ManageBasket_04: Failed");
                    }
                }
            } else if (noProduct == 1) {
                WebElement element=driver.findElement(By.xpath(".//div[@id=\"view_cart\"]/table/tbody/tr[" + NoProduct + "]/td[7]/span"));
                element.click();
                NewList=NewList - 1;
                System.out.println("Số lượng sản phẩm sau khi xóa lần "+j+" là "+NewList+" sản phẩm");

                if (j == totalProductWillDelete)
                {
                    if (NewList < List){
                        System.out.println("TC_Shopping_ManageBasket_04: Passed");
                        System.out.println("Số lượng sản phẩm còn lại trong Basket: " + NewList + " sản phẩm");
                    }else {
                        System.out.println("TC_Shopping_ManageBasket_04: Failed");
                    }
                }
            }
    }

    public static void clickLoginLink(WebDriver driver) {
        driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_LoginLink)).click();
    }
}
