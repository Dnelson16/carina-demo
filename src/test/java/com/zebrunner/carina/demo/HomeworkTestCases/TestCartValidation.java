package com.zebrunner.carina.demo.HomeworkTestCases;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.android.CartPage;
import com.zebrunner.carina.demo.gui.pages.android.CheckoutPage;
import com.zebrunner.carina.demo.gui.pages.android.ProductPage;
import com.zebrunner.carina.demo.mobile.gui.pages.android.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCartValidation implements IAbstractTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/dylannelson16/Documents/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @MethodOwner(owner = "Dnelson")
    public void testCartValidation() {

        String username = "standard_user";
        String password = "secret_sauce";
        String product1 = "Sauce Labs Backpack";
        String product2 = "Sauce Labs Bike Light";
        String product3 = "Sauce Labs Bolt T-Shirt";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, password);

        ProductPage productsPage = new ProductPage(driver);
        productsPage.addToCart(product1);
        productsPage.addToCart(product2);
        productsPage.addToCart(product3);

        CartPage cartPage = productsPage.openCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened.");

        Assert.assertTrue(cartPage.isProductInCart(product1), "Product 1 is not in the cart.");
        Assert.assertTrue(cartPage.isProductInCart(product2), "Product 2 is not in the cart.");
        Assert.assertTrue(cartPage.isProductInCart(product3), "Product 3 is not in the cart.");

        Assert.assertEquals(cartPage.getCartItemsCount(), 3, "Cart items count is incorrect.");

        cartPage.goToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutInformation("John Doe", "123 Main St", "12345");
        checkoutPage.finishCheckout();

        Assert.assertTrue(checkoutPage.isOrderCompleted(), "Order completion message is not displayed.");
    }
}
