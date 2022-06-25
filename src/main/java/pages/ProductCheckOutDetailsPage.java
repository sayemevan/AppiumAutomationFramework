package pages;

import static actionPerformer.ObjectSpecificActions.*;
import static actionPerformer.ObjectSpecificValues.valueGet;
import static actionPerformer.ObjectVisibility.*;
import static utilities.ObjectRepositoryActions.*;
import static utilities.OnPageElementScroller.*;

public class ProductCheckOutDetailsPage {

    public static void clickCheckoutButton(){
        try {
            actionSet("UiCheckOutBtn", "LCLICK", null, null);
            inVisibilityAssert("UiCheckOutBtn","DEFAULT", null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void clickCheckoutAsGuest(){
        try {
            actionSet("UiCheckOutAsGuestBtn", "LCLICK", null, null);
            inVisibilityAssert("UiCheckOutAsGuestBtn","DEFAULT", null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void inputDetailsAndContinue(){
        try {
            visibilityAssert("UiFirstName", "DEFAULT", null);
            groupDatActionSetFromExcel("CustomerDetails", null);
            clickContinueButton();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void selectShippingMethodAndContinue(String shippingMethodName){
        try {
            if(shippingMethodName != null){
                String objectsPropertyValue = getRepoValue("UiShippingMethod");
                objectsPropertyValue = "XPATH~"+objectsPropertyValue.split("~")[1] + shippingMethodName + objectsPropertyValue.split("~")[2] + "[1]~LISTVIEW";
                addOrReplaceRepoValue("UiShippingMethod", objectsPropertyValue);
                scrollToElementAndClick("UiShippingMethod", null, 20);
            } else {
                scrollToElementAndClick("UiNextDayAir", null, 20);
//                actionSet("UiNextDayAir", "DEFAULT", null, null);
            }
            scrollDown(2);
            clickContinueButton();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void selectPaymentMethodAndContinue(String paymentMethodName){
        try {
            if(paymentMethodName != null){
                String objectsPropertyValue = getRepoValue("UiPaymentMethod");
                objectsPropertyValue = "XPATH~"+objectsPropertyValue.split("~")[1] + paymentMethodName + objectsPropertyValue.split("~")[2] + "[1]~LISTVIEW";
                addOrReplaceRepoValue("UiPaymentMethod", objectsPropertyValue);
                scrollToElementAndClick("UiPaymentMethod", null, 30);
            } else {
                scrollToElementAndClick("UiCheckMoneyOrder", null, 30);
//                actionSet("UiCheckMoneyOrder", "DEFAULT", null, null);
            }
            scrollDown(2);
            clickContinueButton();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void clickNextButton(){
        try {
            actionSet("UiNextBtn", "DEFAULT", null, null);
            inVisibilityAssert("UiNextBtn","DEFAULT", null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void clickConfirmButton(){
        try {
            actionSet("UiConfirmBtn", "DEFAULT", null, null);
            inVisibilityAssert("UiNextBtn","DEFAULT", null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getOrderSuccessPopUpMessage(){
        try {
            return valueGet("UiSuccessMessage", "DEFAULT", null);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void clickOrderSuccessContinueButton(){
        try {
            actionSet("UiContinuePositive", "DEFAULT", null, null);
            inVisibilityAssert("UiContinuePositive","DEFAULT", null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void clickContinueButton(){
        try {
            scrollToElementAndClick("UiContinue", null, 0);
            Thread.sleep(1000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
