package com.dyson.pages;

import com.dyson.driver.iOSAppiumDriver;

public class PageFactory {

    private DataCollectionPage dataCollectionPage;
    private InternetConnectionPage internetConnectionPage;
    private WeatherDataPage weatherDataPage;

    public PageFactory(iOSAppiumDriver iOSAppiumDriver){
        this.dataCollectionPage = new DataCollectionPage(iOSAppiumDriver);
        this.weatherDataPage = new WeatherDataPage(iOSAppiumDriver);
        this.internetConnectionPage = new InternetConnectionPage(iOSAppiumDriver);
    }

    public DataCollectionPage getDataCollectionPage() {
        return dataCollectionPage;
    }

    public InternetConnectionPage getInternetConnectionPage() {
        return internetConnectionPage;
    }

    public WeatherDataPage getWeatherDataPage() {
        return weatherDataPage;
    }
}
