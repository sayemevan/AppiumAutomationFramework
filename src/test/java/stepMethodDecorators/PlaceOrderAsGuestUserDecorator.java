package stepMethodDecorators;

import org.junit.Assert;
import pages.ProductCheckOutDetailsPage;
import pages.ProductDetailPage;

public class PlaceOrderAsGuestUserDecorator {

    public static void goToShoppingCart(){
        ProductDetailPage.goToShoppingCart();
    }

    public static void clickCheckoutButton(){
        ProductCheckOutDetailsPage.clickCheckoutButton();
    }

    public static void clickCheckoutAsGuest(){
        ProductCheckOutDetailsPage.clickCheckoutAsGuest();
    }

    public static void inputDetailsAndContinue(){
        ProductCheckOutDetailsPage.inputDetailsAndContinue();
    }

    public static void selectShippingMethodAndContinue(String shippingMethodName){
        ProductCheckOutDetailsPage.selectShippingMethodAndContinue(shippingMethodName);
    }

    public static void selectPaymentMethodAndContinue(String paymentMethodName){
        ProductCheckOutDetailsPage.selectPaymentMethodAndContinue(paymentMethodName);
    }

    public static void clickNextButton(){
        ProductCheckOutDetailsPage.clickNextButton();
    }

    public static void clickConfirmButton(){
        ProductCheckOutDetailsPage.clickConfirmButton();
    }

    public static boolean verifyPopUpMessage(String expectedMessage) {
        String actualMsg = ProductCheckOutDetailsPage.getOrderSuccessPopUpMessage();
        System.out.println("Actual Success Msg: " + actualMsg);
        ProductCheckOutDetailsPage.clickOrderSuccessContinueButton();
        if (actualMsg.equals(expectedMessage) || actualMsg.trim().startsWith(expectedMessage)) {
            return true;
        } else {
            return false;
        }
    }
}
