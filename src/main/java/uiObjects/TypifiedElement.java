package uiObjects;

import io.appium.java_client.MobileElement;

public abstract class TypifiedElement extends MobileElement implements WrapsMobileElement {

    private final MobileElement wrappedMobileElement;

    public TypifiedElement(MobileElement wrappedMobileElement) {
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
}
