package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import register.Driver;
import tools.AppSpecificActions;

public class BaseTest {
    @BeforeAll
    public static void before_all() {
        AppSpecificActions.lunchApp();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
    }

    @AfterAll
    public static void after_all() {
        AppSpecificActions.closeApp();
    }
}
