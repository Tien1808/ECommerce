package Pages;

public class Home_Page {
    public static String btn_Homepage_ShoppingCart = ".//div[@class='col-sm-4 col-md-3 col-lg-3 login-top']//span[@class='header-login'][contains(text(),'Giỏ Hàng')]";

    // Cái này là để thêm sản phẩm vào giỏ hàng trên homepage.
    public static String btn_Homepage_AddToBasket = ".//a[@href='product_details.php?pid=3']//following-sibling::button//span";

    // chọn 1 sản phẩm có tên là iphone 6 ở top bán chạy
    // public static String cardView_Homepage_Product = ".//label[text()='Top bán chạy nhất:']/following::div[@class='col-xs-6 col-sm-4 col-md-2']//p[text()='iphone 6']";

    /**
     * This method help user chooses a product in selected
     * categories and navigates to Product Detail page.
     * @param criteria Chọn và nhập một trong hai chuỗi:
     *                 'Top bán chạy nhất' hoặc 'Sản phẩm nỗi bật'.
     * @param nameProduct Truyền vào tên sản phẩm: Product.getName()
     * @return Return a xpath.
     */
    public static String getXPathOfAProductOnHomepage(String criteria, String nameProduct) {
        try {
            if (criteria.equals("Top bán chạy nhất")) {
                return ".//label[text()='" + criteria + ":']//following::div[@class='col-xs-6 col-sm-4 col-md-2']//p[text()='" + nameProduct + "']";
            } else {
                return ".//label[text()='" + criteria + ":']/following::div[@class='col-xs-6 col-sm-4 col-md-3']//p[text()='" + nameProduct + "']";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // If don't have required xpath then get this default xpath.
        return ".//label[text()='Top bán chạy nhất:']/following::div[@class='col-xs-6 col-sm-4 col-md-2']//p[text()='iphone 6']";
    }

    public static String txt_Homepage_NameProduct = ".//a[@href='product_details.php?pid=3']//child::p";

    public static String txt_Homepage_ProductAmountInBasket = ".//div[@class='col-sm-4 col-md-3 col-lg-3 login-top']//kbd[@class='bg-danger']/span";
}
