package Run_failedScenarios;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		strict = true,
		monochrome = true, 
		features = {"rerun/failed_scenarios.txt"},
		tags={"@Tools_2"},
		glue = {"stepdefinition","Testrunner"}, 	
		plugin = {
	                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
	                "pretty",
	                "json:target/cucumber-reports/cucumber.json",
	                "html:target/cucumber-reports",
	                "rerun:rerun/failed_scenarios.txt"
	        }
	
		)

public class Run_failedScenarios extends AbstractTestNGCucumberTests {
	
	

}
