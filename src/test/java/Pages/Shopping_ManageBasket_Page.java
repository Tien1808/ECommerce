package Pages;

import org.openqa.selenium.WebDriver;

public class Shopping_ManageBasket_Page {
    public static String txt_BasketPopup_Title = ".//h4[contains(text(),'Giỏ hàng của bạn')]";

    // Nút giỏ hàng trên homepage.
    public static String btn_Homepage_ShoppingCart = ".//span[text()='Giỏ Hàng']";

    // Tên của sản phẩm trên trang chủ.
    public static String txt_Homepage_NameProduct = ".//a[@href='product_details.php?pid=3']//child::p";

    public static String btn_BasketPopup_OrderNow = ".//button[@id='order_product']";

    public static String btn_BasketPopup_LoginLink = ".//a[text()='Click vào đây để đăng nhập']";

    // Tạm thời để cái này ở đây vì chưa rõ nó thuộc phần nào.
    // Cái này là để thêm sản phẩm vào giỏ hàng trên homepage.
    public static String btn_Homepage_AddToBasket = ".//a[@href='product_details.php?pid=3']//following-sibling::button//span";

    public static String getXPathOfNameProductOnBasketPopup(String nameProduct) {
        return ".//div[@id='view_cart']//td[text()='" + nameProduct + "']";
    }
}
