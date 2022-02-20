package CucumberOptions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



//@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features", glue="StepDefination")

public class TestRunner extends AbstractTestNGCucumberTests {

}
