package com.zebrunner.carina.demo.HomeworkTestCases;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.android.ProductPage;
import com.zebrunner.carina.demo.mobile.gui.pages.android.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProductCard implements IAbstractTest {

    @Test
    public void testProductCard() {
        
        String username = "standard_user";
        String password = "secret_sauce";
        String product = "Sauce Labs Backpack";


        WebDriver driver = null;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, password);

        ProductPage productsPage = new ProductPage(driver);
        productsPage.openProductPage(product);

        
        ProductPage productPage = new ProductPage(driver);

        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened for " + product);
        Assert.assertEquals(productPage.getProductName(), product, "Product name is incorrect.");
        Assert.assertTrue(productPage.isProductImageDisplayed(), "Product image is not displayed.");
        Assert.assertTrue(productPage.isProductDescriptionDisplayed(), "Product description is not displayed.");
    }
}
