package Pages;

import Objects.Product;

public class Page_Shopping_Checkout {
    // XPath ở đây là dynamic, nên phải có đối tượng.
    public static String txt_CheckoutPopup_NameProduct(String nameProduct) {
        return ".//label[text()='" + nameProduct + "']";
    }
}
