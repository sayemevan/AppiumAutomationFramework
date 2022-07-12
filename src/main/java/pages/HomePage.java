package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import tools.ObjectVisibility;
import tools.Scroller;


public class HomePage {

    //Page object model example
    @FindBy(id = "btnAccept")
    private static MobileElement readAndAcceptBtn;

    public static void userOnHomePage(){
        try {
            readAndAcceptBtn.click();
            ObjectVisibility.assertInVisibility("UiReadAndAccept","DEFAULT", null);
        } catch (Exception e){
            System.out.println("Error!! Application home page is not visible!");
            e.printStackTrace();
        }
    }

    public static void selectCategoryFromHomePage(String categoryName) {
        try {
            ObjectVisibility.assertVisibility("UiOurCategories", "DEFAULT", null);
            Scroller.dynamicScrollToElementAndClick("UiSpecificCategoriesList", "UiAllCategoriesList", categoryName, 10);
            ObjectVisibility.assertInVisibility("UiOurCategories","DEFAULT", null);
        } catch (Exception e){
            System.out.println("Error!! User can't select application category.");
            e.printStackTrace();
        }
    }

}
