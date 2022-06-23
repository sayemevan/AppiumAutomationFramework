package pages;

import static actionPerformer.ObjectSpecificActions.actionSet;
import static actionPerformer.ObjectVisibility.visibilityAssert;
import static utilities.SpecificItemSelector.scrollUntilElementVisible;

public class ProductDetailPage {

    public static void selectProductSize(String productSize){
        try {
            visibilityAssert("UiNokiaLumia", "DEFAULT", null);
            scrollUntilElementVisible("UiSize", null);
            actionSet("UiSize", "LCLICK", null, null);
            Thread.sleep(500);
            if(productSize.trim().equals("Large")) {
                actionSet("UiLarge", "LCLICK", null, null);
            } else if (productSize.trim().equals("Small")){
                actionSet("UiSmall", "LCLICK", null, null);
            }
            actionSet("UiDone", "LCLICK", null, null);
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectProductQuantityBy(String size){
        try {
            visibilityAssert("UiPlusIconBtn", "DEFAULT", null);
            int i = 0;
            while (i < Integer.parseInt(size)) {
                actionSet("UiPlusIconBtn", "LCLICK", null, null);
                i++;
            }
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void selectProductQuantityTo(String size){
        try {

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void pressAddToCartButton(){
        try {
            visibilityAssert("UiAddToCart", "DEFAULT", null);
            actionSet("UiAddToCart", "LCLICK", null, null);
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void goToShoppingCart(){
        try {
            actionSet("UiCartIconBtn", "LCLICK", null, null);
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
