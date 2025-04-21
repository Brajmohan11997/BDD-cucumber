package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "D:\\bddproject\\src\\test\\resources\\featurefile\\bookFlight.feature",
        glue = {"flightBook"},
        monochrome = true
)

public class flightRunner extends AbstractTestNGCucumberTests {
}
