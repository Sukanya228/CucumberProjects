package StepDefinations;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "StepDefinations",
		plugin = {"pretty","html:target/html-reports/loginreport-3.html"},
		monochrome = true  


		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
