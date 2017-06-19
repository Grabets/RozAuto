package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by bogdan on 6/15/2017.
 */
public class ResultsPage {
    private String url;
    WebDriver driver;

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public ResultsPage (WebDriver driver){
        this.driver = driver;
    }

    public Boolean isOpened (){
        return driver.findElement(By.cssSelector(".rz-search-result-qnty")).isDisplayed();
    }
}
