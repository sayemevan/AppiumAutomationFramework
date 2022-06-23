package pages;

import static actionPerformer.ObjectSpecificActions.actionSet;
import static actionPerformer.ObjectSpecificActions.groupDatActionSetFromExcel;
import static actionPerformer.ObjectSpecificValues.valueGet;
import static actionPerformer.ObjectVisibility.visibilityAssert;
import static utilities.ObjectRepositoryActions.addOrReplaceRepoValue;
import static utilities.ObjectRepositoryActions.getRepoValue;
import static utilities.SpecificItemSelector.*;
import static utilities.SpecificItemSelector.scrollDown;

public class ProductCheckOutDetailsPage {

    public static void clickCheckoutButton(){
        try {
            actionSet("UiCheckOutBtn", "LCLICK", null, null);
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void clickCheckoutAsGuest(){
        try {
            actionSet("UiCheckOutAsGuestBtn", "LCLICK", null, null);
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void inputDetailsAndContinue(){
        try {
            visibilityAssert("UiFirstName", "DEFAULT", null);
            groupDatActionSetFromExcel("CustomerDetails", null);
            Thread.sleep(500);
            clickContinueButton();
            Thread.sleep(3000);
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
                Thread.sleep(3000);
                scrollToElement("UiShippingMethod", null);
            } else {
                scrollToElement("UiNextDayAir", null);
//                actionSet("UiNextDayAir", "DEFAULT", null, null);
            }
            Thread.sleep(500);
            scrollDown();
            scrollDown();
            clickContinueButton();
//            scrollToElement("UiContinueWithShipping", null);
            Thread.sleep(3000);
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
                Thread.sleep(3000);
                scrollToElement("UiPaymentMethod", null);
            } else {
                scrollToElement("UiCheckMoneyOrder", null);
//                actionSet("UiCheckMoneyOrder", "DEFAULT", null, null);
            }
            Thread.sleep(500);
            scrollDown();
            scrollDown();
            clickContinueButton();
//            scrollToElement("UiContinueWithShipping", null);
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void clickNextButton(){
        try {
            actionSet("UiNextBtn", "DEFAULT", null, null);
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void clickConfirmButton(){
        try {
            actionSet("UiConfirmBtn", "DEFAULT", null, null);
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getOrderSuccessPopUpMessage(){
        try {
            Thread.sleep(1000);
            return valueGet("UiSuccessMessage", "DEFAULT", null);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void clickOrderSuccessContinueButton(){
        try {
            actionSet("UiContinuePositive", "DEFAULT", null, null);
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void clickContinueButton(){
        try {
            scrollToElement("UiContinue", null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
