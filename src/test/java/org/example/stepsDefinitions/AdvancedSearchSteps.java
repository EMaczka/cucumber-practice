package org.example.stepsDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.AdvancedSearchPage;
import org.example.pageObjects.CommonActions;
import org.example.pageObjects.SearchResultPage;
import org.testng.Assert;

public class AdvancedSearchSteps {

    CommonActions commonActions;
    AdvancedSearchPage advancedSearchPage;
    SearchResultPage searchResultPage;

    public AdvancedSearchSteps(CommonActions commonActions, AdvancedSearchPage advancedSearchPage, SearchResultPage searchResultPage) {
        this.commonActions = commonActions;
        this.advancedSearchPage = advancedSearchPage;
        this.searchResultPage = searchResultPage;
    }

    @Given("I am on Ebay Advanced Search page")
    public void iAmOnEbayAdvancedSearchPage() {
        commonActions.GoToUrl("https://www.ebay.com/sch/ebayadvsearch");
    }

    @When("I click on Ebay logo")
    public void iClickOnEbayLogo() {
        advancedSearchPage.clickOnEbayLogo();
    }

    @Then("I am navigate to homepage")
    public void iAmNavigateToHomepage() {
        String expectedUrl = "https://www.ebay.com/";
        String actualUrl = commonActions.getCurrentPageUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "Page does not navigate to homepage");
    }

    @When("I advanced search an item")
    public void iAdvancedSearchAnItem(DataTable dataTable) {
        advancedSearchPage.enterSearchName(dataTable.cell(1, 0));
        advancedSearchPage.enterExcludedWord(dataTable.cell(1, 1));
        advancedSearchPage.enterMinPrice(dataTable.cell(1, 2));
        advancedSearchPage.enterMaxPrice(dataTable.cell(1, 3));
        advancedSearchPage.clickOnSearchButton();
    }

    @Then("I validate that the result titles do not contain {string}")
    public void iValidateThatTheResultTitlesDoNotContainRefurbished(String excludedWord) {
        Assert.assertFalse(searchResultPage.isExcludedWordInResults(excludedWord)
                , "Excluded word appears in search results");
    }
}