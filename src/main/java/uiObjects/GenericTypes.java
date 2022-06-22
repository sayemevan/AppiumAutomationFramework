package uiObjects;

import io.appium.java_client.MobileElement;
import register.WrapsMobileElement;

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
}
