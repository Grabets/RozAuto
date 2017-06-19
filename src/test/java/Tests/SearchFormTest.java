package Tests;

import UI.HomePage;
import UI.ResultsPage;
import UI.SearchBox;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by bogdan on 6/15/2017.
 */
public class SearchFormTest extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    SearchBox searchBox;
    ResultsPage resultsPage;

    @BeforeMethod
    public void beforeTest(){
        this.driver = super.getDriver();
        this.homePage = HomePage.init(driver);
        this.searchBox = homePage.getSearchBox();
        this.resultsPage = new ResultsPage(driver);
    }

    @Test
    public void submitTest(){
        String text = "алезан";
        searchBox.setSearchForm(text);
        searchBox.clickSearchButton();
        Assert.assertTrue(resultsPage.isOpened());
    }

    @Test
    public void searchTest(){
        String text = "алезан";
        ResultsPage resultsPage = homePage.search(text);
        Assert.assertTrue(resultsPage.isOpened());
    }

    @Test
    public void setSearchForm(){
        String text = "алезан";
        searchBox.setSearchForm(text);
        Assert.assertEquals(text, searchBox.getSearchFormText());
    }

    @Test
    public void clearSearchForm(){
        Assert.assertEquals("", searchBox.getSearchFormText());
    }

    @Test
    public void chooseCategory(){
        String category = "Телефоны, MP3, GPS";
        searchBox.chooseCategory(category);
        Assert.assertEquals(searchBox.getCategory(),category);
    }

    @Test
    public void checkSearchHistory(){
        String textSearch1 = "BV6000";
        searchBox.setAndSubmitSearchForm(textSearch1);
        driver.navigate().back();
        searchBox.searchInputClick(driver);
        Assert.assertTrue(searchBox.checkSearchHistory(textSearch1,0));
        //Maybe we need to check two or greater search history statement?
    }

    @Test
    public void checkQuickSearchMenu(){
        String textSearch1 = "xiaomi";
        Assert.assertTrue(searchBox.checkQuickSearchResult(textSearch1,driver));
        //Maybe we need to check goods and items with different methods?
    }
}
