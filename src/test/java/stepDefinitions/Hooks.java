package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;
    public Hooks(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }
    //inject testcontextsetup in hooks file for taking testbase object.
    //driver is in TestBase-call webdrivermanager
    //after annotation executes after current scenario
    @After
    public void AfterScenario() throws IOException {
        testContextSetup.testBase.WebDriverManager().quit();
    }
    //After and AfterStep-runs after every scenrio whereas afterstep runs after each step.
    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        WebDriver driver=testContextSetup.testBase.WebDriverManager();
        if(scenario.isFailed())
        {
            //code to take ss
           File sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //once imported there is a class called File Utils
            byte[] fileContent=FileUtils.readFileToByteArray(sourcePath);
           scenario.attach(fileContent,"image/png","image");
        }
    }
}
