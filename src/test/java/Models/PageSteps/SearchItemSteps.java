package Models.PageSteps;

import Models.Steps.HomePageSteps;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SearchItemSteps {

    HomePageSteps homePage = new HomePageSteps();;

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

    @AfterStory
    public void afterStory(){
        homePage.close();
    }
}
