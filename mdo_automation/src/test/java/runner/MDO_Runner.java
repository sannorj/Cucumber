package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/features" }, 
		glue = { "myP2_step_definitions", "hooks" }, 
		tags = "@sannorj",
		plugin = { "pretty", 
				"junit:target/mdoReports/report.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true
		)
public class MDO_Runner {

}
