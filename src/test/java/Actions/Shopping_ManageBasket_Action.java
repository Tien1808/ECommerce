package Actions;

import Pages.Shopping_ManageBasket_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class Shopping_ManageBasket_Action {

    public static void clickAddShoppingCartButton(WebDriver driver) {
        // driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_Homepage_ShoppingCart)).click();
    }

    public static void clickBuyAnotherButton(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_BuyAnother)).click();
    }

    public static void CheckBasketPopupDisplay(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement BasketPopupTitle = driver.findElement(By.xpath(Shopping_ManageBasket_Page.txt_BasketPopup_Title));
        boolean Check = BasketPopupTitle.isEnabled();
        if (Check == true) {
            System.out.printf("TC_Shopping_ManageBasket_01: Pass. Basket pop up is displayed");
        } else {
            System.out.printf("TC_Shopping_ManageBasket_01: Failed. Basket pop up isn't displayed");
        }
    }

    public static String getNameProductOnHomepage(WebDriver driver) {
        return driver.findElement(By.xpath(Shopping_ManageBasket_Page.txt_Homepage_NameProduct)).getText();
    }

    // Nút này hiển thị ở phía dưới của mỗi cardview.
    public static void clickAddToBasketButton(WebDriver driver, String Productname) {

        WebElement ProductAddCartBtn = driver.findElement(By.xpath(".//div[@class='products-content-label' and contains(.,'" + Productname + "')]/button[@class='btn btn-danger cart_class']"));
        ProductAddCartBtn.click();
    }

    /**
     * Chuyển tới Checkout popup để xác nhận thông tin.
     *
     * @param driver
     */
    public static void clickOderButton(WebDriver driver) {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_Order)).click();
        WebElement element = driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_Order));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public static void CheckEmptyBasket(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement Empty = driver.findElement(By.xpath(Shopping_ManageBasket_Page.txt_BasketPopup_Empty));
        String Text = Empty.getText();
        boolean CheckEmpty = Empty.isEnabled();
        if (CheckEmpty == true) {
            System.out.println("Empty message is display");
        } else {
            System.out.println("Empty message isn't display");
        }

        WebElement OrderEmptyBtn = driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_Order_Disable));
        boolean CheckBtn = OrderEmptyBtn.isEnabled();
        if (CheckBtn == true) {
            System.out.println("Order button is disable");
        } else {
            System.out.println("Order button is enable");
        }

        if (CheckEmpty == true && CheckBtn == true) {
            System.out.println("TC_Shopping_ManageBasket_02 and TC_Shopping_ManageBasket_03: Pass");
        } else {
            System.out.println("TC_Shopping_ManageBasket_02 and TC_Shopping_ManageBasket_03: Faild");
        }
    }

    public static void CheckTotalPrice(WebDriver driver) throws ParseException {
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        WebElement discount = driver.findElement(By.xpath(Shopping_ManageBasket_Page.txt_BasketPopup_Discount));
        WebElement unitPrice = driver.findElement(By.xpath(Shopping_ManageBasket_Page.txt_BasketPopup_UnitPrice));
        WebElement estimatedSubtotal = driver.findElement(By.xpath(Shopping_ManageBasket_Page.txt_BasketPopup_EstimatedSubtotal));

        String EstimatedSubtotal = estimatedSubtotal.getText();

        String Discoutn = discount. getAttribute("textContent") ;
        NumberFormat format = NumberFormat.getCurrencyInstance();
        //Number a = format.parse(Discoutn);
        String UnitPrice = unitPrice. getAttribute("textContent");
        Number b = format.parse(UnitPrice);

        //System.out.println(a.toString());
        System.out.println(b.toString());
/**
        long a = Integer.parseInt(Discoutn);
        int b = Integer.parseInt(UnitPrice);

        int Check = (int) (a*b);

        String check = String.valueOf(Check);

        if (EstimatedSubtotal.toLowerCase().contains(check)){
            System.out.println("Passed");
        }else {
            System.out.printf("failed");
        }*/

    }

    public static void clickLoginLink(WebDriver driver) {
        driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_LoginLink)).click();
    }
}
