package org.example.pageObjects;

import org.example.stepsDefinitions.CommonSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@_sp='m570.l2586']")
    public WebElement eBayLogo;

    @FindBy(xpath = "//input[@id='_nkw']")
    public WebElement searchKeywordField;

    @FindBy(xpath = "//input[@id='_ex_kw']")
    public WebElement excludeWordsField;

    @FindBy(xpath = "//input[@name='_udhi']")
    public WebElement minPriceField;

    @FindBy(xpath = "//input[@name='_udlo']")
    public WebElement maxPriceField;

    @FindBy(id = "searchBtnLowerLnk")
    public WebElement searchButton;

    public AdvancedSearchPage(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickOnEbayLogo() {
        eBayLogo.click();
    }

    public void enterSearchName(String productName) {
        searchKeywordField.sendKeys(productName);
    }

    public void enterExcludedWord(String excludedWord) {
        excludeWordsField.sendKeys(excludedWord);
    }

    public void enterMinPrice(String minPrice) {
        minPriceField.sendKeys(minPrice);
    }

    public void enterMaxPrice(String maxPrice) {
        maxPriceField.sendKeys(maxPrice);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }
}
