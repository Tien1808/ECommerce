package Actions;

import Pages.Shopping_SearchTool_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.transform.sax.SAXResult;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Shopping_Search_Action {
    public static void clickSearchBar(WebDriver driver) {
        /**
         WebElement element = driver.findElement(By.xpath(Shopping_SearchTool_Page.Homepage_Searchbar));
         Actions actions = new Actions(driver);
         actions.moveToElement(element).click().perform();*/

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath(Shopping_SearchTool_Page.txt_Homepage_Searchbar)).click();
    }
    public static void CheckDisplaySearchTool(WebDriver driver){
        String SearchBarResult ;
        String GoBtnResult ;

        boolean CheckSearchBar = driver.findElement(By.xpath(Shopping_SearchTool_Page.txt_SearchTool_SearchBar)).isEnabled();
        if (CheckSearchBar == true){
            SearchBarResult = "Search bar is display";
        }else {
            SearchBarResult = "Search bar isn't display";
        }

        boolean CheckGoBtn = driver.findElement(By.xpath(Shopping_SearchTool_Page.Btn_SearchTool_Go)).isEnabled();
        if (CheckGoBtn == true){
            GoBtnResult = "Go button is display";
        }else {
            GoBtnResult = "Go button isn't display";
        }

        if (CheckGoBtn == true && CheckSearchBar == true){
            System.out.println("Testcase TC_Shopping_SearchTool_01: Passe. "+SearchBarResult+" and "+GoBtnResult);
        }else {
            System.out.printf("Testcase TC_Shopping_SearchTool_02: Failed. "+SearchBarResult+" and "+GoBtnResult);
        }
    }

    public static void CheckKeyWord(WebDriver driver, String keyword){

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Shopping_SearchTool_Page.txt_SearchTool_SearchBar)));
        driver.findElement(By.xpath(Shopping_SearchTool_Page.txt_SearchTool_SearchBar)).sendKeys(keyword);
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);

        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        List list = driver.findElements(By.xpath(Shopping_SearchTool_Page.txt_SearchTool_AutoSuggest_ProductName));
        System.out.println("Số lượng sản phẩm tìm được với keyword '"+keyword+"' là "+list.size()+" sản phẩm");

        for(int i = 1 ;i<= list.size();i++){
            WebElement element = driver.findElement(By.xpath(".//div[@id=\"search_show\"]/div["+i+"]/div[2]/label/a"));
            String ProductName = element.getText();

            if (ProductName.toLowerCase().contains(keyword.toLowerCase()) & i<list.size()){
                System.out.println("Sản phẩm thứ "+i+": "+ProductName);
            }else if (ProductName.toLowerCase().contains(keyword.toLowerCase()) & i==list.size()){
                System.out.println("Sản phẩm thứ "+i+": "+ProductName);
                System.out.printf("TC_ShoppingSearchTool_02: Pass");
            }
            else if (!ProductName.toLowerCase().contains(keyword.toLowerCase())&& i<=list.size()){
                System.out.printf("TC_ShoppingSearchTool_02: Failed");
            }
        }
    }

    public static void SearchProductDetail(WebDriver driver, String keyword){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Shopping_SearchTool_Page.txt_SearchTool_SearchBar)));
        driver.findElement(By.xpath(Shopping_SearchTool_Page.txt_SearchTool_SearchBar)).sendKeys(keyword);

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        List listProduct = driver.findElements(By.xpath(Shopping_SearchTool_Page.txt_SearchTool_AutoSuggest_ProductName));
        List listPrice = driver.findElements(By.xpath(Shopping_SearchTool_Page.txt_SearchTool_AutoSuggest_ProductPrice));
        System.out.println("Số lượng sản phẩm tìm được với keyword '"+keyword+"' là "+listProduct.size()+" sản phẩm");

        for(int i = 1 ;i<= listProduct.size();i++){
            WebElement elementProduct = driver.findElement(By.xpath(".//div[@id='search_show']/div["+i+"]/div[2]/label/a"));
            String ProductName = elementProduct.getText();

            WebElement elementPrice = driver.findElement(By.xpath(".//div[@id='search_show']/div["+i+"]/div[3]/label/span"));
            String ProductPrice = elementPrice.getText();

            if (ProductName.toLowerCase().contains(keyword.toLowerCase()) & i<listProduct.size()){
                System.out.println("Product Detail No."+i+": Name: "+ProductName+" Price:"+ProductPrice);
            }else if (ProductName.toLowerCase().contains(keyword.toLowerCase()) & i==listProduct.size()){
                System.out.println("Product Detail No."+i+": Name: "+ProductName+" Price:"+ProductPrice);
                System.out.printf("TC_ShoppingSearchTool_04: Pass");
            }
            else if (!ProductName.toLowerCase().contains(keyword.toLowerCase())&& i<=listProduct.size()){
                System.out.printf("TC_ShoppingSearchTool_04: Failed");
            }
        }
    }
}
