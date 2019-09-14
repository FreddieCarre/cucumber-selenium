package com.google.glue;

import com.google.pages.ResultsPage;
import com.google.pages.SearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
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
        Assert.assertEquals(resultsPage.getResultHref(0), "https://trunarrative.com/");
    }

    @And("^I click result number (\\d+)$")
    public void clickResult(int number) {
        resultsPage.clickResult(number);
    }
}
