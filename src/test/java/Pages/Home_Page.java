package Pages;

public class Home_Page {
    // chọn 1 sản phẩm có tên là iphone 6 ở top bán chạy
    // public static String cardView_Homepage_Product = ".//label[text()='Top bán chạy nhất:']/following::div[@class='col-xs-6 col-sm-4 col-md-2']//p[text()='iphone 6']";

    /**
     * This method help user chooses a product in selected
     * categories and navigates to Product Detail page.
     * @param category Chọn và nhập một trong hai chuỗi:
     *                 'Top bán chạy nhất' hoặc 'Sản phẩm nỗi bật'.
     * @param nameProduct Truyền vào tên sản phẩm: Product.getName()
     * @return Return a xpath.
     */
    public static String getXPathOfAProductOnHomepage(String category, String nameProduct) {
        try {
            if (category.equals("Top bán chạy nhất")) {
                return ".//label[text()='" + category + ":']//following::div[@class='col-xs-6 col-sm-4 col-md-2']//p[text()='" + nameProduct + "']";
            } else {
                return ".//label[text()='" + category + ":']/following::div[@class='col-xs-6 col-sm-4 col-md-3']//p[text()='" + nameProduct + "']";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // If don't have required xpath then get this default xpath.
        return ".//label[text()='Top bán chạy nhất:']/following::div[@class='col-xs-6 col-sm-4 col-md-2']//p[text()='iphone 6']";
    }
}
