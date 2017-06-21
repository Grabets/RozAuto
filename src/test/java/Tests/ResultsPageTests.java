package Tests;

import UI.HomePage;
import UI.ResultsPage;
import UI.SearchBox;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by bogdan on 6/19/2017.
 */
public class ResultsPageTests extends BaseTest {
    WebDriver driver;
    ResultsPage resultsPage;

    @BeforeMethod
    public void beforeMethod(){
        driver = super.getDriver();
        this.resultsPage = ResultsPage.init(driver, "iphone 7");
    }

    private void setResultsPage(String textToSet){
        this.resultsPage = ResultsPage.init(driver, textToSet);
    }

    @Test
    public void openPageTest(){
        setResultsPage("xiaomi redmi 4 prime");
        Assert.assertTrue(resultsPage.isOpened());
    }

    @Test
    public void checkResultPageTest(){
        Assert.assertTrue(resultsPage.isOpened());
    }
}
