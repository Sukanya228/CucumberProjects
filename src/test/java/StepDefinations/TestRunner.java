package StepDefinations;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "StepDefinations",
		tags= "Regression",
		plugin = {"pretty","html:target/html-reports/loginreport-2.html"},
		monochrome = true  


		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
