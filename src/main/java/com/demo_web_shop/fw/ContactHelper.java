package com.demo_web_shop.fw;

import com.demo_web_shop.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver){
        super(driver);
    }

    public void addArticle_2_InCart() {
        click(By.xpath("(//a[contains(text(),'Apparel & Shoes')])[3]"));
        click(By.xpath("(//input[@value='Add to cart'])[2]"));
        click(By.xpath("//input[@id='add-to-cart-button-28']"));
        Assert.assertTrue(isElementPresent(By.xpath
                ("//p[contains(text(),'The product has been added to your ')]")));
    }

    public void addArticle_1_InCart() {
        click(By.xpath("(//a[contains(text(),'Computers')])[3]"));
        click(By.xpath("(//a[contains(text(), 'Notebooks')])[3]"));
        click(By.cssSelector("input[value='Add to cart']"));
        Assert.assertTrue(isElementPresent(By.xpath
                ("//p[contains(text(),'The product has been added to your ')]")));
    }

    public void deleteOneArticleFromCart() {
        clickButtonShoppingCart();
        click(By.xpath("//input[@name='removefromcart']"));
        click(By.xpath("//input[@name='updatecart']"));
    }

    public void deleteAllArticleFromCard() {
        clickButtonShoppingCart();
        if(!(isElementPresent(By.xpath("//div[contains(text(),'Your Shopping Cart is empty!')]")))) {
            List<WebElement> items = driver.findElements(By.xpath("//input[@name='removefromcart']"));
            System.out.println("size for delete= " + items.size());
            while (items.size() != 0) {
                deleteOneArticleFromCart();
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                        numberOfElementsToBeLessThan(By.xpath("//input[@name='removefromcart']"), items.size()));
                items =driver.findElements(By.xpath("//input[@name='removefromcart']"));
            }
            System.out.println("size after delete= " + items.size());
        }
        clickButtonLogo();
        System.out.println("Homepage");
    }

   public void clickButtonShoppingCart() {
        click(By.xpath("//span[.='Shopping cart']"));
    }
}
