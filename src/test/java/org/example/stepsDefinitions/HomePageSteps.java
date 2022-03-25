package org.example.stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.CommonActions;
import org.example.pageObjects.HomePage;
import org.example.pageObjects.SearchResultPage;
import org.testng.Assert;

public class HomePageSteps {

    CommonActions commonActions;
    HomePage homePage;
    SearchResultPage searchResultPage;

    public HomePageSteps(CommonActions commonActions, HomePage homePage, SearchResultPage searchResultPage) {
        this.commonActions = commonActions;
        this.homePage = homePage;
        this.searchResultPage = searchResultPage;
    }

    @Given("I am on Ebay homepage")
    public void iAmOnEbayHomepage() {
        commonActions.GoToUrl("https://www.ebay.com/");
    }

    @When("I click on Advanced link")
    public void iClickOnAdvancedLink() {
        homePage.clickAdvancedLink();
    }

    @Then("I navigate to Advanced Search page")
    public void iNavigateToAdvancedSearchPage() {
        String expectedUrl = "https://www.ebay.com/sch/ebayadvsearch";
        String actualUrl = commonActions.getCurrentPageUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "Page does not navigate to advanced search page");
    }

    @When("I search for {string}")
    public void iSearchFor(String product) {
        homePage.searchAnItem(product);
        homePage.searchButton.click();
    }

    @Then("I validate at least {int} search items present")
    public void iValidateAtLeastSearchItemsPresent(int count) {
        int itemCountInt = searchResultPage.getSearchItemCount();
        Assert.assertTrue(itemCountInt > count, "Less results shown");
    }

    @When("I search for {string} in {string} category")
    public void iSearchForInCategory(String product, String category) {
        homePage.searchAnItem(product);
        homePage.selectCategory(category);
        homePage.clickSearchButton();
    }

    @When("I click on {string}")
    public void iClickOnLink(String link) {
        homePage.clickOnLinkByText(link);
    }

    @Then("I validate that the page navigates to {string} and title contains {string}")
    public void iValidateThatThePageNavigatesToUrlAndTitleContainsTitle(String url, String title) {
        String actUrl = commonActions.getCurrentPageUrl();
        String actTitle = commonActions.getCurrentPageTitle();
        Assert.assertEquals(url, actUrl, "Page does not navigate to " + url);
        Assert.assertTrue(actTitle.contains(title), "Title mismatch");
    }
}
