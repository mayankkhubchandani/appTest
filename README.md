# Web Test Help

This document will help you to setup & run Appium UI Tests for iOS

-------------------------------------------
**Setup Instructions:**
- Download Appium driver from [here](http://appium.io/docs/en/about-appium/getting-started/)
- Also, setup iOS related dependencies. Follow [this](http://appium.io/docs/en/drivers/ios-xcuitest/index.html) link
- Verify iOS specific installation by running below command. Setup `appium-doctor` wrt [this](http://appium.io/docs/en/about-appium/getting-started/) link
```appium-doctor --ios```

**Setting up Project to execute**
- Clone the repo
- Edit below fields in the file `/src/main/resources/iosconfig.json`

    - iOS simulator name
    - iOS Version
    - Copy app file to resources folder or change appPath value to absolute path of the app file

**Steps To Run Test:**
- Navigate to project dir
- Start appium server by command
```appium```
- Execute test with
```
mvn clean test
```