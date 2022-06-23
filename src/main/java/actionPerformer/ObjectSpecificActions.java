package actionPerformer;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import uiObjects.*;

import static actionPerformer.ObjectVisibility.*;
import static dataProvider.ExcelUtilities.excelSheetDataGet;
import static register.DataProvider.*;
import static register.ElementFinder.*;
import static utilities.ObjectRepositoryActions.*;
import static utilities.SpecificItemSelector.*;

public class ObjectSpecificActions {

    public static boolean actionSet(String uiObjectName, String actionType, String valueToBeSet, String extraParam){
        try {
            String uiObjectDetails = getRepoValue(uiObjectName);
            if (!visibilityAssert(uiObjectName, "DEFAULT", null)) {
                return false;
            }
            MobileElement mobileElement = getElement(uiObjectDetails);
            if (uiObjectName == null || actionType == null || mobileElement == null) {
                return false;
            }
            if(valueToBeSet == null){
                valueToBeSet = "NULL";
            }
            scrollUntilElementVisible(uiObjectName, null);

            switch (uiObjectDetails.split("~")[2].trim().toUpperCase()) {
                case "TEXTBOX":
                    TextBox textBox = new TextBox(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "VALUESET":
                        case "TEXTINPUT":
                            if (valueToBeSet.equals("BLANK") || valueToBeSet.equals("NULL")) {
                                textBox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                            } else {
                                textBox.sendKeys(valueToBeSet);
                            }
                            break;
                        case "SETBLANK":
                            textBox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                            break;
                        case "LCLICK":
                            textBox.click();
                            break;
                        case "RCLICK":
                            break;
                        case "MOUSEOVER":
                            break;
                    }
                    break;
                case "PUSHBUTTON":
                    PushButton pushButton = new PushButton(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "LCLICK":
                            pushButton.click();
                            break;
                        case "RCLICK":
                            break;
                        case "MOUSEOVER":
                            break;
                    }
                    break;
                case "ICONBUTTON":
                    IconButton iconButton = new IconButton(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "LCLICK":
                            iconButton.click();
                            break;
                        case "RCLICK":
                            break;
                        case "MOUSEOVER":
                            break;
                    }
                    break;
                case "LISTBOX":
                    ListBox listBox = new ListBox(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "VALUESET":
                        case "ITEMSELECT":
//                            Select select = new Select(listBox);
//                            select.selectByValue("Bangladesh");
                            listBox.click();
                            //For selecting Bangladesh only
                            Thread.sleep(1000);
                            getElement(getRepoValue("UiBangladesh")).click();
                            Thread.sleep(2000);
                            break;
                        case "ITEMDESELECT":
                        case "SETBLANK":
                            break;
                        case "TEXTINPUT":
                            break;
                        case "LCLICK":
                            listBox.click();
                            break;
                        case "RCLICK":
                            break;
                        case "MOUSEOVER":
                            break;
                    }
                    break;
                case "PREVIEW":
                    PreView preView = new PreView(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "VIEW":
                            break;
                        case "LCLICK":
                            preView.click();
                            break;
                        case "RCLICK":
                            break;
                        case "MOUSEOVER":
                            break;
                    }
                    break;
                case "RADIOBUTTON":
                    RadioButton radioButton = new RadioButton(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "LCLICK":
                            radioButton.click();
                            break;
                        case "RCLICK":
                            break;
                        case "SETON":
                            if(!radioButton.isEnabled()){
                                radioButton.click();
                            }
                            break;
                        case "SETOFF":
                            if(radioButton.isEnabled()){
                                radioButton.click();
                            }
                            break;
                        case "MOUSEOVER":
                            break;
                    }
                    break;
                case "LISTVIEW":
                    ListView listView = new ListView(mobileElement);
                    switch (actionType.trim().toUpperCase()) {
                        case "DEFAULT":
                        case "LCLICK":
                            listView.click();
                            break;
                        case "RCLICK":
                            break;
                        case "MOUSEOVER":
                            break;
                    }
                    break;
            }
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean groupDatActionSetFromExcel(String dataSheetName, String extraParam) {
        try {
            String uiObjectName, actionType, valueToBeSet;
            if(excelSheetDataGet(EXCEL_SHEET_FILE_NAME, EXCEL_SHEET_FILE_PATH, dataSheetName, null)) {
                for (int j = 0; j < excelSheetList.get(dataSheetName).size(); j++) {
                    uiObjectName = excelSheetList.get(dataSheetName).get(j).get("UiObjectName");
                    actionType = excelSheetList.get(dataSheetName).get(j).get("ActionType");
                    valueToBeSet = excelSheetList.get(dataSheetName).get(j).get("ValueToBeSet");
                    if(valueToBeSet.startsWith("\"") && valueToBeSet.endsWith("\"")){
                        valueToBeSet = valueToBeSet.substring(1, valueToBeSet.length()-1);
                    }

                    scrollUntilElementVisible(uiObjectName, null);
                    actionSet(uiObjectName, actionType, valueToBeSet, extraParam);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
