package pages;

import static actionPerformer.ObjectSpecificActions.actionSet;
import static actionPerformer.ObjectVisibility.inVisibilityAssert;
import static actionPerformer.ObjectVisibility.visibilityAssert;
import static utilities.OnPageElementScroller.scrollUntilElementVisible;

public class ProductDetailPage {

    public static void selectProductSize(String productSize){
        try {
            visibilityAssert("UiNokiaLumia", "DEFAULT", null);
            scrollUntilElementVisible("UiSize", null, 10);
            actionSet("UiSize", "LCLICK", null, null);
            if(productSize.trim().equals("Large")) {
                actionSet("UiLarge", "LCLICK", null, null);
            } else if (productSize.trim().equals("Small")){
                actionSet("UiSmall", "LCLICK", null, null);
            }
            actionSet("UiDone", "LCLICK", null, null);
            inVisibilityAssert("UiLarge","DEFAULT", null);
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
            actionSet("UiAddToCart", "LCLICK", null, null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void goToShoppingCart(){
        try {
            actionSet("UiCartIconBtn", "LCLICK", null, null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
