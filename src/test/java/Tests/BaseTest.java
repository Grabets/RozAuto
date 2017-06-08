package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

/**
 * Created by bogdan on 6/8/2017.
 */
public class BaseTest {
    private WebDriver driver;

    @BeforeClass
    public void webDriverSetup(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @AfterTest
    public void closeDriver(){
        getDriver().close();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
