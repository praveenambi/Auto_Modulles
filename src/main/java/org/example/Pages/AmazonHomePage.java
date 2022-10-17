package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class AmazonHomePage {
    WebDriver driver;

    public WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
    WebElement enter;

    //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    @FindBy(id = "nav-search-submit-button")
    WebElement search;

    @FindBy(id = "low-price")
    WebElement price;

    @FindBy(id = "high-price")
    WebElement hPrice;
    @FindBy(xpath = "//*[@id=\"a-autoid-1\"]/span/input")
    WebElement inputPrice;
    @FindBy(xpath = "//*[@id=\"p_n_feature_seven_browse-bin/8561132031\"]/span/a/div/label/i")

    WebElement gb;
    @FindBy(xpath = "//a/span[@class='a-size-medium a-color-base a-text-normal' and contains(.,'vivo Y15C (Wave Green, 3GB RAM, 32GB Storage)')]")
    WebElement selectPhone;

    @FindBy(id = "add-to-cart-button")
    WebElement addToCart;


    @FindBy(xpath = "//input[@type='submit' and contains(@aria-labelledby,'checkout-button')][1]")
    WebElement checkOut;

    @FindBy(xpath = "//a[contains(., ' 76/230-1-36') and contains(text(),'Deliver to this address')]")
    WebElement selectAddress;
    @FindBy(xpath = "//*[@id=\"orderSummaryPrimaryActionBtn\"]/span/input")
    WebElement selectGivenAddress;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search_mobiles(String searchmo) {
        wait = new WebDriverWait(driver, 10);
        enter.sendKeys(searchmo);
    }
    public void setSearch() {
        search.click();
    }
public void price(String lvalue) {
    price.sendKeys(lvalue);
}
public void hPrice(String maxPrice)
{
    hPrice.sendKeys(maxPrice);
}
public void inputPrice()
{

    inputPrice.click();
}
public void gb(String iGb)
{

    gb.click();
}
public void selectPhone() {
        WebDriverWait wait= new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOf(selectPhone));
        selectPhone.click();

}
public void addToCart()
{

    addToCart.click();
}
public void checkOut()
{
    checkOut.click();
}
public void selectAddress(String add)
{
    selectAddress.click();

}
        //wait = new WebDriverWait(driver, 10);
        //search.click();
//        price.sendKeys("8000");
//        highPrice.sendKeys("10000");
//        inputPrice.click();
//        gb.click();
//        selectPhone.click();
//addProductToCart();
//        addToCart.click();
//        checkOut.click();
//        selectAddress.click();


        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



    public void addProductToCart() throws InterruptedException {
        String currentWindow = driver.getWindowHandle();
        System.out.println("current window is:" + currentWindow);
        Set<String> noOfWindows = driver.getWindowHandles();
        for (String window : noOfWindows) {
            System.out.println(window);
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                addToCart.click();
                Thread.sleep(200);
                //driver.findElement(By.id("add-to-cart-button")).click();
                checkOut.click();
                //driver.findElement(By.xpath("//input[@type='submit' and contains(@aria-labelledby,'checkout-button')]")).click();
                //driver.findElement(By.xpath("//*[@id=\"address-book-entry-1\"]/div[2]/span/a")).click();
                selectAddress.click();
                selectGivenAddress.click();
                //driver.findElement(By.xpath("//a[contains(., ' 76/230-1-36') and contains(text(),'Deliver to this address')]")).click();
                //driver.close();
            }
        }
    }

}