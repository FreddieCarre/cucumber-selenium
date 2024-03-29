package com.trunarrative.techtest.glue;

import com.trunarrative.techtest.pages.Homepage;
import com.trunarrative.techtest.pages.LeadershipPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TruNarrativeStepDefs {

    private Homepage homepage;
    private LeadershipPage leadershipPage;

    @Given("^I am on the TruNarrative homepage$")
    public void iAmOnTheTruNarrativeHomepage() {
        homepage = Homepage.isOpen();
        Assert.assertEquals(homepage.getTitle(), System.getProperty("homeTitle"));
        Assert.assertEquals(homepage.straplineIsDisplayed(), System.getProperty("straplineText"));
    }

    @When("^I click \"([^\"]*)\" from the \"([^\"]*)\" menu$")
    public void iClickFromTheMenu(String option, String menu) {
        homepage.clickMenu(menu);
        leadershipPage = homepage.clickOption(option, LeadershipPage.class);
    }

    @Then("^The leadership team is displayed$")
    public void theLeadershipTeamIsDisplayed() {
        Assert.assertEquals(leadershipPage.getNumberOfMembers(), 9);
        Assert.assertEquals(leadershipPage.getRoleForName("John Lord"), "Founder & CEO");
        Assert.assertEquals(leadershipPage.getRoleForName("David Eastaugh"), "Chief Technology Officer");
        Assert.assertEquals(leadershipPage.getRoleForName("Nicola Janney"), "Human Resources Manager");
    }
}
