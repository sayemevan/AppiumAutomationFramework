package pages;

import actionPerformer.AppSpecificActions;

import static actionPerformer.ObjectSpecificActions.*;
import static actionPerformer.ObjectVisibility.*;
import static utilities.OnPageElementScroller.*;

public class HomePage {

    public static void userOnHomePage(){
        try {
            AppSpecificActions.lunchApp();
            actionSet("UiReadAndAccept", "LCLICK", null, null);
            inVisibilityAssert("UiReadAndAccept","DEFAULT", null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void selectCategoryFromHomePage(String categoryName) {
        try {
            visibilityAssert("UiOurCategories", "DEFAULT", null);
            dynamicScrollToElementAndClick("UiSpecificCategoriesList", "UiAllCategoriesList", categoryName, 10);
            inVisibilityAssert("UiOurCategories","DEFAULT", null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
