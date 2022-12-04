package runners;


import base.BaseTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import listeners.Execution;
import org.testng.annotations.Listeners;



@Listeners({Execution.class})
@CucumberOptions(features="resources/features"
	,glue={"steps","hooks"}
	,plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	,tags= "@search"
	,monochrome=true
	,publish=true
 )

public class TestRunner extends BaseTest {

 }
