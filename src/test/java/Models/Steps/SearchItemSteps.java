package Models.Steps;

import Models.PageSteps.HomePageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by bogdan on 7/29/2017.
 */
public class SearchItemSteps {
    @Steps
    HomePageSteps homePage;

    @Given("the user is on the rozetka home page")
    public void givenTheUserIsOnTheRozetkaHomePage() {
        homePage.isOpened();
    }

    @When("the user looks up the item '$word'")
    public void whenTheUserSearchForItem (String word){
        homePage.search(word);
    }

    @Then("they should see search result page with correct items title '$word'")
    public void thenTheUserShouldObserveResultOfTheSearch(String word){
        homePage.checkResultPage(word);
    }

}
