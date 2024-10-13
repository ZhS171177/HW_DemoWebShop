package com.demo_web_shop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginPositiveTest extends TestBase {

    @Test
    public void loginDemoWebShopTest() {
        app.getUserHelper().loginDemoWebShop("fsddffg_1234@gmail.com", "QWERTqwe123!");

        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath(" //a[.='Log out']")));
    }
    @AfterMethod(enabled =false)
    public void terDown() {
        app.stop();//закрывает весь драйвер

    }
}
