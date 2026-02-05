package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		 features = "src/main/java/features", // path to your feature files
		 glue = {"stepdefinitions"}, // package for step defs & hooks
		 tags = "@smoke",
		 monochrome = true, // pretty console output
		 publish = true, // publishes report to Cucumber Cloud
		 plugin = {
		 "pretty",
		 "html:target/cucumber-reports/cucumber.html",
		 "json:target/cucumber-reports/cucumber.json",
		 "junit:target/cucumber-reports/cucumber.xml"
		 }
		)

public class LoginRunner extends AbstractTestNGCucumberTests{

}
