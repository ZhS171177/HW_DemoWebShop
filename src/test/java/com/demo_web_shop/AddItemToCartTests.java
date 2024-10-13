package com.demo_web_shop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void PreCondition() {
        try {
            app.getUserHelper().loginDemoWebShop("fsddffg_1234@gmail.com", "QWERTqwe123!");
            app.getContactHelper().deleteAllArticleFromCard();
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void addItemCartPositiveTest() {
        app.getContactHelper().addArticle_1_InCart();
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//span[.='(1)']")));
        app.getContactHelper().addArticle_2_InCart();
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//span[.='(2)']")));
        System.out.println("Two products added");
        app.getContactHelper().clickButtonShoppingCart();
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath
                ("//tbody/tr[1]/td[3]/a[contains(text(),'14.1-inch Laptop')]")));
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath
                ("//tbody/tr[2]/td[3]/a[contains(text(),'Blue and green Sneaker')]")));
        app.getHomeHelper().clickButtonLogo();
        System.out.println("Homepage");
    }

    @AfterMethod
    public void postCondition() {
        app.getContactHelper().deleteAllArticleFromCard();
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//span[.='(0)']")));
        System.out.println("Отработал postCondition Корзина очищена");

    }

}


