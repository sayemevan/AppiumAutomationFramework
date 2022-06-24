package pages;

import static actionPerformer.ObjectVisibility.*;
import static utilities.OnPageElementScroller.*;

public class ProductListPage {

    public static void selectProductForDetails(String productName){
        try {
            visibilityAssert("UiElectronicProducts", "DEFAULT", null);
            dynamicScrollToElementAndClick("UiSpecificCategoriesList", null, productName, 10);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
