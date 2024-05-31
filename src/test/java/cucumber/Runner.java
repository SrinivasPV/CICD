package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java",glue="rahulshettyacademy.stepdefinition",monochrome=true,plugin="html:target/cucumber.html")
public class Runner extends AbstractTestNGCucumberTests{
	

}
