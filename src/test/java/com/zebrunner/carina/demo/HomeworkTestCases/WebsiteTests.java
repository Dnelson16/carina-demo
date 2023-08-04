package com.zebrunner.carina.demo.HomeworkTestCases;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class WebsiteTests implements IAbstractTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/dylannelson16/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSauceDemoLogin() {
        // Open SauceDemo login page and verify page is opened
        driver.get("https://www.saucedemo.com/");
        Assert.assertTrue(driver.getTitle().contains("Swag Labs"), "Login page is not opened.");

        // Locate the username and password input fields using XPath
        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));

        // Enter login credentials
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");

        // Locate and click the login button using XPath
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='LOGIN']"));
        loginButton.click();

        // Verify successful login by checking the presence of the products page element
        WebElement productsLabel = driver.findElement(By.xpath("//div[@class='product_label']"));
        Assert.assertTrue(productsLabel.isDisplayed(), "Login failed. Products page not displayed.");
    }

    @Test
    public void testSauceDemoProductPage() {
        // Log in to SauceDemo website
        testSauceDemoLogin();

        // Open the product page and verify it is opened
        driver.get("https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(driver.getTitle().contains("Swag Labs"), "Product page is not opened.");

        // Add a product to the cart
        WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
        addToCartButton.click();

        // Verify that the cart icon has a badge indicating one item added
        WebElement cartBadge = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        Assert.assertEquals(cartBadge.getText(), "1", "Cart badge count is incorrect.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

































//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class WebsiteTests {
//
//    private WebDriver driver;
//
//    @BeforeClass
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/dylannelson16/Downloads/chromedriver_mac_arm64 2/chromedriver");
//        WebDriver driver = new ChromeDriver();
//    }
//
//    @Test(priority = 1)
//    public void testLogin() {
//        driver.get("https://www.saucedemo.com/login");
//
//
//        WebElement usernameField = driver.findElement(By.id("standard_user"));
//        WebElement passwordField = driver.findElement(By.id("secret_sauce"));
//        WebElement loginButton = driver.findElement(By.id("login-button"));
//
//        usernameField.sendKeys("standard_user");
//        passwordField.sendKeys("secret_sauce");
//        loginButton.click();
//
//
//        WebElement welcomeMessage = driver.findElement(By.xpath("//div[@class='welcome-message']"));
//        Assert.assertTrue(welcomeMessage.isDisplayed(), "Login was not successful.");
//    }
//
//    @Test(priority = 2)
//    public void testCartValidation() {
//        driver.get("https://www.saucedemo.com/cart");
//
//
//        WebElement cartItemsContainer = driver.findElement(By.xpath("//div[@class='cart-items']"));
//        WebElement totalPrice = driver.findElement(By.xpath("//div[@class='total-price']"));
//
//        Assert.assertTrue(cartItemsContainer.isDisplayed(), "Cart items are not displayed.");
//        Assert.assertTrue(totalPrice.isDisplayed(), "Total price is not displayed.");
//    }
//
//    @Test(priority = 3)
//    public void testProductCard() {
//        driver.get("https://www.saucedemo.com/product/some-product");
//
//        // Validate product details on the page
//        WebElement productName = driver.findElement(By.xpath("//h1[@class='product-name']"));
//        WebElement productPrice = driver.findElement(By.xpath("//span[@class='product-price']"));
//        WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='Add to Cart']"));
//
//        Assert.assertTrue(productName.isDisplayed(), "Product name is not displayed.");
//        Assert.assertTrue(productPrice.isDisplayed(), "Product price is not displayed.");
//        Assert.assertTrue(addToCartButton.isDisplayed(), "Add to Cart button is not displayed.");
//    }
//
//    @Test(priority = 4)
//    public void testSorting() {
//        driver.get("https://www.saucedemo.com/products");
//
//
//        WebElement sortByPriceButton = driver.findElement(By.xpath("//button[text()='Sort by Price']"));
//        sortByPriceButton.click();
//
//
//        WebElement product1Price = driver.findElement(By.xpath("//div[@class='product'][1]//span[@class='price']"));
//        WebElement product2Price = driver.findElement(By.xpath("//div[@class='product'][2]//span[@class='price']"));
//        WebElement product3Price = driver.findElement(By.xpath("//div[@class='product'][3]//span[@class='price']"));
//
//        double price1 = Double.parseDouble(product1Price.getText().replace("$", ""));
//        double price2 = Double.parseDouble(product2Price.getText().replace("$", ""));
//        double price3 = Double.parseDouble(product3Price.getText().replace("$", ""));
//
//        Assert.assertTrue(price1 <= price2 && price2 <= price3, "Products are not sorted by price correctly.");
//    }
//
//    @Test(priority = 5)
//    public void testPageNavigation() {
//        driver.get("https://www.saucedemo.com");
//
//
//        WebElement aboutLink = driver.findElement(By.linkText("About"));
//        aboutLink.click();
//
//
//        String expectedUrl = "https://www.saucedemo.com/about";
//        String actualUrl = driver.getCurrentUrl();
//
//        Assert.assertEquals(actualUrl, expectedUrl, "Page navigation to About page failed.");
//    }
//
//    @AfterClass
//    public void tearDown() {
//
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
