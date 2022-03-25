package org.example.stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonSteps {

    public WebDriver getDriver() {
        return driver;
    }
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("99").setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}