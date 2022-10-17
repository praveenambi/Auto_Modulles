package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Base.BasePage;
import org.example.Pages.AmazonHomePage;
import org.example.Pages.AmazonsLoginPage;
import org.example.Pages.AmazonsMobilePage;
import org.example.TestMail;
import org.example.helpers.JsonHelper;
import org.openqa.selenium.WebDriver;

public class AmazonMobileBooking {
    WebDriver driver;
    BasePage basePage;
    AmazonsMobilePage amazonsMobilePage;
    AmazonsLoginPage amazonsLoginPage;

    AmazonHomePage amazonHomePage;
    TestMail testMail;

    public AmazonMobileBooking() throws InterruptedException {
        basePage = new BasePage();


        this.driver = basePage.initialize_browser("https://www.amazon.in/");
        amazonsLoginPage = new AmazonsLoginPage(driver);
        //amazonsLoginPage.enter_mobile("9739713447");
        amazonsMobilePage = new AmazonsMobilePage(driver);
        amazonHomePage=new AmazonHomePage(driver);
        testMail=new TestMail();
        //amazonsMobilePage.enter_password();
//        amazonHomePage=new AmazonHomePage(driver);
//        amazonHomePage.search_mobiles();


    }


    //    @Given("i launch amazon application")
//    public void iLaunchAmazonApplication()
//        {
//basePage.initialize_browser("https://www.amazon.in/");
//            System.out.println("i got ");
//        }
    @Given("i launch amazon application")
    public void iLaunchAmazonApplication() {


        System.out.println("Launching Application");
    }

    @And("i login to amazon")
    public void iLoginToAmazon() {
        amazonsLoginPage.clickSignIn();

    }


//   @And("i enter email {string}")
//   public void iEnterEmail(String phoneNum) {
//        amazonsLoginPage.enter_mobile(phoneNum);
// }
    @And("i enter email")
    public void iEnterEmailFromJson() {
        amazonsLoginPage.enter_mobile(JsonHelper.getNodeValue("/Application/Amazon/amazonUsername"));
    }

    @And("i enter my password")
    public void iEnterMyPassword() {

        amazonsMobilePage.enter_password(JsonHelper.getNodeValue("/Application/Amazon/amazonPassword"));
    }

    @And("i search with")
    public void iSearchWith() {

        amazonHomePage.search_mobiles(JsonHelper.getNodeValue("/Application/Amazon/productType"));
    }

    @And("i enter search")
    public void iEnterSearch() {
        amazonHomePage.setSearch();
    }

//    @And("enter lowest range ")
//    public void price(String lPrice){
//        amazonHomePage.price(lPrice);
//
//    }

    @And("enter lowest range")
    public void enterLowestRange() {
        amazonHomePage.price(JsonHelper.getNodeValue("/Application/Amazon/productLowestRange"));
    }

    @And("enter highest range")
    public void enterHighestRange() {

        amazonHomePage.hPrice(JsonHelper.getNodeValue("/Application/Amazon/productHighestRange"));
    }
    @And("click on go")
    public void clickOnGo() {
        amazonHomePage.inputPrice();
    }
    @And("i select RAM as")
    public void iSelectRAMAs() {

        amazonHomePage.gb(JsonHelper.getNodeValue("/Application/Amazon/productGb"));
    }

    @And("i select phone")
    public void iSelectPhone() throws InterruptedException {
        amazonHomePage.selectPhone();
    }

    @When("i select checkout")
    public void iSelectCheckout() {
        amazonHomePage.checkOut();
    }

    @Then("i select address")
    public void iSelectAddress(String address) {
        amazonHomePage.selectAddress(address);
    }


    @And("i add to cart")
    public void iAddToCart() {
        amazonHomePage.addToCart();
    }


    @And("i add mobile to cart")
    public void iAddMobileToCart() throws InterruptedException {
        amazonHomePage.addProductToCart();
    }


    @And("i enter new mail")
    public void iEnterNewMail() {
        testMail.mailTest();
    }
}



//
//    @And("^i select mobile gb as (\\d+)gb$")
//    public void iSelectMobileGbAsGb(int arg0) {
//
//    }
//}
