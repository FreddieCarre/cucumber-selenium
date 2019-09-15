package com.google.glue;

import com.google.pages.ResultsPage;
import com.google.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GoogleStepDefs {

    private SearchPage searchPage;
    private ResultsPage resultsPage;

    @Given("I am on the Google search page")
    public void onGoogleSearchPage() {
        searchPage = SearchPage.open();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void searchFor(String searchText) {
        resultsPage = searchPage.searchFor(searchText);
        Assert.assertEquals(resultsPage.getResultHref(0),
                System.getProperty(searchText + "Url"));
    }

    @And("^I click result number (\\d+)$")
    public void clickResult(int number) {
        resultsPage.clickResult(number);
    }
}
