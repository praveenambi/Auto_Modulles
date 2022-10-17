package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonsMobilePage {
    WebDriver driver;
    AmazonHomePage homePage;

    AmazonsMobilePage mobilePage;

    AmazonsLoginPage loginPage;
    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement signIn;
    @FindBy(xpath ="//*[@id=\"ap_email\"]")
    WebElement entrust;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement click;


    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement passwordField;

    @FindBy(xpath ="//*[@id=\"signInSubmit\"]")
    WebElement go;
    public AmazonsMobilePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

public void enter_password(String password)
{
    //wait = new WebDriverWait(driver , 10);

    //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    passwordField.sendKeys(password);

    //wait = new WebDriverWait(driver , 50);

    //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    go.click();
}
}
