package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bogdan on 6/13/2017.
 */
public class SearchBox extends {

    @FindBy(how = How.CSS, using = ".rz-header-search-input-text")
    WebElement searchForm;
    @FindBy(how = How.CSS, using = ".btn-link-i")
    WebElement searchButton;
    @FindBy(how = How.NAME, using = "rz-search-category")
    WebElement searchCategory;

    /*public static SearchBox init(WebDriver driver){
        return new SearchBox(driver);
    }*/

    public void setSearchForm(String textToSet){
        searchForm.sendKeys(textToSet);
    }

    public void clearSearchForm (){
        searchForm.clear();
    }

    public void clickSearchButton() {
        searchButton.submit();
    }

    private String getSearchCategory(){
        return new String("123");
    }

    public void chooseCategory(String category){
        searchCategory.click();
        for (int i = 1; i < 10; i++) {
            searchCategory.findElement(By.xpath("//*[@id=\"rz-search\"]/form/div[1]/div[1]/ul/li["+i+"]")).click();
            searchCategory.click();
        }


    }

}
