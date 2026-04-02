package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {

    public WebDriver driver;//set to global

    //both product names set to public - declared globally to access everywhere
    public String landingpageProductName;//this var is pointing to NULL.
    public String offerpageProductname;
    TestContextSetup testContextSetup;
    PageObjectManager pageObjectManager;

    //constructor
    public OfferPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }

    @Then("^User searched for (.+) shortname in offers page$")
    public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
        switchToOffersPage();
        OffersPage offersPage=testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchItem(shortName);;
        Thread.sleep(2000);
        offerpageProductname=offersPage.getProductName();
    }

    //does the work of switching
    public void switchToOffersPage()//only takes care of switching to the child window
    {
        LandingPage landingPage=testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.switchWindowToChild();
    }

    @Then("Validate product name in offers page matches with landing page")
    public void validate_product_name_in_offers_page_matches_with_landing_page(){
        Assert.assertEquals(offerpageProductname,testContextSetup.landingpageProductName);
    }


}
