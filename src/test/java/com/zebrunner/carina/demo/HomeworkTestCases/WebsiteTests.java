package com.zebrunner.carina.demo.HomeworkTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebsiteTests {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/dylannelson16/Downloads/chromedriver_mac_arm64 2/chromedriver");
        WebDriver driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void testLogin() {
        driver.get("https://www.saucedemo.com/login");


        WebElement usernameField = driver.findElement(By.id("standard_user"));
        WebElement passwordField = driver.findElement(By.id("secret_sauce"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();


        WebElement welcomeMessage = driver.findElement(By.xpath("//div[@class='welcome-message']"));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "Login was not successful.");
    }

    @Test(priority = 2)
    public void testCartValidation() {
        driver.get("https://www.saucedemo.com/cart");


        WebElement cartItemsContainer = driver.findElement(By.xpath("//div[@class='cart-items']"));
        WebElement totalPrice = driver.findElement(By.xpath("//div[@class='total-price']"));

        Assert.assertTrue(cartItemsContainer.isDisplayed(), "Cart items are not displayed.");
        Assert.assertTrue(totalPrice.isDisplayed(), "Total price is not displayed.");
    }

    @Test(priority = 3)
    public void testProductCard() {
        driver.get("https://www.saucedemo.com/product/some-product");

        // Validate product details on the page
        WebElement productName = driver.findElement(By.xpath("//h1[@class='product-name']"));
        WebElement productPrice = driver.findElement(By.xpath("//span[@class='product-price']"));
        WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='Add to Cart']"));

        Assert.assertTrue(productName.isDisplayed(), "Product name is not displayed.");
        Assert.assertTrue(productPrice.isDisplayed(), "Product price is not displayed.");
        Assert.assertTrue(addToCartButton.isDisplayed(), "Add to Cart button is not displayed.");
    }

    @Test(priority = 4)
    public void testSorting() {
        driver.get("https://www.saucedemo.com/products");


        WebElement sortByPriceButton = driver.findElement(By.xpath("//button[text()='Sort by Price']"));
        sortByPriceButton.click();


        WebElement product1Price = driver.findElement(By.xpath("//div[@class='product'][1]//span[@class='price']"));
        WebElement product2Price = driver.findElement(By.xpath("//div[@class='product'][2]//span[@class='price']"));
        WebElement product3Price = driver.findElement(By.xpath("//div[@class='product'][3]//span[@class='price']"));

        double price1 = Double.parseDouble(product1Price.getText().replace("$", ""));
        double price2 = Double.parseDouble(product2Price.getText().replace("$", ""));
        double price3 = Double.parseDouble(product3Price.getText().replace("$", ""));

        Assert.assertTrue(price1 <= price2 && price2 <= price3, "Products are not sorted by price correctly.");
    }

    @Test(priority = 5)
    public void testPageNavigation() {
        driver.get("https://www.saucedemo.com");


        WebElement aboutLink = driver.findElement(By.linkText("About"));
        aboutLink.click();


        String expectedUrl = "https://www.saucedemo.com/about";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl, "Page navigation to About page failed.");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
