package utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

//ALL RESUSABLE CODES ARE WRITTEN HERE
public class GenericUtils {
    public WebDriver driver;
    public GenericUtils(WebDriver driver)
    {
        this.driver=driver;
    }

    public void switchWindowToChild()
    {
        //to handle child window-first get all window handles
        Set<String> s1=driver.getWindowHandles();//returns the total count of windowsopen with automation.#parent and child window will be there.

        //iterate the collection type to retrieve the windows.
        Iterator<String> i1=s1.iterator();//to retrive the window
        String parentWindow=i1.next();//returns the 0th id window.#by default, i1=>pointing to null.
        String childWindow=i1.next();
        driver.switchTo().window(childWindow);//switches to child window
    }

}
