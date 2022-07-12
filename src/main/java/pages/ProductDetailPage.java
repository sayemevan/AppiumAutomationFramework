package pages;

import tools.ObjectActions;
import tools.ObjectVisibility;
import tools.Scroller;

public class ProductDetailPage {

    public static void selectProductSize(String productSize){
        try {
            ObjectVisibility.assertVisibility("UiNokiaLumia", "DEFAULT", null);
            Scroller.scrollUntilElementVisible("UiSize", null, 10);
            ObjectActions.set("UiSize", "LCLICK", null, null);
            if(productSize.trim().equals("Large")) {
                ObjectActions.set("UiLarge", "LCLICK", null, null);
            } else if (productSize.trim().equals("Small")){
                ObjectActions.set("UiSmall", "LCLICK", null, null);
            }
            ObjectActions.set("UiDone", "LCLICK", null, null);
            ObjectVisibility.assertInVisibility("UiLarge","DEFAULT", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectProductQuantityBy(String size){
        try {
            ObjectVisibility.assertVisibility("UiPlusIconBtn", "DEFAULT", null);
            int i = 0;
            while (i < Integer.parseInt(size)) {
                ObjectActions.set("UiPlusIconBtn", "LCLICK", null, null);
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
            ObjectActions.set("UiAddToCart", "LCLICK", null, null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void goToShoppingCart(){
        try {
            ObjectActions.set("UiCartIconBtn", "LCLICK", null, null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
