package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by bogdan on 6/8/2017.
 */
public class HomePage {

    @FindBy(how = How.CSS, using = ".rz-header-search-input-text")
    WebElement searchBox;
    private HomePage(WebDriver driver){
        driver.navigate().to("http://rozetka.com.ua");
    }

    public static HomePage open(WebDriver driver){
        return new HomePage(driver);
    }

    public void setSearchBox(String textToSet){
        searchBox.sendKeys(textToSet);
        searchBox.submit();
    }


}
