package Actions;

import Pages.Home_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_Action {

    /**
     * Click an item with the name selected in the category
     * selected and navigates to Product Detail page.
     * @param driver Driver.
     * @param criteria Chọn và nhập một trong hai chuỗi:
     *      *          'Top bán chạy nhất' hoặc 'Sản phẩm nổi bật'.
     * @param nameProduct Truyền vào tên sản phẩm: Product.getName()
     */
    public static void clickAnItemOnHomepage(WebDriver driver, String criteria, String nameProduct) {
        driver.findElement(By.xpath(Home_Page.getXPathOfAProductOnHomepage(criteria, nameProduct))).click();
    }
}
