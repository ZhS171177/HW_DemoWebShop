package com.demo_web_shop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        try {
            app.getUserHelper().logoutDemoWebShop();
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }


    @Test
    public void createAccountPositiveTests() {

        String email="ksddffg_"+System.currentTimeMillis()+"@gmail.com";
        String password="QWERTqwe123!";
        //app.getUserHelper().registerDemoWebShop("ksddffg_1234@gmail.com", "QWERTqwe123!", "Janne", "Smith", 0);
        app.getUserHelper().registerDemoWebShop(email, password, "Janne", "Smith", 0);
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//div[contains(text(),'Your registration completed')]")));
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath(" //a[.='Log out']")));
    }

    @AfterMethod
    public void postCondition() {
        try {
            app.getUserHelper().logoutDemoWebShop();
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

//    @AfterMethod(enabled = false)
//    public void terDown() {
//        app.stop();//закрывает весь драйвер
//
//    }
}
