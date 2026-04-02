package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {
    //tell here what are the variables /ppties that is gonna be shared with another step definition file.
    public WebDriver driver;
    public String landingpageProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;
    public TestContextSetup() throws IOException {
        testBase=new TestBase();
        pageObjectManager=new PageObjectManager(testBase.WebDriverManager());
        genericUtils=new GenericUtils(testBase.WebDriverManager());
    }
}
