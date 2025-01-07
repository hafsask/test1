package step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static modules.Hooks.driver;
import static org.junit.Assert.assertTrue;
import static page_objects.GoogleSearchPage.Search;

public class MyStepdefs {

    @Given("I open google search page")
    public void iOpenGoogleSearchPage() {

        driver.get("https://google.com");
        driver.manage().window().maximize();
    }

    @When("I look up the word {string}")
    public void iLookUpTheWord(String arg0) {
        Search(arg0);
    }

    @Then("search results display the word {string}")
    public void searchResultsDisplayTheWord(String arg0) {
        assertTrue(driver.getTitle().contains(arg0));
    }


}