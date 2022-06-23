package pages;

import static actionPerformer.ObjectVisibility.visibilityAssert;
import static utilities.SpecificItemSelector.dynamicScrollToElement;

public class ProductListPage {

    public static void selectProductForDetails(String productName){
        try {
            visibilityAssert("UiElectronicProducts", "DEFAULT", null);
            dynamicScrollToElement("UiSpecificCategoriesList", null, productName);
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
