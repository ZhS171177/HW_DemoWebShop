package com.demo_web_shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteItemFromCartTests extends TestBase {


    @BeforeMethod
    public void PreCondition() {
        app.getUserHelper().loginDemoWebShop("fsddffg_1234@gmail.com", "QWERTqwe123!");
        app.getContactHelper().deleteAllArticleFromCard();
        app.getContactHelper().addArticle_1_InCart();
        app.getContactHelper().addArticle_2_InCart();
    }
@Test
public void deleteAllItemsFromCartTest(){
    WebElement element = app.driver.findElement(By.xpath("//span[.='(2)']"));
    app.getContactHelper().deleteAllArticleFromCard();
    Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//span[.='(0)']")));
    app.getContactHelper().clickButtonShoppingCart();
    Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath
            ("//div[contains(text(),'Your Shopping Cart is empty!')]")));
}

    @AfterMethod
    public void postCondition() {
        System.out.println("Отработал postCondition Корзина очищена");

    }
}
