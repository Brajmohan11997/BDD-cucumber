package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "D:\\bddproject\\src\\test\\resources\\featurefile\\formFeature.feature" ,
        glue = {"simpleForm"},
        monochrome = true
)

public class simpleFormRunner extends AbstractTestNGCucumberTests {
}
