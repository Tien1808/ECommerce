package Pages;

public class Shopping_ManageBasket_Page {
    public static String btn_BasketPopup_OrderNow = ".//button[@id='order_product']";
    public static String txt_BasketPopup_Title = ".//div[@id='cart_modal']//h4[@class='modal-title']";

    public static String txt_BasketPopup_Empty = ".//div[@id='view_cart']//div[@class='col-md-12 text-center text-danger']//h1";

    public static String btn_BasketPopup_Order_Disable = ".//button[@class='btn btn-danger btn-block btn-lg disabled' and contains(.,'Đặt hàng ngay')]";

    public static String txt_BasketPopup_NameProduct = ".//div[@id='view_cart']//child::tbody//tr[1]//td[2]";
    public static String btn_BasketPopup_Order = ".//button[@id='order_product']";

    public static String btn_BasketPopup_LoginLink = ".//a[text()='Click vào đây để đăng nhập']";

    public static String txt_BasketPopup_Discount = ".//div[@id='view_cart']/table/tbody/tr[1]/td[3]/label";

    public static String txt_BasketPopup_UnitPrice = ".//div[@id='view_cart']/table/tbody/tr[1]/td[5]/label";

    public static String txt_BasketPopup_EstimatedSubtotal = ".//div[@id='view_cart']/table/tbody/tr[1]/td[6]/label";

    public static String btn_BasketPopup_BuyAnother = ".//button[@class ='btn btn-success btn-block btn-lg' and contains(.,'Mua tiếp sản phẩm')]";

    public static String getXPathOfNameProductOnBasketPopup(String nameProduct) {
        return ".//div[@id='view_cart']//td[text()='" + nameProduct + "']";
    }
}
