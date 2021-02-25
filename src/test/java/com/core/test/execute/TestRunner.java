package com.core.test.execute;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {
		"com.core.test.steps" }, tags = "@homepage", monochrome = true, useFileNameCompatibleName = true, plugin = {
				"pretty", "json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/cucumber.html",
				"junit:target/cucumber-reports/cucumber.xml" })

public class TestRunner {

}
