package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bogdan on 6/8/2017.
 */
public class HomePage {

    private SearchBox searchBox;
    static WebDriver driver;

    public static HomePage init(WebDriver driverArg){
        driver = driverArg;
        HomePage homePage = new HomePage();
        PageFactory.initElements(driver, homePage);
        driver.manage().window().maximize();
        driver.navigate().to("http://rozetka.com.ua");
        return new HomePage();
    }

    public SearchBox getSearchBox() {
        searchBox = PageFactory.initElements(driver, SearchBox.class);
        return searchBox;
    }

    public ResultsPage search(String text){
        searchBox = getSearchBox();
        searchBox.setSearchForm(text);
        searchBox.clickSearchButton();
        return new ResultsPage(driver);
    }
}
