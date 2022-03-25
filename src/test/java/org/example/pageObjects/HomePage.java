package org.example.pageObjects;

import org.example.stepsDefinitions.CommonSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(linkText = "Advanced")
    public WebElement advancedLink;

    @FindBy(xpath = "//input[@id='gh-ac']")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@id='gh-btn']")
    public WebElement searchButton;

    @FindBy(css = "h1.srp-controls__count-heading>span.BOLD:first-child")
    public WebElement resultsCount;

    @FindBy(xpath = "//select[@id='gh-cat']/option")
    public List<WebElement> categoryOptions;

    public HomePage(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickAdvancedLink() {
        advancedLink.click();
    }

    public void searchAnItem(String productName) {
        searchBox.sendKeys(productName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void selectCategory(String categoryName) {
        for (WebElement element : categoryOptions) {
            if (element.getText().equals(categoryName)) {
                element.click();
                break;
            }
        }
    }

    public void clickOnLinkByText(String link) {
        driver.findElement(By.linkText(link)).click();
    }
}
