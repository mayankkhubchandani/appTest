package com.dyson.functionaltest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/com.dyson.functionaltest/weatherCheck.feature"}
)
public class WeatherFunctionalTest { }
