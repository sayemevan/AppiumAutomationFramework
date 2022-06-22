package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/functionalTest", glue = {"stepDefinitions"},
        plugin = {"pretty", "junit:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-reports",
                "json:target/cucumber-reports/Cucumber.json"})
public class TestRunner {

}
