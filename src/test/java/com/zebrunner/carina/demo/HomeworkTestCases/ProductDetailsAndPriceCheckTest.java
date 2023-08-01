package com.zebrunner.carina.demo.HomeworkTestCases;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.SauceDemo.HomePages;
import com.zebrunner.carina.demo.gui.pages.SauceDemo.ProductPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

//// https://www.demoblaze.com/

public class ProductDetailsAndPriceCheckTest implements IAbstractTest {

    private WebDriver driver;
    private HomePages homePages;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePages = new HomePages(driver);
    }

    @Test
    @MethodOwner(owner = "Dnelson")
    public void testProductDetailsAndPriceCheck() {

        homePages.open();
        homePages.navigateToTabletsSection();

        ProductPages productPage = new ProductPages(driver);
        productPage.selectProduct("Tablet 1");


        Assert.assertTrue(productPage.isProductDetailsMatching("Tablet 1"), "Product details do not match.");
        Assert.assertTrue(productPage.isProductPriceCorrect("Tablet 1"), "Product price is incorrect.");

        productPage.addToCart("Tablet 1");
        Assert.assertTrue(productPage.isCartTotalPriceUpdated(), "Cart total price is not updated.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

