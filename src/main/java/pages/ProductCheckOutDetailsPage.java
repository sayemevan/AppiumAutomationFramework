package pages;

import tools.ObjectActions;
import tools.ObjectValues;
import tools.ObjectVisibility;
import tools.Scroller;
import utilities.PropertyUtils;


public class ProductCheckOutDetailsPage {

    public static void clickCheckoutButton(){
        try {
            ObjectActions.set("UiCheckOutBtn", "LCLICK", null, null);
            ObjectVisibility.assertInVisibility("UiCheckOutBtn","DEFAULT", null);
        } catch (Exception e){
            System.out.println("Clicking to check button is failed!");
            e.printStackTrace();
        }
    }

    public static void clickCheckoutAsGuest(){
        try {
            ObjectActions.set("UiCheckOutAsGuestBtn", "LCLICK", null, null);
            ObjectVisibility.assertInVisibility("UiCheckOutAsGuestBtn","DEFAULT", null);
        } catch (Exception e){
            System.out.println("Clicking to check out as guest is failed!");
            e.printStackTrace();
        }
    }

    public static void inputDetailsAndContinue(){
        try {
            ObjectVisibility.assertVisibility("UiFirstName", "DEFAULT", null);
            ObjectActions.setGroupAction("CustomerDetails", null);
            clickContinueButton();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //Provide any one value for this method and another one should be null.
    public static void selectShippingMethodAndContinue(String shippingMethodName, String UiObjectName){
        try {
            if(shippingMethodName != null){
                String objectsPropertyValue = PropertyUtils.getValue("UiShippingMethod");
                objectsPropertyValue = "XPATH~" + objectsPropertyValue.split("~")[1] + shippingMethodName + objectsPropertyValue.split("~")[2] + "[1]~LISTVIEW";
                PropertyUtils.addOrReplaceValue("UiShippingMethod", objectsPropertyValue);
                Scroller.scrollToElementAndClick("UiShippingMethod", null, 20);
            } else {
                Scroller.scrollToElementAndClick(UiObjectName, null, 20);
            }
            Scroller.scrollDown(2);
            clickContinueButton();
        } catch (Exception e){
            System.out.println("Selecting shipping method is failed!");
            e.printStackTrace();
        }
    }

    //Provide any one value for this method and another one should be null.
    public static void selectPaymentMethodAndContinue(String paymentMethodName, String UiObjectName){
        try {
            if(paymentMethodName != null){
                String objectsPropertyValue = PropertyUtils.getValue("UiPaymentMethod");
                objectsPropertyValue = "XPATH~"+objectsPropertyValue.split("~")[1] + paymentMethodName + objectsPropertyValue.split("~")[2] + "[1]~LISTVIEW";
                PropertyUtils.addOrReplaceValue("UiPaymentMethod", objectsPropertyValue);
                Scroller.scrollToElementAndClick("UiPaymentMethod", null, 30);
            } else {
                Scroller.scrollToElementAndClick(UiObjectName, null, 30);
            }
            Scroller.scrollDown(2);
            clickContinueButton();
        } catch (Exception e){
            System.out.println("Selecting payment method is failed!");
            e.printStackTrace();
        }
    }

    public static void clickNextButton(){
        try {
            ObjectActions.set("UiNextBtn", "DEFAULT", null, null);
            ObjectVisibility.assertInVisibility("UiNextBtn","DEFAULT", null);
        } catch (Exception e){
            System.out.println("Clicking to next button is failed!");
            e.printStackTrace();
        }
    }

    public static void clickConfirmButton(){
        try {
            ObjectActions.set("UiConfirmBtn", "DEFAULT", null, null);
            ObjectVisibility.assertInVisibility("UiNextBtn","DEFAULT", null);
        } catch (Exception e){
            System.out.println("Clicking to confirm button is failed!");
            e.printStackTrace();
        }
    }

    public static String getOrderSuccessPopUpMessage(){
        try {
            return ObjectValues.get("UiSuccessMessage", "DEFAULT", null);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void clickOrderSuccessContinueButton(){
        try {
            ObjectActions.set("UiContinuePositive", "DEFAULT", null, null);
            ObjectVisibility.assertInVisibility("UiContinuePositive","DEFAULT", null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void clickContinueButton(){
        try {
            Scroller.scrollToElementAndClick("UiContinue", null, 0);
            Thread.sleep(1000);
        } catch (Exception e){
            System.out.println("Clicking to continue button is failed!");
            e.printStackTrace();
        }
    }

}
