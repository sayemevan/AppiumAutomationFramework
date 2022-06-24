package utilities;

import static register.DataProvider.*;

public class ObjectRepositoryActions {

    public static String getRepoValue(String uiObjectName){
        if (APP_LOCATOR_VALUES.getProperty(uiObjectName) != null) {
            return APP_LOCATOR_VALUES.getProperty(uiObjectName);
        } else if (UTILITY_OBJECTS.getProperty(uiObjectName) != null) {
            return UTILITY_OBJECTS.getProperty(uiObjectName);
        } else {
            return null;
        }
    }

    public static void addOrReplaceRepoValue(String uiObjectKeyName, String uiObjectValue){
        if (APP_LOCATOR_VALUES.getProperty(uiObjectKeyName) != null) {
            APP_LOCATOR_VALUES.replace(uiObjectKeyName, uiObjectValue);
        } else if (UTILITY_OBJECTS.getProperty(uiObjectKeyName) != null) {
            UTILITY_OBJECTS.replace(uiObjectKeyName, uiObjectValue);
        } else {
            UTILITY_OBJECTS.put(uiObjectKeyName, uiObjectValue);
        }
    }
}
