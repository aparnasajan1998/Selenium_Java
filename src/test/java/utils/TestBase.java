package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException   //RESPONSIBLE FOR GIVING THE DRIVER OBJ INITIALIZATION
    {
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties prop=new Properties();
        prop.load(fis);
        String url=prop.getProperty("QAUrl");
        String browser_properties=prop.getProperty("browser");
        String browser_maven=System.getProperty("browser");
        if(driver==null) {
            if(browser_properties.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
                driver = new ChromeDriver();
            }
            else if(browser_properties=="firefox")
            {
                //code
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }
        return driver;
    }
}
