package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public LandingPage landingPage;
    public OffersPage offersPage;
    public WebDriver driver;
    public CheckoutPage checkoutPage;

    public PageObjectManager(WebDriver driver){//constructor to initialize driver
    this.driver=driver;
    }
    //responsible to give the objects


    public LandingPage getLandingPage()    //gives the object of landing page.
    {
        landingPage=new LandingPage(driver);
        return landingPage;
    }
    public OffersPage getOffersPage()    //gives the object of landing page.
    {
        offersPage=new OffersPage(driver);
        return offersPage;
    }

    public CheckoutPage getCheckoutPage()    //gives the object of checkout page.
    {
        checkoutPage=new CheckoutPage(driver);
        return checkoutPage;
    }
}

