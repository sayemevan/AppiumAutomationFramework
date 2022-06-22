package utilities;

import java.util.Properties;

import static dataProvider.propertyFileReader.*;
import static register.DataProvider.*;

public class ObjectRepositoryActions {
    public static String getValue(Properties properties, String propertyFileName, String uiObjectName){
        if (properties.isEmpty()) {
            properties = objectRepositoryGet(APP_LOCATOR_PATH, propertyFileName);
        }
        if (properties.getProperty(uiObjectName) != null) {
            return properties.getProperty(uiObjectName);
        } else {
            return null;
        }
    }
}
