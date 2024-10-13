package com.demo_web_shop.core;

import com.demo_web_shop.fw.HomeHelper;
import com.demo_web_shop.fw.ProductHelper;
import com.demo_web_shop.fw.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class ApplicationManager {

    public WebDriver driver;
    UserHelper userHelper;
    HomeHelper homeHelper;
    ProductHelper contactHelper;
    private final String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options=new ChromeOptions();
            //options.addArguments("window-size=1920x1080");
            // options.addArguments("headless");// запуск без графического драйвера, используем когда все тесты готовы и отлажены
            // driver = new ChromeDriver(options);
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {
            driver=new EdgeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver=new SafariDriver();
        }
       // driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();//разворачивает браузер на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// неявное ожидание 10 c

        userHelper = new UserHelper(driver);
        homeHelper = new HomeHelper(driver);
        contactHelper = new ProductHelper(driver);
    }


    public UserHelper getUserHelper() {
        return userHelper;
    }

    public HomeHelper getHomeHelper() {
        return homeHelper;
    }

    public ProductHelper getContactHelper() {
        return contactHelper;
    }
    public void stop() {
        driver.quit();
    }

}
