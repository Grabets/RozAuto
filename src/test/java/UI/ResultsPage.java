package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

/**
 * Created by bogdan on 6/15/2017.
 */
public class ResultsPage {

    //TODO: how I can find this webelement using ccs selector?

    @FindBy(how = How.XPATH, using = "//div[@class='g-i-tile-l clearfix']")
    WebElement resultForm;
    @FindBy(how = How.CLASS_NAME, using = "m-main-classic-stype ")
    WebElement katalogButton;
    @FindBy (how = How.CLASS_NAME, using = "border-right")
    WebElement searchSettings;

    private static WebDriver driver;
    private SearchBox searchBox;
    private String searchTextValue;

    public ResultsPage (){
        searchBox = PageFactory.initElements(driver, SearchBox.class);
    }

    public static void setDriver(WebDriver driver) {
        ResultsPage.driver = driver;
    }

    public SearchBox getSearchBox() {
        return searchBox;
    }

    public Boolean isOpened (){
        return driver.findElement(By.cssSelector(".rz-search-result-qnty")).isDisplayed();
    }

    public String getTextTitle(){
        return resultForm.findElement(By.id("search_result_title_text")).getText();
    }

    public Boolean checkNameofGoods(){
//        List<WebElement> webElementList = resultForm.findElements(By.xpath("//div[@class='g-i-tile g-i-tile-catalog']"));
//        Iterator<WebElement> iterator = webElementList.iterator();
//        while (iterator.hasNext()){
//            String nameOfGoods = iterator.next().findElement(By.xpath("//div[@class = 'g-i-tile-i-title clearfix']/a")).getText();
//            System.out.println(nameOfGoods);
//            if (!nameOfGoods.toLowerCase().contains("iphone 7"))
//                    return false;
//        }
        for (int i = 2; i < 34 ; i++) {
            String xPathExpression = "//*[@id='block_with_search']/div/div["+i+"]//div[@class = 'g-i-tile-i-title clearfix']/a";
            WebElement goods = resultForm.findElement(By.xpath(xPathExpression));
            String nameOfGoods = goods.getText();
            System.out.println(nameOfGoods);
            if (!nameOfGoods.toLowerCase().contains("iphone 7"))
                return false;
        }
        return true;
    }
}
