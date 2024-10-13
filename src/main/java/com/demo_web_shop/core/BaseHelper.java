package com.demo_web_shop.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class BaseHelper {
    protected WebDriver driver;
    Logger logger = LoggerFactory.getLogger(BaseHelper.class);
    public BaseHelper(WebDriver driver) {
        this.driver=driver;
    }

    public boolean isElementPresent(By locator) {
        //System.out.println("Проверка есть ли елемент [ " + locator + "] на странице");
        return driver.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert().accept();
            return true;
        }
    }

    public void clickButtonLogo() {
        click(By.xpath("//img[@alt='Tricentis Demo Web Shop']"));
    }


    public String takeScreenshot() {
        File screenshot=new File("src/test_screenshots/screen-"+System.currentTimeMillis()+".png");
        try {
            File tmp=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(tmp.toPath(), screenshot.toPath());
        } catch (IOException e) {
            logger.error("Failed to save screenshot", e);
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();

    }
}
