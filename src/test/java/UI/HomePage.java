package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        //PageFactory.initElements(driver, homePage);
        driver.manage().window().maximize();
        driver.navigate().to("http://rozetka.com.ua");
        return new HomePage();
    }

    public HomePage open (){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        return HomePage.init(driver);
    }

    public SearchBox getSearchBox() {
        searchBox = PageFactory.initElements(driver, SearchBox.class);
        return searchBox;
    }

    public ResultsPage search(String text){
        searchBox = getSearchBox();
        searchBox.setAndSubmitSearchForm(text);
        ResultsPage resultsPage = PageFactory.initElements(driver, ResultsPage.class);
        ResultsPage.setDriver(driver);
        return resultsPage;
    }

    public void close (){
        driver.close();
    }
}
