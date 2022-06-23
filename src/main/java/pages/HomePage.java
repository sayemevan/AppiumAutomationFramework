package pages;

import actionPerformer.AppSpecificActions;

import static actionPerformer.ObjectSpecificActions.actionSet;
import static actionPerformer.ObjectVisibility.visibilityAssert;
import static utilities.SpecificItemSelector.dynamicScrollToElement;

public class HomePage {

    public static void userOnHomePage(){
        try {
            AppSpecificActions.lunchApp();
            actionSet("UiReadAndAccept", "LCLICK", null, null);
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void selectCategoryFromHomePage(String categoryName) {
        try {
            visibilityAssert("UiOurCategories", "DEFAULT", null);
            dynamicScrollToElement("UiSpecificCategoriesList", "UiAllCategoriesList", categoryName);
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
