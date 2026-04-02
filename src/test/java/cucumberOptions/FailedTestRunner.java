package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "@target/failed_scenarios.txt",glue="stepDefinitions",
monochrome = true,
plugin={"html:target/cucumber.html", "json:target/cucumber.json",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
})
public class FailedTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {   //all the scenarios that need to be executed will fall in the scenarios
        return super.scenarios();//super means asking to execute the method present in the parent clas-AbstractTestNGCucumberTests
        //there is a method inside that -named Scenarios which helps to run parallely.


    }
}
