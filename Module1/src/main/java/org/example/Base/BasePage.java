package org.example.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;
    public WebDriver initialize_browser(String url)
    {
        System.out.println("hai");
        WebDriverManager.chromedriver().browserVersion("105").setup();
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\IN22916283\\OneDrive - Tesco\\Desktop\\Automation\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in");
        return driver;
    }
}
