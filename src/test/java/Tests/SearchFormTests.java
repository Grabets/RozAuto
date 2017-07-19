package Tests;

import Core.CreateObjectsFromFile;
import Core.ReadFromFile;
import UI.HomePage;
import UI.ResultsPage;
import UI.SearchBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by bogdan on 6/15/2017.
 */
public class SearchFormTests extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    SearchBox searchBox;
    ResultsPage resultsPage;

    @BeforeMethod
    public void beforeTest(){
        this.driver = super.getDriver();
        this.homePage = HomePage.init(driver);
        this.searchBox = homePage.getSearchBox();
        this.resultsPage = PageFactory.initElements(driver, ResultsPage.class);
    }

    @DataProvider(name = "CategoryList")
    public static Object[][] credentials() {

        return new Object[][] { { "Программное обеспечение", "Программное обеспечение" }, { "Телефоны, MP3, GPS", "Телефоны, MP3, GPS" },
                {"Дом, сад, огород, оборудование","Дом, сад, огород, оборудование"}, {"Компьютеры и ноутбуки","Компьютеры и ноутбуки"}};
    }

    @Test(dataProvider = "CategoryList")
     public void choosingCategoryTest(String chosingName, String choosedName) {
        searchBox.chooseCategory(chosingName);
        Assert.assertEquals(searchBox.getCategory(),choosedName);
    }

    @DataProvider(name = "ValueFromFile")
    public static Object[][] valueFromFile() {
        String filePathName = "src\\main\\resources\\data.txt";
        return CreateObjectsFromFile.createObjectFromFile(filePathName);
    }

    @Test(dataProvider = "ValueFromFile")
    public void choosingCategoryFromFileTest(String chosingName, String choosedName) {
        searchBox.chooseCategory(chosingName);
        Assert.assertEquals(searchBox.getCategory(),choosedName);
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
