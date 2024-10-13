package com.demo_web_shop.fw;

import com.demo_web_shop.core.BaseHelper;
import com.demo_web_shop.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void loginDemoWebShop(String email, String password) {
        clickLoginLinkDemoWebShop();
        type(By.name("Email"), email);
        type(By.name("Password"), password);
        click(By.xpath("//input[@value='Log in']"));
        Assert.assertTrue(isElementPresent(By.xpath("//a[.='Log out']")));
    }

    public void logoutDemoWebShop() {
        click(By.xpath("//a[.='Log out']"));
    }

    protected void clickRegistrationButtonDemoWebShop() {
        click(By.xpath("//input[@value='Register']"));
    }

    protected void clickLoginLinkDemoWebShop() {
        click(By.xpath("//a[.='Log in']"));
    }

    public void registerDemoWebShop(String email, String password, String firstName, String lastName, int gender) {
        click(By.xpath("//a[.='Register']"));
        clickInRadioButtonGender(gender);
        fillRegistrationForm(new User()
                .setFirstName(firstName)
                        .setLastName(lastName)
                                .setPassword(password)
                                        .setEmail(email));
        click(By.xpath("//input[@value='Register']"));
    }

    private void fillRegistrationForm(User user) {
        type(By.name("FirstName"), user.getFirstName());
        type(By.name("LastName"), user.getLastName());
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getPassword());
        clickInRadioButtonGender(user.getGender());
    }

    public void clickInRadioButtonGender(int gender){
        switch (gender){
            case 1: click(By.xpath("//*[@value='M']"));
            break;
            case 0: click(By.xpath("//*[@value='F']"));
            break;
            default:
                System.out.println("Введите значения /M/ или /F/ ");
        }
    }

    protected boolean isError409Present() {
        return isElementPresent(By.xpath("//div[.='Registration failed with code 409']"));
    }
}
