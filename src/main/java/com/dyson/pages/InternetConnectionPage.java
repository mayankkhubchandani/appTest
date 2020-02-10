package com.dyson.pages;

import com.dyson.driver.iOSAppiumDriver;

public class InternetConnectionPage extends BasePage {
    private String connectedAccessibilityId = "fetch_data_title_label";

    public InternetConnectionPage(iOSAppiumDriver driver) {
        super(driver);
    }

    public boolean isConnectedStatusDisplayed(){
        return appiumDriver.isElementDisplayedById(connectedAccessibilityId);
    }

    public void tapOnFetchDataButton() {
        appiumDriver.tapOnElementById(nextPageButton);
    }
}
