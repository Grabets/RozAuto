package UI;

import com.sun.org.apache.regexp.internal.RE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bogdan on 6/15/2017.
 */
public class ResultsPage {

    static WebDriver driver;
    static SearchBox searchBox;
    private String searchTextValue;

    public static ResultsPage init(WebDriver driverArg, String searchTextToSet){
        driver = driverArg;
        HomePage homePage = HomePage.init(driver);
        homePage.getSearchBox().setAndSubmitSearchForm(searchTextToSet);
        ResultsPage resultsPage = new ResultsPage();
        PageFactory.initElements(driver, resultsPage);
        return new ResultsPage();
    }

    public SearchBox getSearchBox() {
        searchBox = PageFactory.initElements(driver, SearchBox.class);
        return searchBox;
    }




    public ResultsPage (){

    }

    public ResultsPage (WebDriver driver){
        this.driver = driver;
    }

    public Boolean isOpened (){
        return driver.findElement(By.cssSelector(".rz-search-result-qnty")).isDisplayed();
    }


}
