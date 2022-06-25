package stepDefinitions;

import actionPerformer.AppSpecificActions;
import extentReport.ExtentReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepMethodDecorators.AddProductToCartDecorator;


public class AddProductToCart {

    @Before
    public void beforeTest() {
        AppSpecificActions.lunchApp();
    }

    @Given("^Mike on home page after opening nopCart mobile app$")
    public void mike_on_home_page_after_opening_nop_cart_mobile_app() {
        AddProductToCartDecorator.userOnHomePage();
        ExtentReport.startTest("Mike on home page", "Mike on home page after opening nopCart mobile app");
    }


    @When("Mike click {string} from our categories list from home page")
    public void mike_click_from_our_categories_list_from_home_page(String string) {
        AddProductToCartDecorator.selectCategoryFromHomePage(string);
        ExtentReport.startTest("Mike click on category", "Mike click on electric category");
    }


    @And("Mike click to {string} product details page")
    public void mike_click_to_product_details_page(String string) {
        AddProductToCartDecorator.selectProductForDetails(string);
    }

    @Then("Mike select size {string} from product details page")
    public void mike_select_size_from_product_details_page(String string) {
        AddProductToCartDecorator.selectProductSize(string);
    }

    @And("Mike click plus button to increase Qty by {string}")
    public void mike_click_plus_button_to_increase_qty_by(String string) {
        AddProductToCartDecorator.selectProductQuantityBy(string);
    }

    @Then("Mike click add to cart button to add the product in his cart")
    public void mike_click_add_to_cart_button_to_add_the_product_in_his_cart() {
        AddProductToCartDecorator.pressAddToCartButton();
    }

}
