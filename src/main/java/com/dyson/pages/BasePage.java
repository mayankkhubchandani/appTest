package com.dyson.pages;

import com.dyson.driver.iOSAppiumDriver;

public class BasePage {
    protected String nextPageButton = "next_button";

    protected iOSAppiumDriver appiumDriver;

    public BasePage(iOSAppiumDriver driver) {
        this.appiumDriver = driver;
    }

    public iOSAppiumDriver getAppiumDriver() {
        return appiumDriver;
    }
}
