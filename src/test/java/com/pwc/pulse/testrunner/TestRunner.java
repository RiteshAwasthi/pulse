package com.pwc.pulse.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features", //The path of the feature file
		glue = { "com.pwc.pulse.stepdefinition" }, //the path of the step definition file
		tags = {"@All" },  // Execute all tests tagged as @All OR @Scenario_1 OR Scenario_2 OR Scenario_3
		monochrome = true, //Display the console output in a proper readable format
		plugin = { "pretty", 
				"html:Reports", //To generate HTML report
				"json:Reports/report.json", //To generate json format report
				"junit:Reports/report.xml"  //To generate xml format report
				 }
		)

public class TestRunner {

}
