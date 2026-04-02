package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

    public WebDriver driver;//set to global

    //both product names set to public - declared globally to access everywhere
    public String landingpageProductName;
    public String offerpageProductname;
    TestContextSetup testContextSetup;
    public CheckoutPage checkoutPage;

    //constructor
    //the variables from the class is passed to the object of the class shared in the constructor.
    //then, that value is fed to the global var using 'this'.
    public CheckoutPageStepDefinition(TestContextSetup testContextSetup)  //automatically called when object of the class is created.
    {
        this.testContextSetup=testContextSetup;//assigning the value to the global variable.
        this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();//keeping here the object creation code as it is the first to be executed

    }

    @Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
    public void User_proceeds_to_Checkout_and_validate_the_Name_items_in_checkout_page(String name) throws InterruptedException {
        checkoutPage.CheckoutItems();
       // Thread.sleep(2000);

    }

   @Then("Verify user has the ability to enter promo code and place the order")
    public void Verify_user_has_the_ability_to_enter_promo_code_and_place_the_order()
   {

       Assert.assertTrue(checkoutPage.VerifyPromoBtn());
       Assert.assertTrue(checkoutPage.VerifyPlaceOrder());

   }


}
