package Pages;

public class Page_Shopping_ManageBasket {
    // XPath được bắt ở đây vì lý do nó hỗ trợ cho phần shopping checkout.
    // Nhưng xét thấy nó có liên quan tới phần quản lý giỏ hàng, nên tách
    // nó ra page riêng để sau sử dụng luôn.

    // Nút giỏ hàng trên homepage.
    public static String btn_Homepage_Basket = ".//span[text()='Giỏ Hàng']";

    public static String txt_BasketPopup_NameProduct = ".//div[@id='view_cart']//child::tr[2]//td[2]";
    public static String btn_BasketPopup_Order = ".//button[@id='order_product']";

    public static String btn_BasketPopup_LoginLink = ".//a[text()='Click vào đây để đăng nhập']";

    // Tạm thời để cái này ở đây vì chưa rõ nó thuộc phần nào.
    // Cái này là để thêm sản phẩm vào giỏ hàng trên homepage.
    public static String btn_Homepage_AddToBasket = ".//a[@href='product_details.php?pid=3']//following-sibling::button";
}
