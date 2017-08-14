package UI;

import Core.SortTypes;
import com.google.common.collect.Comparators;
import com.google.common.collect.Ordering;
import org.apache.xpath.operations.Or;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

/**
 * Created by bogdan on 6/15/2017.
 */
public class ResultsPage {


    @FindBy(how = How.XPATH, using = "//div[@class='g-i-tile-l clearfix']")
    WebElement resultForm;
    @FindBy(how = How.CLASS_NAME, using = "m-main-classic-stype ")
    WebElement katalogButton;
    @FindBy (how = How.CLASS_NAME, using = "border-right")
    WebElement searchSettings;
    @FindBy(how = How.CSS, using = ".g-i-tile.g-i-tile-catalog:not(.preloader-trigger)")
    List<WebElement> searchResult;

    private static WebDriver driver;
    private SearchBox searchBox;

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

    public Boolean checkAllGoodsContainText(String testTerm){
        String nameOfGoodsCssSelector = ".g-i-tile-i-title.clearfix > a";
        for (WebElement webElement : searchResult) {
            String nameOfGoods = webElement.findElement(By.cssSelector(nameOfGoodsCssSelector)).getText();
            if (!nameOfGoods.toLowerCase().contains(testTerm))
                return false;
        }
        return true;
    }

    public Boolean isSortingOfPrice (SortTypes types){
        sortGoods(types);
        List<Integer> list = getListOfPrice(searchResult);
        return isPriceListSorted(list, types);
    }

    private void sortGoods (SortTypes types){
        String sortingFilterLocator = "//a[@name='drop_link']";
        resultForm.findElement(By.xpath(sortingFilterLocator)).click();
        resultForm.findElement(By.xpath(types.getLocator())).click();
    }

    private List<Integer> getListOfPrice (List<WebElement> webElementList){
        String priceOfGoodsXPath = ".//div[@class='g-price-uah']/span[1]";
        List<Integer> listOfPrice = new ArrayList<Integer>();
        for (WebElement webElement : webElementList) {
            WebElement goodsPrice = webElement.findElement(By.xpath(priceOfGoodsXPath));
            listOfPrice.add(Integer.parseInt(goodsPrice.getText().replaceAll(" ","")));
        }
        return listOfPrice;
    }

    private Boolean isPriceListSorted (List<Integer> listOfPrice, SortTypes types){
    if (types.equals(SortTypes.PRICE_FROM_LOWER_TO_BIGGER))
        return Ordering.natural().isOrdered(listOfPrice);
    else
        return Ordering.natural().reverse().isOrdered(listOfPrice);
    }



}
