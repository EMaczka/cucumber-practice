package org.example.pageObjects;

import org.example.stepsDefinitions.CommonSteps;
import org.openqa.selenium.WebDriver;

public class CommonActions {

    private WebDriver driver;

    public CommonActions(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
    }

    public void GoToUrl(String url) {
        driver.get(url);
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }
}
