package com.dyson.functionaltest.stepDefs;

import com.dyson.driver.iOSAppiumDriver;
import com.dyson.pages.PageFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    PageFactory pageFactory;
    iOSAppiumDriver appiumDriver;
    private static Logger logger = Logger.getLogger(StepDefinitions.class);

    @Before
    public void setUpBefore() {
        logger.debug("In setUpBefore function");
        this.appiumDriver = new iOSAppiumDriver();
        pageFactory = new PageFactory(appiumDriver);
    }

    @After
    public void tearDown() {
        logger.debug("In tearDown function");
        appiumDriver.quit();
    }

    @Given("I have an internet connection")
    public void givenInternetConnection() {
        logger.debug("Checking if Internet connection page is displayed");
        assertTrue("", pageFactory.getInternetConnectionPage().isConnectedStatusDisplayed());
    }

    @When("I have successfully downloaded the weather data")
    public void fetchWeatherData(){
        logger.debug("tap On Fetch Data button");
        pageFactory.getInternetConnectionPage().tapOnFetchDataButton();
        logger.debug("tap On View Results button");
        pageFactory.getDataCollectionPage().tapOnViewResultsButton();
    }

    @Then("I can see the weather and temperature for today")
    public void checkWeatherAndTemperatureDataDisplayed(){
        logger.debug("Checking if weather & temperature data are displayed");
        checkWeatherDataDisplayed();
        checkTemperatureDataDisplayed();
    }

    @Then("I can see the weather for today")
    public void checkWeatherDataDisplayed(){
        logger.debug("Checking if weather data is displayed");
        assertTrue(pageFactory.getWeatherDataPage().isWeatherDataPageDisplayed());
        assertTrue(pageFactory.getWeatherDataPage().isWeatherDataDisplayed());
    }

    @Then("I can see the temperature for today")
    public void checkTemperatureDataDisplayed(){
        logger.debug("Checking if temperature data is displayed");
        assertTrue(pageFactory.getWeatherDataPage().isTemperatureDataDisplayed());
    }
}
