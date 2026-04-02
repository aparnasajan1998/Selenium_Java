import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class testthree {
    public static void main(String[] args) throws InterruptedException {
        //mousehover
        System.setProperty("webdriver.chrome.driver","/Users/aparn/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();
        WebElement par=driver.findElement(By.xpath("//div[@id='content']/div/div"));
        Thread.sleep(4000);
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(par).perform();
        Thread.sleep(2000);
        String ele=driver.findElement(By.xpath("//div[@id='content']/div/div/div")).getText();
        System.out.println(ele);
        WebElement pro=driver.findElement(By.linkText("View profile"));
        pro.click();
        Thread.sleep(2000);
        System.out.println("logged in");
        driver.close();
        System.out.println("successful");

        //Assert.assertEquals("name: user1",driver.findElement(By.xpath("//div[@id='content']/div/div/div")).getText());




    }
}
