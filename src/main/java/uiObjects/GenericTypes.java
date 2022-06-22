package uiObjects;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import register.WrapsMobileElement;

import static register.DataProvider.*;

public abstract class GenericTypes extends MobileElement implements WrapsMobileElement {

    private final MobileElement wrappedMobileElement;

    public GenericTypes(MobileElement wrappedMobileElement) {
        this.wrappedMobileElement = wrappedMobileElement;
    }

    @Override
    public MobileElement getWrapsMobileElement() {
        return wrappedMobileElement;
    }

    @Override
    public void click(){
        getWrapsMobileElement().click();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        getWrapsMobileElement().sendKeys(keysToSend);
    }

    @Override
    public String getText() {
        return getWrapsMobileElement().getText();
    }

    @Override
    public String getAttribute(String name) {
        return getWrapsMobileElement().getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return getWrapsMobileElement().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return getWrapsMobileElement().isEnabled();
    }

    @Override
    public void clear() {
        getWrapsMobileElement().clear();
    }

    @Override
    public String getTagName() {
        return getWrapsMobileElement().getTagName();
    }

    @Override
    public void submit() {
        getWrapsMobileElement().submit();
    }

    public static MobileElement scrollToElement(String outSiderText) {

        return (MobileElement) ((FindsByAndroidUIAutomator) APPIUM_DRIVER).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector().description("+ outSiderText +"));");
    }
}
