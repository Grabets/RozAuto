package Tests;

import UI.HomePage;
import UI.SearchBox;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by bogdan on 6/15/2017.
 */
public class SearchFormTest extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    SearchBox searchBox;



    @BeforeMethod
    public void beforeTest(){
        this.driver = super.getDriver();
        this.homePage = HomePage.init(driver);
        this.searchBox = homePage.getSearchBox();
    }

    @Test
    public void submitTest(){
        searchBox.clickSearchButton();
    }

    @Test
    public void setSearchForm(){
        String text = "алезан";
        searchBox.setSearchForm(text);
    }

    @Test
    public void clearSearchForm(){
        searchBox.clearSearchForm();
    }

    @Test
    public void chooseCategory(){
        searchBox.chooseCategory("1");
    }

    @Test
    public void mainTest() throws InterruptedException{
        searchBox.setSearchForm("ads");
        Thread.sleep(1000);
        searchBox.clearSearchForm();
    }
}
