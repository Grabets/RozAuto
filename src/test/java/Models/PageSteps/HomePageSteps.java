package Models.PageSteps;

import UI.HomePage;
import UI.ResultsPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.testng.Assert;

/**
 * Created by bogdan on 7/29/2017.
 */
@DefaultUrl("https://rozetka.com.ua/")
public class HomePageSteps {
    HomePage homePage;
    ResultsPage resultsPage;

    @Step
    public void isOpened(){
        homePage.open();
    }

    @Step
    public void search(String text){
        resultsPage = homePage.search(text);
    }

    @Step
    public void checkResultPage(String text){
        Assert.assertEquals(text, resultsPage.getTextTitle());
    }




}
