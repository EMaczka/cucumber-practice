package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:report"}
        , features = {"features"}
        , glue = {"org/example/stepsDefinitions"}
        , dryRun = false                       //when set to true, it will skip scenarios with implemented step definitions
        , monochrome = true                     //cleaner output format (no exec time)
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
