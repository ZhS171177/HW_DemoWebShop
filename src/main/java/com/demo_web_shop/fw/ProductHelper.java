package com.demo_web_shop.fw;

import com.demo_web_shop.core.BaseHelper;
import com.demo_web_shop.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductHelper extends BaseHelper {

    public ProductHelper(WebDriver driver) {
        super(driver);
    }


    private void selectProductWoSubcategory(By categoryProduct, By subCategoryProduct, By productName) {
        click(categoryProduct);
        click(subCategoryProduct);
        click(productName);
    }

    public void deleteOneArticleFromCart() {
        clickButtonShoppingCart();
        click(By.xpath("//input[@name='removefromcart']"));
        click(By.xpath("//input[@name='updatecart']"));
    }

    public void deleteAllArticleFromCard() {
        clickButtonShoppingCart();
        if (!(isElementPresent(By.xpath("//div[contains(text(),'Your Shopping Cart is empty!')]")))) {
            List<WebElement> items = driver.findElements(By.xpath("//input[@name='removefromcart']"));
            System.out.println("size for delete= " + items.size());
            while (items.size() != 0) {
                deleteOneArticleFromCart();
                new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
                        numberOfElementsToBeLessThan(By.xpath("//input[@name='removefromcart']"), items.size()));
                items = driver.findElements(By.xpath("//input[@name='removefromcart']"));
            }
            System.out.println("size after delete= " + items.size());
        }
        clickButtonLogo();
        System.out.println("Homepage");
    }

    public void clickButtonShoppingCart() {
        click(By.xpath("//span[.='Shopping cart']"));
    }

    public void selectProduct(Product product) {
        switch (product.getCategory()) {
            case "Computer":
                click(By.xpath("(//a[contains(text(),'Computers')])[3]"));
                switch (product.getSubCategory()) {
                    case "Notebooks":
                        click(By.xpath("(//a[contains(text(), 'Notebooks')])[3]"));
                        switch (product.getProductName()) {
                            case "14.1-inch Laptop":
                                click(By.xpath("//a[.='14.1-inch Laptop']"));
                                click(By.xpath("//input[@id='add-to-cart-button-31']"));
                                break;
                            default:
                                System.out.println("Product " + product.getProductName() + " out of stock");
                        }
                    default:
                        System.out.println("Subcategory of products" + product.getSubCategory() + "out of stock");
                }
            default:
                System.out.println("Category of products" + product.getCategory() + "out of stock");
        }


    }

    public void selectProductWoSubcategory(Product product) {
        switch (product.getCategory()) {
            case "Apparel & Shoes":
                click(By.xpath("(//a[contains(text(),'Apparel & Shoes')])[3]"));
                switch (product.getProductName()) {
                    case "Blue and green Sneaker":
                        click(By.xpath("//a[.='Blue and green Sneaker']"));
                        click(By.xpath("//input[@id='add-to-cart-button-28']"));
                        break;
                    default:
                        System.out.println("Product " + product.getProductName() + " out of stock");
                }
            default:
                System.out.println("Category of products" + product.getCategory()+ "out of stock");
        }

    }
    public void selectProductWithSearch(String productName){
        type(By.xpath("//input[@id='small-searchterms']"), "Smartphone");
        click(By.xpath("//input[@value='Search']"));
        click(By.xpath("//a[.='Smartphone']"));
        click(By.xpath("//input[@id='add-to-cart-button-43']"));

    }


}





