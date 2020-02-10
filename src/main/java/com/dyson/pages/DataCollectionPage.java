package com.dyson.pages;

import com.dyson.driver.iOSAppiumDriver;

public class DataCollectionPage extends BasePage {

    private String dataCollectedAccessId = "view_results_title_label";
    public DataCollectionPage(iOSAppiumDriver driver){
        super(driver);
    }

    public boolean isDataCollectedStatusDisplayed() {
        return appiumDriver.isElementDisplayedById(dataCollectedAccessId);
    }

    public void tapOnViewResultsButton() {
        appiumDriver.tapOnElementById(nextPageButton);
    }

}
