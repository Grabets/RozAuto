package Tests;

import Core.SortTypes;
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
public class ResultsPageTest extends BaseTest {
    WebDriver driver;
    ResultsPage resultsPage;
    String searchTerm;

    @BeforeMethod
    public void beforeMethod(){
        driver = super.getDriver();
        HomePage homePage = HomePage.init(driver);
        searchTerm = "iphone 7";
        resultsPage = homePage.search(searchTerm);
    }

    @Test
    public void checkResultPageTest(){
        Assert.assertTrue(resultsPage.isOpened());
    }

    @Test
    public void checkTitle(){
        Assert.assertEquals(searchTerm, resultsPage.getTextTitle());
    }

    @Test
    public void checkCorrectNameOfGoodsInList(){
        Assert.assertTrue(resultsPage.checkAllGoodsContainText(searchTerm));
    }

    @Test
    public void checkSortPriceFromLowerToBigger () {
        SortTypes sortTypes = SortTypes.PRICE_FROM_BIGGER_TO_LOWER;
        Assert.assertTrue(resultsPage.isSortingOfPrice(sortTypes));
    }

}
