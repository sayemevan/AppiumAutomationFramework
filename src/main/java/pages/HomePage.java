package pages;

import tools.ObjectActions;
import tools.ObjectVisibility;
import tools.Scroller;


public class HomePage {

    public static void userOnHomePage(){
        try {
            ObjectActions.set("UiReadAndAccept", "LCLICK", null, null);
            ObjectVisibility.assertInVisibility("UiReadAndAccept","DEFAULT", null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void selectCategoryFromHomePage(String categoryName) {
        try {
            ObjectVisibility.assertVisibility("UiOurCategories", "DEFAULT", null);
            Scroller.dynamicScrollToElementAndClick("UiSpecificCategoriesList", "UiAllCategoriesList", categoryName, 10);
            ObjectVisibility.assertInVisibility("UiOurCategories","DEFAULT", null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
