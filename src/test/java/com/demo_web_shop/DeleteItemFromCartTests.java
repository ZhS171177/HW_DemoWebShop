package com.demo_web_shop;

import com.demo_web_shop.model.Product;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteItemFromCartTests extends TestBase {


    @BeforeMethod
    public void PreCondition() {
        try {
            app.getUserHelper().loginDemoWebShop("fsddffg_1234@gmail.com", "QWERTqwe123!");
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }
        app.getContactHelper().deleteAllArticleFromCard();
        app.getContactHelper()
                .selectProduct(new Product()
                        .setCategory("Computer")
                        .setSubCategory("Notebooks")
                        .setProductName("14.1-inch Laptop"));
        app.getContactHelper()
                .selectProductWoSubcategory(new Product()
                        .setCategory("Apparel & Shoes")
                        .setProductName("Blue and green Sneaker"));
    }
@Test
public void deleteAllItemsFromCartTest(){
        app.getHomeHelper().isElementPresent(By.xpath("//span[.='(2)']"));
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
