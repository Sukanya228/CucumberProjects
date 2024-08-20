package StepDefinations;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "StepDefinations",
		plugin = {"pretty","html:target/html-reports/loginreport.html",
				"json:target/html-reports/loginreport.json"},
		monochrome = true  


		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
