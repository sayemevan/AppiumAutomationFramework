package pages;

import tools.ObjectVisibility;
import tools.Scroller;

public class ProductListPage {

    public static void selectProductForDetails(String productName){
        try {
            ObjectVisibility.assertVisibility("UiElectronicProducts", "DEFAULT", null);
            Scroller.dynamicScrollToElementAndClick("UiSpecificCategoriesList", null, productName, 10);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
