package com.dyson.driver;

import com.dyson.data.IOSConfig;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.net.URL;

import static io.appium.java_client.remote.MobilePlatform.IOS;

public class iOSAppiumDriver {

    private String hostName = "http://127.0.0.1";
    private Integer portNum = 4723;
    private IOSDriver<WebElement> iosDriver;
    private WebDriverWait wait;
    private static Logger logger = Logger.getLogger(iOSAppiumDriver.class);

    public iOSAppiumDriver() {
        IOSConfig iosConfigData = getIOSConfigData("/Users/mayank.khubchandani/Personal/Project/appTest/src/main/resources/iosconfig.json");
        logger.debug("iOS Config Data: " + iosConfigData.toString());
        try {
            this.iosDriver = createiOSAppiumDriver(hostName, portNum, iosConfigData);
        } catch (Exception e) {
            logger.error("Exception raised while initialising iOS Driver" + e.getStackTrace());
        }
        this.wait = new WebDriverWait(iosDriver, 20);
    }

    private static IOSConfig getIOSConfigData(String fileName) {
        JSONParser parser = new JSONParser();
        IOSConfig iosConfig = new IOSConfig();

        try {
            Object obj = parser.parse(new FileReader(
                    fileName));

            JSONObject data = (JSONObject) obj;
            iosConfig.setPlatformVersion(data.get("platformVersion").toString());
            iosConfig.setDeviceName(data.get("deviceName").toString());
            iosConfig.setAutomationName(data.get("automationName").toString());
            iosConfig.setAppPath(data.get("appPath").toString());
        } catch (Exception e) {
            logger.error("iOS Appium config is not defined" + e.getStackTrace());
        }
        return iosConfig;
    }

    private static DesiredCapabilities createIOSDesiredCapabilities(IOSConfig iosConfig) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, IOS);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, iosConfig.getPlatformVersion());
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, iosConfig.getDeviceName());
        desiredCapabilities.setCapability(MobileCapabilityType.APP, iosConfig.getAppPath());
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, iosConfig.getAutomationName());
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        desiredCapabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 60000);
        return desiredCapabilities;
    }

    public static IOSDriver<WebElement> createiOSAppiumDriver(String hostAddress, Integer port, IOSConfig iOSConfig) throws Exception {
        IOSDriver<WebElement> iosDriver;

        DesiredCapabilities desiredCapabilities;
        desiredCapabilities = createIOSDesiredCapabilities(iOSConfig);
        URL appiumServerAddress = new URL(hostAddress + ":" + port + "/wd/hub");
        iosDriver = new IOSDriver<>(appiumServerAddress, desiredCapabilities);
        return iosDriver;
    }

    public void quit() {
        logger.debug("Calling appium driver quit");
        iosDriver.quit();
    }

    public boolean isElementDisplayedById(String id){
        logger.debug("Calling appium driver isElementDisplayedById for id: " + id);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public void tapOnElementById(String id){
        logger.debug("Calling appium driver tapOnElementById for id: " + id);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
    }
}