package Actions;

import Pages.Home_Page;
import Pages.Shopping_ManageBasket_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class Shopping_ManageBasket_Action {

    public static void clickAddShoppingCartButton(WebDriver driver) {
        // driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Home_Page.btn_Homepage_ShoppingCart)).click();
    }

    public static void clickBuyAnotherButton(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_BuyAnother)).click();
    }

    public static void CheckBasketPopupDisplay(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement BasketPopupTitle = driver.findElement(By.xpath(Shopping_ManageBasket_Page.txt_BasketPopup_Title));
        boolean Check = BasketPopupTitle.isEnabled();
        // Anh, chỗ ni mình có thể chuyển từ 'Check == true'
        // thành 'Check'. Vì em thấy cái vạch màu vàng ở bên
        // cạnh gợi ý như vậy. Vì đơn giản ý em là sửa lại
        // cho nó hết màu vàng bên cạnh nhìn cho nó đẹp ý mà!!!
        if (Check == true) {
            System.out.printf("TC_Shopping_ManageBasket_01: Pass. Basket pop up is displayed");
        } else {
            System.out.printf("TC_Shopping_ManageBasket_01: Failed. Basket pop up isn't displayed");
        }
    }

    public static String getNameProductOnHomepage(WebDriver driver) {
        return driver.findElement(By.xpath(Home_Page.txt_Homepage_NameProduct)).getText();
    }

    public static String getTitleOnBasketPopup(WebDriver driver) {
        return driver.findElement(By.xpath(Shopping_ManageBasket_Page.txt_BasketPopup_Title)).getText();
    }

    public static String getNameProductOnBasketPopup(WebDriver driver, String nameProduct) {
        return driver.findElement(By.xpath(Shopping_ManageBasket_Page.getXPathOfNameProductOnBasketPopup(nameProduct))).getText();
    }

    // Nút này hiển thị ở phía dưới của mỗi cardview.
    public static void clickAddToBasketButton(WebDriver driver, String Productname) {

        WebElement ProductAddCartBtn = driver.findElement(By.xpath(".//div[@class='products-content-label' and contains(.,'"+Productname+"')]/button[@class='btn btn-danger cart_class']"));
        ProductAddCartBtn.click();

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

        for (int i = 1; i>0; i++){

            WebElement NameProduct = driver.findElement(By.xpath(".//div[@id=\"view_cart\"]/table/tbody/tr["+i+"]/td[2]"));

            if(NameProduct.isDisplayed()==true){
                WebElement discount = driver.findElement(By.xpath(".//div[@id='view_cart']/table/tbody/tr["+i+"]/td[3]/label"));
                WebElement unitPrice = driver.findElement(By.xpath(".//div[@id='view_cart']/table/tbody/tr["+i+"]/td[5]/label"));
                WebElement estimatedSubtotal = driver.findElement(By.xpath(".//div[@id='view_cart']/table/tbody/tr["+i+"]/td[6]/label"));

                String Discoutn = discount.getAttribute("textContent") ;
                NumberFormat format1 = NumberFormat.getPercentInstance();
                Number a = format1.parse(Discoutn);
                String UnitPrice = unitPrice.getAttribute("textContent");
                NumberFormat format2 = NumberFormat.getNumberInstance();
                Number b = format2.parse(UnitPrice);
                String EstimatedSubtotal = estimatedSubtotal.getAttribute("textContent");
                Number c = format2.parse(EstimatedSubtotal);

                double A = Double.parseDouble(String.valueOf(a));

                int B = Integer.parseInt(String.valueOf(b));
                int C = Integer.parseInt(String.valueOf(c));

                double Check = B-(A*(B*1.0));
                int SubPriceWithDiscount = (int) Check;
                if (A > 0){
                    if (C == SubPriceWithDiscount){
                        System.out.println("TC_Shopping_ManageBasket_06: Passed Total Price = "+SubPriceWithDiscount+"đ");
                    }else {
                        System.out.printf("TC_Shopping_ManageBasket_06 (Discount): Failed");
                    }
                }else if (B == C){
                    System.out.println("TC_Shopping_ManageBasket_06: Passed Total Price = "+C+"đ");
                }else {
                    System.out.printf("TC_Shopping_ManageBasket_06: Failed");
                }
            }else {
                System.out.println("Basket Empty");
                break;
            }
        }

    }

    public static void clickLoginLink(WebDriver driver) {
        driver.findElement(By.xpath(Shopping_ManageBasket_Page.btn_BasketPopup_LoginLink)).click();
    }
}
