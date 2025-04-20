package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "D:\\bddproject\\src\\test\\resources\\featurefile\\loginFeature.feature",
        glue = {"loginPage"}
        ,monochrome = true


)

public class runner extends AbstractTestNGCucumberTests {
}
