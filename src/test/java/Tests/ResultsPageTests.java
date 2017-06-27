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
        HomePage homePage = HomePage.init(driver);
        resultsPage = homePage.search("iphone 7");
    }

    @Test
    public void checkResultPageTest(){
        Assert.assertTrue(resultsPage.isOpened());
    }

    @Test
    public void checkTitle(){
        Assert.assertEquals("iphone 7", resultsPage.getTextTitle());
    }

    @Test
    public void checkCorrectGoodsInList(){
        Assert.assertTrue(resultsPage.checkNameofGoods());
    }

}
