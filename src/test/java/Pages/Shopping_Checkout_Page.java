package Pages;

import Objects.Product;

public class Shopping_Checkout_Page {
    public static String txt_CheckoutPopup_NameProduct(String nameProduct) {
        return ".//label[text()='" + nameProduct + "']";
    }
    //public static String txt_CheckoutPopup_NameProduct = ".//label[text()='samsung']";

    public static String txt_CheckoutPopup_Password = ".//input[@id='password_od']";

    public static String btn_CheckoutPopup_Cancel = ".//button[@id='cancel_order']";

    // public static String btn_CheckoutPopup_Checkout = ".//button[@id='order_success']";
    public static String btn_CheckoutPopup_Checkout = ".//button[text()=' Thanh toán ']";
}
