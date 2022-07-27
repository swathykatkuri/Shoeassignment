package Runner;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "Feature/ShoeStore.feature",
		tags={"@test"},
		glue= {"stepDefination"},
				plugin = {"html:target/cucumber-reports/cucumber-pretty","json:target/json-cucumber-reports/default/cukejson.json",
		"testng:target/testng-cucumber-reports/cuketestng.xml"}, 
		monochrome=true
		)
public class TestRunner extends AbstractTestNGCucumberParallelTests
{
	@BeforeClass
	public static void before() {
		System.out.println("Before - "+System.currentTimeMillis());
	}
	
	@AfterClass
	public static void after() {
		System.out.println("After - "+System.currentTimeMillis());
	}
}
