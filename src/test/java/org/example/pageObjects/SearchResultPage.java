package org.example.pageObjects;

import org.example.stepsDefinitions.CommonSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {

    private WebDriver driver;

    @FindBy(css = "h1.srp-controls__count-heading>span.BOLD:first-child")
    public WebElement resultsCount;

    @FindBy(xpath = "(//a[@class='vip'])")
    public List<WebElement> itemsTitles;

    public SearchResultPage(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
        PageFactory.initElements(driver, this);
    }

    public int getSearchItemCount() {
        String itemCount = resultsCount.getText().replace(",", "");
        return Integer.parseInt(itemCount);
    }

    public boolean isExcludedWordInResults(String exWord) {
        for (WebElement title : itemsTitles) {
            if (title.getText().equalsIgnoreCase(exWord)) {
                return true;
            }
        } return false;
    }
}
