package com.zebrunner.carina.demo.gui.pages.SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPages {

    private final WebDriver driver;

    private final By addToCartButton = By.xpath("//button[contains(text(), 'Add to cart')]");
    private final By cartTotalPrice = By.xpath("//div[@id='cart']//strong");
    private final By cartItemsCount = By.xpath("//table[@id='tbodyid']/tr");
    private final By productDetails = By.xpath("//div[@class='card-body']//h4");
    private final By productPrice = By.xpath("//div[@class='card-body']//h5");

    public ProductPages(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath("//h4[text()='" + productName + "']/following-sibling::p/a")).click();
        driver.findElement(addToCartButton).click();
    }

    public void openCart() {
        driver.findElement(By.id("cartur")).click();
    }

    public int getCartItemsCount() {
        return driver.findElements(cartItemsCount).size();
    }

    public boolean isCartTotalPriceCorrect() {
        String expectedTotalPrice = "$300"; // Update with the expected total price
        String actualTotalPrice = driver.findElement(cartTotalPrice).getText();
        return actualTotalPrice.equals(expectedTotalPrice);
    }

    public boolean isProductDetailsMatching(String productName) {
        String expectedDetails = productName + " details"; // Update with the expected product details
        String actualDetails = driver.findElement(productDetails).getText();
        return actualDetails.equals(expectedDetails);
    }

    public boolean isProductPriceCorrect(String productName) {
        String expectedPrice = "$100"; // Update with the expected product price
        String actualPrice = driver.findElement(productPrice).getText();
        return actualPrice.equals(expectedPrice);
    }

    public boolean isCartTotalPriceUpdated() {
        String updatedTotalPrice = "$400"; // Update with the updated total price
        String actualTotalPrice = driver.findElement(cartTotalPrice).getText();
        return actualTotalPrice.equals(updatedTotalPrice);
    }

    public void selectProduct(String s) {

    }
}
