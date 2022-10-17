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
import org.apache.commons.codec.binary.Base64;


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
        amazonsMobilePage = new AmazonsMobilePage(driver);
        amazonHomePage=new AmazonHomePage(driver);
        testMail=new TestMail();
    }

    @Given("i launch amazon application")
    public void iLaunchAmazonApplication() {

        System.out.println("Launching Application");
    }

    @And("i login to amazon")
    public void iLoginToAmazon() {
        amazonsLoginPage.clickSignIn();
    }


    @And("i enter email")
    public void iEnterEmailFromJson() {
        byte[] userName = Base64.decodeBase64(JsonHelper.getNodeValue("/Application/Amazon/amazonUsername").getBytes());
        amazonsLoginPage.enter_mobile(new String(userName));
    }

    @And("i enter my password")
    public void iEnterMyPassword() {
        byte[] passWord = Base64.decodeBase64(JsonHelper.getNodeValue("/Application/Amazon/amazonPassword").getBytes());
        amazonsMobilePage.enter_password(new String(passWord));
    }

    @And("i search with")
    public void iSearchWith() {

        amazonHomePage.search_mobiles(JsonHelper.getNodeValue("/Application/Amazon/productType"));
    }

    @And("i enter search")
    public void iEnterSearch() {
        amazonHomePage.setSearch();
    }

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

