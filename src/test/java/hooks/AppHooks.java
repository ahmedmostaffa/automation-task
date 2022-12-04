package hooks;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.images.Screenshots;

import java.io.File;

public class AppHooks extends BaseTest {
    @Before
    public static void beforeScenario(){


    }
    @After
    public static void afterScenario(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(Screenshots.takeScreenshot(getDriver()),"image/png","failed screenshot");
        }





    }


}
