package com.demo_web_shop;

import com.demo_web_shop.core.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", "chrome"));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

//    @BeforeMethod
//    public void setUp() {
//        app.init();
//        logger.info("Тесты проходят, ВАУУУУУУ!!!!!");
//
//    }

    @BeforeSuite
    public void setUp() {
        logger.info("*****************************Testing in progress****************************");
        app.init();
    }

    @BeforeMethod
    public void startTest(Method method){
        logger.info("Test is started ["+ method.getName()+"]");
    }

//    @AfterMethod(enabled = false)
//    public void terDown() {
//        app.stop();//закрывает весь драйвер
//
//    }


    @AfterMethod
    public void stopTest(Method method, ITestResult result, ITestContext context) {

        StringBuilder parameters = new StringBuilder();
        for (String key : context.getAttributeNames()) {
            Object value = context.getAttribute(key);
            parameters.append(key).append("=").append(value).append(", ");
        }

        if (parameters.length() > 0) {
            parameters.setLength(parameters.length() - 2);
        }

        logger.info("Test is started with date:[" + parameters + "]");

        if (result.isSuccess()) {
            logger.info("Test is PASSED: [" + method.getName() + "]");
        } else {
            // Теперь делаем скриншот
            String screenshotPath = app.getUserHelper().takeScreenshot();
            logger.error("Test is FAILED: [" + method.getName() + "], Screenshot: [" + screenshotPath + "]");
        }
        logger.info("Test is ended: [" + method.getName() + "]");
    }

    @AfterSuite(enabled = true)
    public void terDown() {
        logger.info("*****************************All test end****************************");
        app.stop();

    }

}


