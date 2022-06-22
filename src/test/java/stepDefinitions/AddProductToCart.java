package stepDefinitions;

import actionPerformer.AppSpecificActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import register.DataProvider;
import uiObjects.TextBox;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DatabaseMetaData;
import java.util.concurrent.TimeUnit;

import static actionPerformer.ObjectSpecificActions.*;
import static actionPerformer.ObjectVisibility.*;
import static register.DataProvider.*;
import static utilities.SpecificItemSelector.*;

public class AddProductToCart {

    @Given("^Mike on home page after opening nopCart mobile app$")
    public void mike_on_home_page_after_opening_nop_cart_mobile_app() throws InterruptedException {
        AppSpecificActions.lunchApp();
        actionSet("UiReadAndAccept", "LCLICK", null, null);
        Thread.sleep(3000);
    }
    @When("Mike click {string} from our categories list from home page")
    public void mike_click_from_our_categories_list_from_home_page(String string) throws InterruptedException {
        visibilityAssert("UiOurCategories", "DEFAULT", null);
        scrollToElement("UiSpecificCategoriesList", "UiAllCategoriesList", string, false);
        Thread.sleep(3000);
    }
    @When("Mike click to {string} product details page")
    public void mike_click_to_product_details_page(String string) throws InterruptedException {
        visibilityAssert("UiElectronicProducts", "DEFAULT", null);
        scrollToElement("UiSpecificCategoriesList", null, string, false);
        Thread.sleep(3000);
    }
    @Then("Mike select size {string} from product details page")
    public void mike_select_size_from_product_details_page(String string) throws InterruptedException {
        visibilityAssert("UiNokiaLumia", "DEFAULT", null);
        scrollToElement("UiSize", null, null, true);
        actionSet("UiSize", "LCLICK", null, null);
        Thread.sleep(500);
        actionSet("UiLarge", "LCLICK", null, null);
        actionSet("UiDone", "LCLICK", null, null);
        Thread.sleep(3000);
    }
    @Then("Mike click plus button to increase Qty by {string}")
    public void mike_click_plus_button_to_increase_qty_by(String string) throws InterruptedException {
        visibilityAssert("UiPlusIconBtn", "DEFAULT", null);
        actionSet("UiPlusIconBtn", "LCLICK", null, null);
        Thread.sleep(3000);
    }
    @Then("Mike click add to cart button to add the product in his cart")
    public void mike_click_add_to_cart_button_to_add_the_product_in_his_cart() throws InterruptedException {
        visibilityAssert("UiAddToCart", "DEFAULT", null);
        actionSet("UiAddToCart", "LCLICK", null, null);
        Thread.sleep(3000);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
}
