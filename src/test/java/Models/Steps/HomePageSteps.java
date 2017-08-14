package Models.Steps;

import UI.HomePage;
import UI.ResultsPage;
import org.junit.Assert;

public class HomePageSteps {
    HomePage homePage;
    ResultsPage resultsPage;

    public void isOpened(){
        homePage = new HomePage().open();
    }

    public void search(String text){
        resultsPage = homePage.search(text);
    }

    public void checkResultPage(String text){
        Assert.assertEquals(text, resultsPage.getTextTitle());
    }

    public void close() {
        homePage.close();
    }
}
