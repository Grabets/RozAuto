package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by bogdan on 6/8/2017.
 */
public class HomePage {

    @FindBy(how = How.NAME, using = "rz-header-search")
    private SearchBox searchBox;

    public static HomePage init(WebDriver driver){
        HomePage homePage = new HomePage();
        PageFactory.initElements(driver, homePage);
        driver.manage().window().maximize();
        driver.navigate().to("http://rozetka.com.ua");
        return new HomePage();
    }

    public SearchBox getSearchBox() {
        return searchBox;
    }
}
