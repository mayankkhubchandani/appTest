package com.dyson.pages;

import com.dyson.driver.iOSAppiumDriver;

public class WeatherDataPage extends BasePage {

    private String weatherAccessId = "weather_title_label";
    private String weatherDescAccessId = "weather_description_label";
    private String temperatureAccessId = "temperature_title_label";
    private String temperatureDescAccessId = "temperature_title_label";
    private String doneButtonAccessId = "done_button";

    public WeatherDataPage(iOSAppiumDriver driver) {
        super(driver);
    }

    public boolean isWeatherDataPageDisplayed(){
        return appiumDriver.isElementDisplayedById(doneButtonAccessId);
    }

    public boolean isWeatherDataDisplayed(){
        return (appiumDriver.isElementDisplayedById(weatherAccessId) && appiumDriver.isElementDisplayedById(weatherDescAccessId));
    }

    public boolean isTemperatureDataDisplayed() {
        return appiumDriver.isElementDisplayedById(temperatureAccessId) && appiumDriver.isElementDisplayedById(temperatureDescAccessId);
    }
}
