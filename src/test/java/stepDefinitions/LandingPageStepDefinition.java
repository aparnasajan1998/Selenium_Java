package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class LandingPageStepDefinition {

    public WebDriver driver;//set to global

    //both product names set to public - declared globally to access everywhere
    public String landingpageProductName;
    public String offerpageProductname;
    TestContextSetup testContextSetup;
    LandingPage landingPage;

    //constructor
    //the variables from the class is passed to the object of the class shared in the constructor.
    //then, that value is fed to the global var using 'this'.
    public LandingPageStepDefinition(TestContextSetup testContextSetup)  //automatically called when object of the class is created.
    {
        this.testContextSetup=testContextSetup;//assigning the value to the global variable.
        this.landingPage=testContextSetup.pageObjectManager.getLandingPage();
    }
    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

    }
    @When("^User searched with short name (.+) and extracted actual name$") //use regular expressions when using dynamic sets of data
    public void user_searched_with_short_name_and_extracted_actual_name(String shortName) throws InterruptedException {
        //driver declared global make -to access everywhere

        landingPage.searchItem(shortName);
        Thread.sleep(2000);
        testContextSetup.landingpageProductName=landingPage.getProductName().split("-")[0].trim();//get the text
        System.out.println(landingpageProductName + "is extracted from home page");
    }
    @When("Added {string} items of the selected product to cart")
    public void Added_items_product(String quantity)
    {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.AddToCart();
    }
}
