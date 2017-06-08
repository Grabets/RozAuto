package Tests;

import UI.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by bogdan on 6/8/2017.
 */
public class SandBox extends BaseTest {

    @Test
    public void SandBoxTest(){
        WebDriver driver = super.getDriver();
        HomePage homePage = HomePage.open(driver);
        PageFactory.initElements(driver, homePage);
        homePage.setSearchBox("ADS");
    }


}
