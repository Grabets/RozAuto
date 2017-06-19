package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by bogdan on 6/13/2017.
 */
public class SearchBox{

    @FindBy(how = How.NAME, using = "rz-search-form")
    WebElement searchForm;
    @FindBy(how = How.CSS, using = ".rz-header-search-input-text")
    WebElement searchInput;
    @FindBy(how = How.CSS, using = ".btn-link-i")
    WebElement searchButton;
    @FindBy(how = How.NAME, using = "rz-search-category")
    WebElement searchCategory;

    public void setSearchForm(String textToSet){
        searchInput.sendKeys(textToSet);
    }

    public void clickSearchButton() {
        searchButton.submit();
    }

    public void setAndSubmitSearchForm(String textToSet){
        setSearchForm(textToSet);
        clickSearchButton();
    }

    public String getSearchFormText(){
        return searchInput.getAttribute("value");
    }

    public void clearSearchForm (){
        searchInput.clear();
    }

    public String getCategory(){
        String xPathExpression = "//div[@class = 'rz-header-search-category']//span";
        WebElement chosenCategory = searchCategory.findElement(By.xpath(xPathExpression));
        return chosenCategory.getText();
    }

    public void chooseCategory(String category){
        String xPathExpression = "//ul[@name='rz-search-category-list']//a[contains(text(),'"+category+"')]";
        searchCategory.click();
        searchCategory.findElement(By.xpath(xPathExpression)).click();
    }

    public void searchInputClick(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(searchInput).click().build().perform();
    }

    public Boolean checkSearchHistory (String text, int num){
        String xPathExpression = "//div[@class = 'rz-header-search-suggest']//div[@name='"+num+"']/a";
        WebElement searchHistoryElement = searchForm.findElement(By.xpath(xPathExpression));
        return searchHistoryElement.getText().equals(text) ? true : false;
    }

    public boolean checkQuickSearchResult(String textToSet, WebDriver driver){
        String xParhExpressionforGoods = "//div[@data-rz-gtm-event='goodsTitleClick'][1]//div[@class='rz-header-search-suggest-i-title']/a";
        String xParhExpressionforItem = "//div[@class='rz-header-search-suggest']//div[@data-rz-gtm-event='suggestedQuery'][1]//span[1]";
        setSearchForm(textToSet);
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try{
            WebElement quickSearchWebElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xParhExpressionforGoods)));
            return quickSearchWebElement.getText().toLowerCase().contains(textToSet) ? true : false;
        }
        catch (Exception e){
            System.out.println("try to find goods in quick search bar");
        }
        try{
            WebElement quickSearchWebElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xParhExpressionforItem)));
            return quickSearchWebElement.getText().toLowerCase().contains(textToSet) ? true : false;
        }
        catch (Exception e){
            System.out.println("try to find Item in quick search bar");
        }

        return false;
    }

}
