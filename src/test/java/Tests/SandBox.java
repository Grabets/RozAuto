package Tests;

import UI.HomePage;
import UI.SearchBox;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by bogdan on 6/8/2017.
 */
public class SandBox extends BaseTest {

    @Test
    public void SandBoxTest(){
        WebDriver driver = super.getDriver();
        HomePage homePage = HomePage.init(driver);
    }

    @Test
    public void SearchBoxTest() {
        WebDriver driver = super.getDriver();
        HomePage homePage = HomePage.init(driver);
        SearchBox searchBox = homePage.getSearchBox();
        //searchBox.setSearchForm("алезан");
        searchBox.chooseCategory("Компьютеры и ноутбуки");
        //searchBox.clickSearchButton();
    }

}
