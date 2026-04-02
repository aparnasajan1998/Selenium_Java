import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/aparn/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.amazon.com");
        driver.findElement(By.cssSelector("span[class='hm-icon-label']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[data-menu-id='5']")).click();



    }
}
