package com.zebrunner.carina.demo.HomeworkTestCases;

import com.zebrunner.carina.demo.gui.pages.SauceDemo.HomePages;
import com.zebrunner.carina.demo.gui.pages.SauceDemo.ProductPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

//https://www.demoblaze.com/

public class ProductCartCheckTest {

    private WebDriver driver;
    private HomePages homePages;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePages = new HomePages(driver);
    }

    @Test
    public void testProductCartCheck() {

        homePages.open();
        homePages.navigateToLaptopsSection();

        ProductPages productPage = new ProductPages(driver);
        productPage.addToCart("Laptop 1");
        productPage.addToCart("Laptop 2");
        productPage.addToCart("Laptop 3");

        Assert.assertEquals(homePages.getCartItemCount(), 3, "Incorrect number of items in the cart.");
        productPage.openCart();
        Assert.assertEquals(productPage.getCartItemsCount(), 3, "Not all products are added to the cart.");
        Assert.assertTrue(productPage.isCartTotalPriceCorrect(), "Cart total price is incorrect.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

