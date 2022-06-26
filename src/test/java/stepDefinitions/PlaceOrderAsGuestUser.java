package stepDefinitions;

import tools.AppSpecificActions;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepMethodDecorators.PlaceOrderAsGuestUserDecorator;

public class PlaceOrderAsGuestUser {

    @Given("^Mike go to shopping cart by clicking top cart icon$")
    public void mike_go_to_shopping_cart_by_clicking_top_cart_icon() {
        PlaceOrderAsGuestUserDecorator.goToShoppingCart();
    }
    @When("Mike click checkout button from shopping cart page")
    public void mike_click_checkout_button_from_shopping_cart_page() {
        PlaceOrderAsGuestUserDecorator.clickCheckoutButton();
    }
    @And("Mike select checkout as guest from shopping cart page")
    public void mike_select_checkout_as_guest_from_shopping_cart_page() {
        PlaceOrderAsGuestUserDecorator.clickCheckoutAsGuest();
    }
    @Then("Mike input all the details in checkout billing details page and click continue")
    public void mike_input_all_the_details_in_checkout_billing_details_page_and_click_continue() {
        PlaceOrderAsGuestUserDecorator.inputDetailsAndContinue();
    }
    @And("Mike select {string} as shipping method and click continue")
    public void mike_select_shipping_method_and_click_continue(String string) {
        PlaceOrderAsGuestUserDecorator.selectShippingMethodAndContinue(string);
    }
    @And("Mike select {string} as payment method and click continue")
    public void mike_select_payment_method_and_click_continue(String string) {
        PlaceOrderAsGuestUserDecorator.selectPaymentMethodAndContinue(string);
    }
    @And("Mike click next button on payment information page")
    public void mike_click_next_button_on_payment_information_page() {
        PlaceOrderAsGuestUserDecorator.clickNextButton();
    }
    @Then("Mike click confirm button to place the order")
    public void mike_click_confirm_button_to_place_the_order() {
        PlaceOrderAsGuestUserDecorator.clickConfirmButton();
    }

    @And("Verify order place successfully with popup message {string}")
    public void verify_order_place_successfully_with_popup_message(String string) {
        PlaceOrderAsGuestUserDecorator.verifyPopUpMessage(string);
    }

    @AfterAll
    public static void after_all() {
        AppSpecificActions.closeApp();
    }
}
