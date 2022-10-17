package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AmazonsLoginPage {
    WebDriver driver;
    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement signIn;
    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    WebElement mobileNumber;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement clickContinue;

    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement Password;
    @FindBy(xpath = "//*[@id=\"signInSubmit\"]")
    WebElement submit;


    public AmazonsLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickSignIn() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        signIn.click();
    }

    public void enter_mobile(String phNumner) {
        mobileNumber.sendKeys(phNumner);
        clickContinue.click();
    }

    public void enter_password(String password) {
        Password.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        submit.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
}
